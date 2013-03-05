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
                int r = fc.showOpenDialog(mainPanel);
                if (r == JFileChooser.APPROVE_OPTION) {
                    try {
                        // Потоки для чтения файла
                        FileInputStream stream = new FileInputStream(fc.getSelectedFile().getPath());
                        InputStreamReader reader = new InputStreamReader(stream);
                        int ch = reader.read();
                        int count = 0;
                        while (ch != -1) {
                            // Проверка на возврат коретки и перенос строки (не считаем)
                            if (ch != 13 && ch != 10)
                            count++;
                            ch = reader.read();
                        }
                        reader.close();
                        stream.close();
                        // Вывод отчета
                        statusTextArea.setText(String.format("Файл: %s%n%nПечатных знаков (символов): %,d%n%nАвторских листов: %.2f", fc.getSelectedFile().getPath(), count, (double) count / 40000));
                    
                    } catch (Exception e) {
                        statusTextArea.setText(String.format("Ошибка: %s", e.getMessage()));
                    }
                } else {
                    statusTextArea.setText("Выберите файл...");
                }
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
