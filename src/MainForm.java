import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.*;

/**
 * Created with IntelliJ IDEA.
 */

public class MainForm {

    // Элементы пользовательского интефейса
    private JPanel mainPanel;
    private JTextArea statusTextArea;
    private JButton openButton;
    private JButton closeButton;

    public MainForm() {

        statusTextArea.setText("Выберите файл...");

        // Анонимный класс с переопределенным actionPerformed
        // для обработки Выбрать файл
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // Диалог выбора текстового файла
                final JFileChooser fc = new JFileChooser();
                fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setAcceptAllFileFilterUsed(false);
                fc.setMultiSelectionEnabled(false);
                fc.addChoosableFileFilter(new FileNameExtensionFilter("Текстовый файл (*.txt)", "txt"));
                fc.showOpenDialog(mainPanel);
            }
        });

        // Анонимный класс с переопределенным actionPerformed
        // для выхода из программы
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {

        // Создание основного окна программы
        JFrame frame = new JFrame("Подсчет количества символов");
        frame.setResizable(false);
        frame.setContentPane(new MainForm().mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
