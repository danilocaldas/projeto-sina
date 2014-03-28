/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sina.view.controles;

import com.sina.view.formularios.FormManuntencaoPacientes;
import com.sina.view.formularios.FormManuntencaoPrestador;
import com.sina.view.formularios.FormManuntencaoProcedimento;
import com.sina.view.formularios.Sistema;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ritacosta
 */
public class ControlFormSistema implements ActionListener {

    public Sistema frm;
    public FormManuntencaoPrestador formP;
    public FormManuntencaoProcedimento formPro;
    public FormManuntencaoPacientes formPa;

    public ControlFormSistema(Sistema frm) {
        this.frm = frm;
        addButoesToForm();
    }

    private void addButoesToForm() {
        this.frm.getBtTestPrestador().addActionListener(this);
        this.frm.getBtnProcedimento().addActionListener(this);
        this.frm.getBtnPacientes().addActionListener(this);
    }

    public void abrirMenuInternalFramePrestador() {
        if (formP == null) {
            formP = new FormManuntencaoPrestador();
            frm.getjDesktopPaneSistema().add(formP);
            Component content = frm.getContentPane();
            int x = (content.getWidth() - formP.getWidth()) / 2;
            int y = (content.getHeight() - formP.getHeight()) / 2;
            formP.setLocation(x, y);
            formP.setVisible(true);
        } else {
            if (formP.isVisible()) {
                formP.pack();
            } else {
                frm.getjDesktopPaneSistema().add(formP);
                formP.setVisible(true);
            }

        }

    }

    public void abrirMenuInternalFrameProcedimento() {
        if (formPro == null) {
            formPro = new FormManuntencaoProcedimento();
            frm.getjDesktopPaneSistema().add(formPro);
            Component content = frm.getContentPane();
            int x = (content.getWidth() - formPro.getWidth()) / 2;
            int y = (content.getHeight() - formPro.getHeight()) / 2;
            formPro.setLocation(x, y);
            formPro.setVisible(true);
        } else {
            if (formPro.isVisible()) {
                formPro.pack();
            } else {
                frm.getjDesktopPaneSistema().add(formPro);
                formPro.setVisible(true);
            }

        }

    }

    public void abrirMenuInternalFramePacientes() {
        if (formPa == null) {
            formPa = new FormManuntencaoPacientes();
            frm.getjDesktopPaneSistema().add(formPa);
            Component content = frm.getContentPane();
            int x = (content.getWidth() - formPa.getWidth()) / 2;
            int y = (content.getHeight() - formPa.getHeight()) / 2;
            formPa.setLocation(x, y);
            formPa.setVisible(true);
        } else {
            if (formPa.isVisible()) {
                formPa.pack();
            } else {
                frm.getjDesktopPaneSistema().add(formPa);
                formPa.setVisible(true);
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Prestador":
                abrirMenuInternalFramePrestador();
                break;
            case "Procedimento":
                abrirMenuInternalFrameProcedimento();
                break;
            case "Pacientes":
                abrirMenuInternalFramePacientes();
                break;
        }
    }

}
