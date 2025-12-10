/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.DhmProdutos;
import bean.DhmUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerConsultasUsuarios extends AbstractTableModel {

    private List lstDhmProdutos;

    public void setList(List lstDhmProdutos) {
        this.lstDhmProdutos = lstDhmProdutos;
        this.fireTableDataChanged();
        
    }
    
    public DhmProdutos getBean(int rowIndex) {
        return (DhmProdutos) lstDhmProdutos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstDhmProdutos.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DhmProdutos produtos = (DhmProdutos) lstDhmProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return produtos.getDhmIdProduto();
        } else if (columnIndex ==1) {
            return produtos.getDhmNome();        
        } else if (columnIndex ==2) {
            return produtos.getDhmPreco();
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
            return "Valor Unitario";
        } 
        return "";
    }
}
