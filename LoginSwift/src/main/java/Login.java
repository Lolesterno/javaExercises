import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel RootPanel;
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton sendForm;

    public Login() {
        initForm();
        sendForm.addActionListener(e -> {
            sendFormListener();
        });
    }

    public void initForm() {
        setContentPane(RootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
    }

    public void sendFormListener() {
        // Leer los valores del los campos
        String user = this.userField.getText();
        String password = new String(this.passwordField.getPassword());

        if("root".equals(user) && "admin".equals(password)) {
            sendMessage("Datos Correctos, iniciando Sesion");
        } else if ("root".equals(user)) {
            sendMessage("Password Incorrecto");
        } else {
            sendMessage("Usuario incorrecto, verifica los datos");
        }
    }

    public void sendMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        Login login = new Login();
        login.setVisible(true);
    }
}
