/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.DhmVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
    }
    
    public DhmVendas getBean(int rowIndex) {
        return (DhmVendas) lstVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DhmVendas dhmvendas = (DhmVendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return dhmvendas.getDhmIdVendas();
        } else if (columnIndex ==1) {
            return dhmvendas.getDhmDataVendas();        
        } else if (columnIndex ==2) {
            return dhmvendas.getDhmTotal();
        } else if (columnIndex ==3) {
            return dhmvendas.getDhmClientes().getDhmNome();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Data";         
        } else if ( columnIndex == 2) {
            return "Total";
        } else if ( columnIndex == 3) {
            return "Cliente";
        } 
        return "";
    }
}
