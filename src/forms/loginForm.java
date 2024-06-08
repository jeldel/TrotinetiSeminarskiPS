package forms;

import controller.Controller;
import domain.Administrator;
import domain.Korisnik;

import javax.swing.*;
import java.awt.event.*;

public class loginForm extends JDialog {
    private JPanel contentPane;
    private JButton btnLogin;
    private JButton buttonCancel;
    private JPanel jpanel1;
    private JTextField txtUsername;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JPasswordField txtPassword;


    public loginForm() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Login forma");
        setBounds(500,200,350,200);
        getRootPane().setDefaultButton(btnLogin);


        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    validateForm();

                    Korisnik korisnik = Controller.getInstance().loginKorisnik(txtUsername.getText(), String.valueOf(txtPassword.getPassword()));

                    if(korisnik != null) {
                        dispose();
                        new mainFormUser().setVisible(true);
                    }
                    else{
                        Administrator admin = Controller.getInstance().loginAdmin(txtUsername.getText(), String.valueOf(txtPassword.getPassword()));
                        if (admin != null){
                            dispose();
                            new mainFormAdmin().setVisible(true);
                        }
                        else{
                            throw new Exception("Nepoznat korisnik!");
                        }
                    }


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(loginForm.this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void validateForm() throws Exception {
        String errorMessage = "";
        if (txtUsername.getText().isEmpty()){
            errorMessage+= "Korisnicko ime ne sme biti prazno!";
        }
        if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
            errorMessage+= "Sifra ne sme biti prazna!";
        }
        if (!errorMessage.isEmpty()){
            throw new Exception(errorMessage);
        }
    }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        loginForm dialog = new loginForm();
        dialog.setVisible(true);
    }
}
