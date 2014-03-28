/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sina.view.controles;

import com.sina.control.facade.ProcedimentoFacade;
import com.sina.model.entities.Procedimento;
import com.sina.view.formularios.FormManuntencaoProcedimento;
import com.sina.view.tabelas.ProcedimentoTableModel;
import com.sina.view.tabelas.render.ProcPrestCellRenderer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ritacosta
 */
public class ControlFormProcedimento implements ActionListener {

    public FormManuntencaoProcedimento frm;
    private Integer codigo;
    private List<Procedimento> listProcedimento;

    public ControlFormProcedimento(FormManuntencaoProcedimento frm) {
        this.frm = frm;
        addButonsToForm();
        this.frm.getTxtCodigo().setEnabled(false);
        enabledDisabled(true);
        mostrarProcedimento();
        frm.getTxtCodigoProcedimento().setEnabled(false);
    }

    //adionando o controle do botões do formulario ao controlador 
    private void addButonsToForm() {
        this.frm.getBarraCruBtnMini1().getBtnNovo().addActionListener(this);
        this.frm.getBarraCruBtnMini1().getBtnSalvar().addActionListener(this);
        this.frm.getBarraCruBtnMini1().getBtnAtualizar().addActionListener(this);
        this.frm.getBarraCruBtnMini1().getBtnExcluir().addActionListener(this);
        this.frm.getBarraCruBtnMini1().getBtnFechar().addActionListener(this);
    }

    /**
     *
     * @param enabled Se verdadeiro ativa os campos do formulário e botões
     * correspondente a ação Se Falso desativa os campos do formulário e botões
     * correspondente a ação
     */
    private void enabledDisabled(boolean enabled) {
        this.frm.getTxtNome().setEnabled(!enabled);
        this.frm.getTxtCodigo().setEnabled(!enabled);
    }

    //limpando todos os campos de texto.
    private void limparCampos() {
        this.frm.getTxtNome().setText("");
        this.frm.getTxtCodigo().setText("");
        this.frm.getTxtCodigoProcedimento().setText("");
    }

    /**
     * Metodo que compara se Objeto do tipo Prestador já está inserido na base
     * de dados se não houver Registro insere o Prestador senão Atualiza
     * Prestador.
     */
    private void salvarOuAtualizar() {
        String nome = frm.getTxtNome().getText();
        String codi = frm.getTxtCodigo().getText();
        if ("".equals(nome) || "".equals(codi)) {
            JOptionPane.showMessageDialog(frm, "Todos os campos devem ser preenhidos.",
                    "Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Procedimento procedimento = new Procedimento();
        procedimento.setNome(frm.getTxtNome().getText().toUpperCase());
        procedimento.setCodigo(frm.getTxtCodigo().getText().toUpperCase());
        ProcedimentoFacade facade = new ProcedimentoFacade();
        if (codigo == null) {
            facade.salvarProcedimento(procedimento);
            mostrarProcedimento();
        } else {
            procedimento.setCodProcedimento(codigo);
            facade.atualizarProcedimento(procedimento);
            mostrarProcedimento();
        }
    }

    /**
     * Metodo que testa se foi selecionada um linha da tabela e se houver
     * seleção pega o valor do abjeto e para poder fazer a exclusão na base de
     * dados.
     */
    private void excluir() {
        int rowIndex = frm.getTbProcedimento().getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(frm, "Selecione um registro a ser removido!");
            return;
        }
        Procedimento procedimento = new ProcedimentoTableModel(listProcedimento).get(rowIndex);
        int confirm = JOptionPane.showConfirmDialog(frm, "Confirmar a exclusão?", "Excluir Procedimento", JOptionPane.YES_NO_OPTION);
        if (confirm != 0) {
            return;
        }
        ProcedimentoFacade facade = new ProcedimentoFacade();
        facade.deletarProcedimento(procedimento);
        mostrarProcedimento();
    }

    /**
     * Metodo que Verifica se um registro foi selecionado na tabela e somente
     * após a selecão leva os dados do Objeto preenchido para os campos de
     * textos para alteração
     */
    private void prepararAtualizar() {
        int rowIndex = frm.getTbProcedimento().getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(frm, "Selecione um registro a ser alterado!");
            return;
        }

        Procedimento procedimento = new ProcedimentoTableModel(listProcedimento).get(rowIndex);
        codigo = procedimento.getCodProcedimento();
        frm.getTxtCodigoProcedimento().setText(String.valueOf(procedimento.getCodProcedimento()));
        frm.getTxtNome().setText(procedimento.getNome());
        frm.getTxtCodigo().setText(procedimento.getCodigo());
        enabledDisabled(false);
        frm.getTxtCodigo().setBackground(Color.yellow);
    }

    /**
     * Metodo que retorna uma lista dos prestadores setando o
     * modelo(PrestadorTableModel)
     */
    private void mostrarProcedimento() {
        listProcedimento = (List<Procedimento>) new ProcedimentoFacade().listarProcedimento(Procedimento.class);
        if (listProcedimento != null) {
            frm.getTbProcedimento().setModel(new ProcedimentoTableModel(listProcedimento));
            frm.getTbProcedimento().setDefaultRenderer(Object.class, new ProcPrestCellRenderer());
        }
    }

    private void limparSelecao() {
        frm.getTbProcedimento().getSelectionModel().clearSelection();
    }

    /**
     *
     * @param e retorna o comando de cada botão.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "NOVO":
                enabledDisabled(false);
                limparCampos();
                limparSelecao();
                break;

            case "SALVAR":
                salvarOuAtualizar();
                limparCampos();
                enabledDisabled(true);
                break;

            case "ATUALIZAR":
                prepararAtualizar();
                break;

            case "EXCLUIR":
                excluir();
                break;

            case "CANCELAR":
                enabledDisabled(true);
                limparCampos();
                break;
        }
    }

}
