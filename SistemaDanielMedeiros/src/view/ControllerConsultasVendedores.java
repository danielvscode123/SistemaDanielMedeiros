/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import bean.DhmVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerConsultasVendedores extends AbstractTableModel {

    private List lstDhmVendedor;

    public void setList(List lstDhmVendedor) {
        this.lstDhmVendedor = lstDhmVendedor;
        this.fireTableDataChanged();
        
    }
    
    public DhmVendedor getBean(int rowIndex) {
        return (DhmVendedor) lstDhmVendedor.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstDhmVendedor.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DhmVendedor vendedores = (DhmVendedor) lstDhmVendedor.get( rowIndex);
        if ( columnIndex == 0 ){
            return vendedores.getDhmIdVendedor();
        } else if (columnIndex ==1) {
            return vendedores.getDhmNome();        
        } else if (columnIndex ==2) {
            return vendedores.getDhmSalario();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Salário";
        } 
        return "";
    }
}
