package view;

import bean.DhmProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerProdutos extends AbstractTableModel {

    private List DhmProdutos;

    public void setList(List DhmProdutos) {
        this.DhmProdutos = DhmProdutos;
    }
    
    public DhmProdutos getBean(int rowIndex) {
        return (DhmProdutos) DhmProdutos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return DhmProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DhmProdutos produtos = (DhmProdutos) DhmProdutos.get(rowIndex);
        if (columnIndex == 0) {
            return produtos.getDhmIdProduto();
        } else if (columnIndex == 1) {
            return produtos.getDhmNome();        
        } else if (columnIndex == 2) {
            return produtos.getDhmCategoria();
        } else if (columnIndex == 3) {
            return produtos.getDhmPreco();
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
            return "Categoria";
        } else if (columnIndex == 3) {
            return "Preço";
        } 
        return "";
    }
}