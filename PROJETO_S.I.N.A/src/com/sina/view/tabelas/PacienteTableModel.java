/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sina.view.tabelas;

import com.sina.model.entities.Paciente;
import com.sina.model.entities.Prestador;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Danilo
 */
public class PacienteTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private static final int COL_CNES = 2;
    private List<Paciente> valores;

    public PacienteTableModel(List<Paciente> valores) {
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
        Paciente paciente = valores.get(rowIndex);
        if (columnIndex == COL_ID) {
            return paciente.getCodPaciente();
        } else if (columnIndex == COL_NOME) {
            return paciente.getNome();
        } else if (columnIndex == COL_CNES) {
            return paciente.getMunicipio();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String colunas = "";
        switch (column) {
            case COL_ID:
                colunas = "CÓDIGO";
                break;
            case COL_NOME:
                colunas = "NOME";
                break;
            case COL_CNES:
                colunas = "MUNÍCIPIO";
                break;
            default:
                throw new IllegalArgumentException("Coluna Inválida!");
        }
        return colunas;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == COL_ID) {
            return Integer.class;
        } else if (columnIndex == COL_NOME) {
            return String.class;
        }else if (columnIndex == COL_CNES) {
            return String.class;
        }
        return null;
    }

    public Paciente get(int row) {
        return valores.get(row);
    }
}
