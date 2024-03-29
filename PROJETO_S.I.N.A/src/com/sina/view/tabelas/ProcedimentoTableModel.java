/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sina.view.tabelas;

import com.sina.model.entities.Procedimento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Danilo
 */
public class ProcedimentoTableModel extends AbstractTableModel {

    private static final int COL_CODPROCEDIMENTO = 0;
    private static final int COL_NOME = 1;
    private static final int COL_CODIGO = 2;
    private List<Procedimento> valores;

    public ProcedimentoTableModel(List<Procedimento> valores) {
        this.valores = valores;
    }

    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Procedimento procedimento = valores.get(rowIndex);
        if (columnIndex == COL_CODPROCEDIMENTO) {
            return procedimento.getCodProcedimento();
        } else if (columnIndex == COL_NOME) {
            return procedimento.getNome();
        } else if (columnIndex == COL_CODIGO) {
            return procedimento.getCodigo();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String colunas = "";
        switch (column) {
            case COL_CODPROCEDIMENTO:
                colunas = "CÓDIGO";
                break;
            case COL_NOME:
                colunas = "NOME";
                break;
            case COL_CODIGO:
                colunas = "CÓDIGO PROC.";
                break;
            default:
                throw new IllegalArgumentException("Coluna Inválida!");
        }
        return colunas;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == COL_CODPROCEDIMENTO) {
            return Integer.class;
        } else if (columnIndex == COL_NOME) {
            return String.class;
        }else if (columnIndex == COL_CODIGO) {
            return String.class;
        }
        return null;
    }

    public Procedimento get(int row) {
        return valores.get(row);
    }
}
