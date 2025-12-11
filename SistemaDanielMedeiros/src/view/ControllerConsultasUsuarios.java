/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import bean.DhmUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerConsultasUsuarios extends AbstractTableModel {

    private List lstDhmUsuarios;

    public void setList(List lstDhmUsuarios) {
        this.lstDhmUsuarios = lstDhmUsuarios;
        this.fireTableDataChanged();
        
    }
    
    public DhmUsuarios getBean(int rowIndex) {
        return (DhmUsuarios) lstDhmUsuarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstDhmUsuarios.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DhmUsuarios produtos = (DhmUsuarios) lstDhmUsuarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return produtos.getDhmIdUsuario();
        } else if (columnIndex ==1) {
            return produtos.getDhmNome();        
        } else if (columnIndex ==2) {
            return produtos.getDhmDataNascimento();
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
            return "Data de Nascimento";
        } 
        return "";
    }
}
