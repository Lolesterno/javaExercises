import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Form extends JFrame{
    private JPanel principalPanel;
    private JTextField fieldText;
    private JLabel replicatorLabel;

    public Form() {
        initForm();
//        fieldText.addActionListener(e -> {
//            repliquedText();
//        });
        fieldText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                repliquedText();
            }
        });
    }

    private void initForm() {
        setContentPane(principalPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
    }

    private void repliquedText() {
        this.replicatorLabel.setText(this.fieldText.getText());
    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup(); // Look and field a modo oscuro
        Form form = new Form();
        form.setVisible(true);
    }
}
