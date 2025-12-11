/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.DhmVendas;
import bean.DhmVendasProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerVendasProdutos extends AbstractTableModel {

    private List lstVendasProdutos;

    public void setList(List lstVendasProdutos) {
        this.lstVendasProdutos = lstVendasProdutos;
        
        this.fireTableDataChanged();
    }
    
    public DhmVendasProdutos getBean(int rowIndex) {
        return (DhmVendasProdutos) lstVendasProdutos.get(rowIndex);
    }

    public void addBean(DhmVendasProdutos dhmVendasProdutos) {
        lstVendasProdutos.add(dhmVendasProdutos);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int rowIndex) {
        lstVendasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
     
    
    @Override
    public int getRowCount() {
        return lstVendasProdutos.size();                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DhmVendasProdutos dhmVendasProdutos = (DhmVendasProdutos) lstVendasProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return dhmVendasProdutos.getDhmProdutos().getDhmIdProduto();
        } else if (columnIndex ==1) {
            return dhmVendasProdutos.getDhmProdutos().getDhmNome();
        } else if (columnIndex ==2) {
            return dhmVendasProdutos.getDhmQuantidade();
        } else if (columnIndex ==3) {
            return dhmVendasProdutos.getDhmValorUnitario();
        }else if (columnIndex ==4) {
            return dhmVendasProdutos.getDhmValorUnitario()*dhmVendasProdutos.getDhmQuantidade();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Produto";         
        } else if ( columnIndex == 2) {
            return "Quantidade";
        } else if ( columnIndex == 3) {
            return "Valor Unitário";
        } else if ( columnIndex == 4) {
            return "Total";
        } 
        return "";
    }
}
