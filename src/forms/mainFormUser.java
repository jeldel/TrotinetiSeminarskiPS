package forms;

import domain.VrstaTrotinetaEnum;

import javax.swing.*;
import java.awt.event.*;

public class mainFormUser extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JLabel lblWelcome;
    private JButton btnSearchTrotinet;
    private JLabel lblSearch;
    private JComboBox cmbTrotinet;

    public mainFormUser() {
        setContentPane(contentPane);
        setTitle("Korisnicka forma");
        setModal(true);
        setBounds(500,200,400,200);

        try {
            prepareView();
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Greska! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

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

    private void prepareView() {
        cmbTrotinet.removeAllItems();

        for(VrstaTrotinetaEnum vrsta: VrstaTrotinetaEnum.values()) {
            cmbTrotinet.addItem(vrsta);
        }
        cmbTrotinet.addItem("Svi trotineti");
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        mainFormUser dialog = new mainFormUser();
        dialog.setVisible(true);
    }
}
