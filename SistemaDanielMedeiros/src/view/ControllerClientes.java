package view;

import bean.DhmClientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerClientes extends AbstractTableModel {

    private List DhmClientes;

    public void setList(List DhmClientes) {
        this.DhmClientes = DhmClientes;
        fireTableDataChanged(); // ← IMPORTANTE: atualiza a tabela
    }
    
    public DhmClientes getBean(int rowIndex) {
        return (DhmClientes) DhmClientes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return DhmClientes.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DhmClientes clientes = (DhmClientes) DhmClientes.get(rowIndex);
        if (columnIndex == 0) {
            return clientes.getDhmIdCliente();
        } else if (columnIndex == 1) {
            return clientes.getDhmNome();        
        } else if (columnIndex == 2) {
            return clientes.getDhmCpf();
        } else if (columnIndex == 3) {
            return clientes.getDhmTelefone();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Nome";         
        } else if (columnIndex == 2) {
            return "CPF";
        } else if (columnIndex == 3) {
            return "Telefone";
        } 
        return "";
    }
}