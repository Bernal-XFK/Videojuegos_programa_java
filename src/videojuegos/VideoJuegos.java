
package videojuegos;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author BernalXFK
 */
public class VideoJuegos {

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
     InterfazPrincipal v = new InterfazPrincipal();
        v.setVisible(true);
    }
    
}
