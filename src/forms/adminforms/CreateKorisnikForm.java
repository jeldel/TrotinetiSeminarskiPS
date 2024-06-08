package forms.adminforms;

import controller.Controller;
import domain.GradEnum;
import domain.Korisnik;
import forms.mainFormAdmin;

import javax.swing.*;
import java.awt.event.*;

public class CreateKorisnikForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lblName;
    private JLabel lblSurname;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JTextField txtName;
    private JTextField txtSurname;
    private JLabel lblPassword;
    private JLabel lblCity;
    private JComboBox comboBoxCity;
    private JLabel lblTelefon;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JTextField txtPhone;
    private JPasswordField passwordField1;


    public CreateKorisnikForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setBounds(500,200, 450,400);
        setTitle("Kreiranje korisnika");

        try {
            prepareView();

        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Greska! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onReturn();
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

    private void onReturn() {
        dispose();
        new mainFormAdmin().setVisible(true);
    }

    private void prepareView() throws Exception {
        comboBoxCity.removeAllItems();
        for (GradEnum grad : GradEnum.values()) comboBoxCity.addItem(grad);
    }

    private void onOK() {
        try {
            validation();

            Korisnik korisnik = new Korisnik(1L, "Pera", "Peric", "peraperic@pp.com",GradEnum.Beograd, "063/1111-111", "peraperic","peraperic");

            JOptionPane.showMessageDialog(this, "Sistem je kreirao korisnika!");

            korisnik.setIme(txtName.getText().trim());
            korisnik.setPrezime(txtSurname.getText().trim());
            korisnik.setEmail(txtEmail.getText().trim());
            korisnik.setGrad((GradEnum) comboBoxCity.getSelectedItem());
            korisnik.setTelefon(txtPhone.getText().trim());
            korisnik.setUsername(txtUsername.getText().trim());
            korisnik.setSifra(String.valueOf(passwordField1.getPassword()));

            Controller.getInstance().addKorisnik(korisnik);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio korisnika!");
            System.out.println(Controller.getInstance().getAllKorisnik());
            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira korisnika! " + e.getMessage(), "Greska!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void validation() throws Exception {
        if(txtName.getText().length() < 2){
            throw new RuntimeException("Ime mora biti duze od jednog karaktera!");
        }
        if(txtSurname.getText().length() < 2){
            throw new RuntimeException("Prezime mora biti duze od jednog karaktera!");
        }
        if(!(txtEmail.getText().contains("@"))){
            throw new RuntimeException("Email mora sadrzati @ karakter!");
        }
        if(txtUsername.getText().length() < 3){
            throw new RuntimeException("Korisnicko ime mora imati vise od tri karaktera!");
        }
        if(passwordField1.getPassword().length < 3){
            throw new RuntimeException("Sifra mora imati vise od tri karaktera!");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CreateKorisnikForm dialog = new CreateKorisnikForm();
        dialog.setVisible(true);
    }
}
