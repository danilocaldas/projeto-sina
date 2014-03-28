/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sina.view.componentes;

/**
 *
 * @author ritacosta
 */
public class BarraCruBtnMini extends javax.swing.JPanel {

    /**
     * Creates new form BarraCruBtn
     */
    public BarraCruBtnMini() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnNovo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.setToolTipText("Clique aqui para adicionar um novo registro..");
        btnNovo.setFocusable(false);
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setMaximumSize(new java.awt.Dimension(80, 30));
        btnNovo.setMinimumSize(new java.awt.Dimension(80, 30));
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnNovo);

        btnSalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.setToolTipText("Clique aqui para salvar um novo registro..");
        btnSalvar.setFocusable(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setMaximumSize(new java.awt.Dimension(80, 30));
        btnSalvar.setMinimumSize(new java.awt.Dimension(80, 30));
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnSalvar);

        btnAtualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAtualizar.setText("ATUALIZAR");
        btnAtualizar.setToolTipText("Clique aqui para atualizar um registro...");
        btnAtualizar.setFocusable(false);
        btnAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAtualizar.setMaximumSize(new java.awt.Dimension(80, 30));
        btnAtualizar.setMinimumSize(new java.awt.Dimension(80, 30));
        btnAtualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnAtualizar);

        btnExcluir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.setToolTipText("Clique aqui para remover um registro..");
        btnExcluir.setFocusable(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setMaximumSize(new java.awt.Dimension(80, 30));
        btnExcluir.setMinimumSize(new java.awt.Dimension(80, 30));
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnExcluir);

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setToolTipText("Clica aqui para cancelar a inclusão");
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setMaximumSize(new java.awt.Dimension(80, 30));
        btnCancelar.setMinimumSize(new java.awt.Dimension(80, 30));
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtnAtualizar() {
        return btnAtualizar;
    }

    public void setBtnAtualizar(javax.swing.JButton btnAtualizar) {
        this.btnAtualizar = btnAtualizar;
    }

    public javax.swing.JButton getBtnExcluir() {
        return btnExcluir;
    }

    public void setBtnExcluir(javax.swing.JButton btnExcluir) {
        this.btnExcluir = btnExcluir;
    }

    public javax.swing.JButton getBtnFechar() {
        return btnCancelar;
    }

    public void setBtnFechar(javax.swing.JButton btnFechar) {
        this.btnCancelar = btnFechar;
    }

    public javax.swing.JButton getBtnNovo() {
        return btnNovo;
    }

    public void setBtnNovo(javax.swing.JButton btnNovo) {
        this.btnNovo = btnNovo;
    }

    public javax.swing.JButton getBtnSalvar() {
        return btnSalvar;
    }

    public void setBtnSalvar(javax.swing.JButton btnSalvar) {
        this.btnSalvar = btnSalvar;
    }

    public javax.swing.JToolBar getjToolBar1() {
        return jToolBar1;
    }

    public void setjToolBar1(javax.swing.JToolBar jToolBar1) {
        this.jToolBar1 = jToolBar1;
    }


}