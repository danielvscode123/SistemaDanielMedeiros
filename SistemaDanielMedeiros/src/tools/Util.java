
package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Arte_Porã
 */
public class Util {

    public static void habilitar(boolean valor, JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);

        }
    }

    public static void limpar(JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setText("");
            }
            if (componentes[i] instanceof JComboBox) {
                ((JComboBox) componentes[i]).setSelectedIndex(-1);
            }

        }
    }

    public static void mensagem(String cad) {
        JOptionPane.showMessageDialog(null, cad);
    }

    public static boolean perguntar(String cad) {
    int resposta = JOptionPane.showConfirmDialog(null, cad, "Confirmação", JOptionPane.YES_NO_OPTION);
    return (resposta == JOptionPane.YES_OPTION);
}
    public static int strToInt(String num) {
        return Integer.parseInt(num);
    }

    public static String intToStr(int num) {
        return String.valueOf(num);
    }

    public static double strToDouble(String cad) {
        return Double.parseDouble(cad); 

    }

    public static String doubleToStr(double num) {
        return String.valueOf(num); 

    }


    public static Date strToDate(String data){
        return null;

    }

   public static String dateToStr(Date data) {
        return "";
 
    }

}



