import javax.swing.*;
import java.awt.event.*;

/**
 * Created with IntelliJ IDEA.
 * User: pyzh_da
 * Date: 01.03.13
 * Time: 16:35
 * To change this template use File | Settings | File Templates.
 */

public class MainForm {

    private JPanel mainPanel;
    private JTextArea statusTextArea;
    private JButton openButton;
    private JButton closeButton;

    public MainForm() {



        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });




    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
