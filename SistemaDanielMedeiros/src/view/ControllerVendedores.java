package view;

import bean.DhmVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerVendedores extends AbstractTableModel {

    private List DhmVendedor;

    public void setList(List DhmVendedor) {
        this.DhmVendedor = DhmVendedor;
        fireTableDataChanged();
    }
    
    public DhmVendedor getBean(int rowIndex) {
        return (DhmVendedor) DhmVendedor.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return DhmVendedor.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DhmVendedor vendedor = (DhmVendedor) DhmVendedor.get(rowIndex);
        if (columnIndex == 0) {
            return vendedor.getDhmIdVendedor();
        } else if (columnIndex == 1) {
            return vendedor.getDhmNome();        
        } else if (columnIndex == 2) {
            return vendedor.getDhmCpf();
        } else if (columnIndex == 3) {
            return "R$ " + String.format("%.2f", vendedor.getDhmSalario());
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
            return "Salário";
        } 
        return "";
    }
}