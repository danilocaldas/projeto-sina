/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sina.view.controles;

import com.sina.control.facade.PacienteFacade;
import com.sina.model.entities.Paciente;
import com.sina.view.formularios.FormManuntencaoPacientes;
import com.sina.view.tabelas.PacienteTableModel;
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
public class ControlFormPaciente implements ActionListener {

    public FormManuntencaoPacientes frm;
    private List<Paciente> listPacientes;
    private Integer codigo;

    public ControlFormPaciente(FormManuntencaoPacientes frm) {
        this.frm = frm;
        addBtnToForm();
        enabledDisabled(true);
        frm.getTxtCodigo().setEnabled(false);
        mostrarPaciente();
    }

    private void addBtnToForm() {
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
        this.frm.getComboMunicipios().setEnabled(!enabled);
    }

    //limpando todos os campos de texto.
    private void limparCampos() {
        this.frm.getTxtNome().setText("");
        this.frm.getTxtCodigo().setText("");
    }

    //posicionando a lista do combox municipios na possição zero
    private void posicaoComboBox() {
        this.frm.getComboMunicipios().setSelectedIndex(0);
    }

    /**
     * Metodo que compara se Objeto do tipo Praciente já está inserido na base
     * de dados se não houver Registro insere o Paciente senão Atualiza
     * Paciente.
     */
    private void salvarOuAtualizar() {
        String nome = frm.getTxtNome().getText();
        if ("".equals(nome) || frm.getComboMunicipios().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(frm, "Todos os campos devem ser preenhidos.",
                    "Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Paciente paciente = new Paciente();
        paciente.setNome(frm.getTxtNome().getText().toUpperCase());
        paciente.setMunicipio(frm.getComboMunicipios().getSelectedItem().toString().toUpperCase());
        PacienteFacade facade = new PacienteFacade();
        if (codigo == null) {
            facade.salvarPaciente(paciente);
            mostrarPaciente();
            limparCampos();
            posicaoComboBox();
            enabledDisabled(true);
        } else {
            paciente.setCodPaciente(codigo);
            facade.atualizarPaciente(paciente);
            mostrarPaciente();
            limparCampos();
            posicaoComboBox();
            enabledDisabled(true);
        }
    }

    /**
     * Metodo que testa se foi selecionada um linha da tabela e se houver
     * seleção pega o valor do abjeto e para poder fazer a exclusão na base de
     * dados.
     */
    private void excluir() {
        int rowIndex = frm.getTbPacientes().getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(frm, "Selecione um registro a ser removido!");
            return;
        }
        Paciente procedimento = new PacienteTableModel(listPacientes).get(rowIndex);
        int confirm = JOptionPane.showConfirmDialog(frm, "Confirmar a exclusão?", "Excluir Paciente", JOptionPane.YES_NO_OPTION);
        if (confirm != 0) {
            return;
        }
        PacienteFacade facade = new PacienteFacade();
        facade.deletarPaciente(procedimento);
        mostrarPaciente();
    }

    /**
     * Metodo que Verifica se um registro foi selecionado na tabela e somente
     * após a selecão leva os dados do Objeto preenchido para os campos de
     * textos para alteração
     */
    private void prepararAtualizar() {
        int rowIndex = frm.getTbPacientes().getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(frm, "Selecione um registro a ser alterado!");
            return;
        }
        Paciente paciente = new PacienteTableModel(listPacientes).get(rowIndex);
        codigo = paciente.getCodPaciente();
        frm.getTxtCodigo().setText(String.valueOf(paciente.getCodPaciente()));
        frm.getTxtNome().setText(paciente.getNome());
        frm.getComboMunicipios().setSelectedItem(paciente.getMunicipio());
        enabledDisabled(false);
        frm.getTxtCodigo().setBackground(Color.yellow);
    }

    /**
     * Metodo que retorna uma lista dos prestadores setando o
     * modelo(PrestadorTableModel)
     */
    private void mostrarPaciente() {
        listPacientes = (List<Paciente>) new PacienteFacade().listarPaciente(Paciente.class);
        if (listPacientes != null) {
            frm.getTbPacientes().setModel(new PacienteTableModel(listPacientes));
            frm.getTbPacientes().setDefaultRenderer(Object.class, new ProcPrestCellRenderer());
        }
    }

    //limpar selecao da tabela
    private void limparSelecao() {
        frm.getTbPacientes().getSelectionModel().clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "NOVO":
                enabledDisabled(false);
                limparCampos();
                limparSelecao();
                break;
            case "SALVAR":
                salvarOuAtualizar();
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
                limparSelecao();
                posicaoComboBox();
                break;
        }
    }

}
