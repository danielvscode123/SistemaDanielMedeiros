

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
public class ControllerUsuarios extends AbstractTableModel {

    private List DhmUsuarios;

    public void setList(List DhmUsuarios) {
        this.DhmUsuarios = DhmUsuarios;
           fireTableDataChanged();
    }
    
    public DhmUsuarios getBean(int rowIndex) {
        return (DhmUsuarios) DhmUsuarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return DhmUsuarios.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DhmUsuarios usuarios = (DhmUsuarios) DhmUsuarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return usuarios.getDhmIdUsuario();
        } else if (columnIndex ==1) {
            return usuarios.getDhmNome();        
        } else if (columnIndex ==2) {
            return usuarios.getDhmApelido();
        } else if (columnIndex ==3) {
            return usuarios.getDhmCpf();
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
            return "Apelido";
        } else if ( columnIndex == 3) {
            return "Cpf";
        } 
        return "";
    }
}
