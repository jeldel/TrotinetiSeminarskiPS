package forms.adminforms;

import forms.mainFormAdmin;

import javax.swing.*;
import java.awt.event.*;

public class VoznjeForm extends JDialog {
    private JPanel contentPane;
    private JButton btnReturn;
    private JButton btnCreate;
    private JTextField txtSearch;
    private JLabel lblSearch;
    private JButton btnSearch;

    public VoznjeForm() {
        setContentPane(contentPane);
        setModal(true);
        setBounds(500,200, 500,200);

        btnReturn.addActionListener(new ActionListener() {
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


    private void onCancel() {
        // addKlijent your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        VoznjeForm dialog = new VoznjeForm();
        dialog.setVisible(true);
    }
}
