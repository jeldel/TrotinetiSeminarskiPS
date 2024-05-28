package forms;

import controller.AdministratorController;
import controller.KlijentController;
import domain.Administrator;
import domain.Klijent;

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

    private final KlijentController controllerKlijent;
    private final AdministratorController controllerAdmin;

    public loginForm() {
        setContentPane(contentPane);
        setModal(true);
        setBounds(500,200,250,250);
        getRootPane().setDefaultButton(btnLogin);
        controllerKlijent = new KlijentController();
        controllerAdmin = new AdministratorController();

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    validateForm();

                    Klijent klijent = controllerKlijent.login(txtUsername.getText(), String.valueOf(txtPassword.getPassword()));

                    if(klijent != null) {
                        dispose();
                        new mainFormUser().setVisible(true);
                    }
                    else{
                        Administrator admin = controllerAdmin.login(txtUsername.getText(), String.valueOf(txtPassword.getPassword()));
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

    /*private void onLogin() throws Exception {
        try {
            validateForm();
            //ovde moram da dodam distinkciju za admina i usera
            new mainFormUser().setVisible(true);
            this.dispose();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(),"Neuspesno prijavljivanje na sistem", JOptionPane.ERROR_MESSAGE);
        }
    }
     */


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        loginForm dialog = new loginForm();
        dialog.pack();
        dialog.setVisible(true);
    }
}
