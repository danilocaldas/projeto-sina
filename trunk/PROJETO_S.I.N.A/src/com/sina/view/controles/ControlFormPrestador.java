/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sina.view.controles;

import com.sina.control.facade.PrestadorFacade;
import com.sina.model.entities.Prestador;
import com.sina.view.formularios.FormManuntencaoPrestador;
import com.sina.view.tabelas.PrestadorTableModel;
import com.sina.view.tabelas.render.ProcPrestCellRenderer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe responsável por gerenciar todos os eventos do formulário do prestador
 *
 * @author ritacosta
 */
public class ControlFormPrestador implements ActionListener {

    public FormManuntencaoPrestador frm;
    private Integer codigo;
    private List<Prestador> listPrestadores;

    public ControlFormPrestador(FormManuntencaoPrestador frm) {
        this.frm = frm;
        addButonsToForm();
        this.frm.getTxtCodigo().setEnabled(false);
        enabledDisabled(true);
        mostrarPrestador();
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
        this.frm.getTxtCnes().setEnabled(!enabled);
    }

    //limpando todos os campos de texto.
    private void limparCampos() {
        this.frm.getTxtNome().setText("");
        this.frm.getTxtCnes().setText("");
        this.frm.getTxtCodigo().setText("");
    }

    /**
     * Metodo que compara se Objeto do tipo Prestador já está inserido na base
     * de dados se não houver Registro insere o Prestador senão Atualiza
     * Prestador.
     */
    private void salvarOuAtualizar() {
        String nome = frm.getTxtNome().getText();
        String cnes = frm.getTxtCnes().getText();
        if ("".equals(nome) || "".equals(cnes)) {
            JOptionPane.showMessageDialog(frm, "Todos os campos devem ser preenhidos.",
                    "Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Prestador prestador = new Prestador();
        prestador.setNome(frm.getTxtNome().getText().toUpperCase());
        prestador.setCnes(frm.getTxtCnes().getText().toUpperCase());
        PrestadorFacade facade = new PrestadorFacade();
        if (codigo == null) {
            facade.salvarPrestador(prestador);
            mostrarPrestador();
        } else {
            prestador.setCodPrestador(codigo);
            facade.atualizarPrestador(prestador);
            mostrarPrestador();
        }
    }

    /**
     * Metodo que testa se foi selecionada um linha da tabela e se houver
     * seleção pega o valor do abjeto e para poder fazer a exclusão na base de
     * dados.
     */
    private void excluir() {
        int rowIndex = frm.getTbPrestadores().getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(frm, "Selecione um registro a ser removido!");
            return;
        }
        Prestador prestador = new PrestadorTableModel(listPrestadores).get(rowIndex);
        int confirm = JOptionPane.showConfirmDialog(frm, "Confirmar a exclusão?", "Excluir Prestador", JOptionPane.YES_NO_OPTION);
        if (confirm != 0) {
            return;
        }
        PrestadorFacade facade = new PrestadorFacade();
        facade.deletarPrestador(prestador);
        mostrarPrestador();
    }

    /**
     * Metodo que Verifica se um registro foi selecionado na tabela e somente
     * após a selecão leva os dados do Objeto preenchido para os campos de
     * textos para alteração
     */
    private void prepararAtualizar() {
        int rowIndex = frm.getTbPrestadores().getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(frm, "Selecione um registro a ser alterado!");
            return;
        }
        
        Prestador prestador = new PrestadorTableModel(listPrestadores).get(rowIndex);
        codigo = prestador.getCodPrestador();
        frm.getTxtCodigo().setText(String.valueOf(prestador.getCodPrestador()));
        frm.getTxtNome().setText(prestador.getNome());
        frm.getTxtCnes().setText(prestador.getCnes());
        enabledDisabled(false);
        frm.getTxtCodigo().setBackground(Color.yellow);
    }

    /**
     * Metodo que retorna uma lista dos prestadores setando o
     * modelo(PrestadorTableModel)
     */
    private void mostrarPrestador() {
        listPrestadores = (List<Prestador>) new PrestadorFacade().listarPrestador(Prestador.class);
        if (listPrestadores != null) {
            frm.getTbPrestadores().setModel(new PrestadorTableModel(listPrestadores));
            frm.getTbPrestadores().setDefaultRenderer(Object.class, new ProcPrestCellRenderer());
        }
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
