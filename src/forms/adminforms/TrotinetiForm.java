package forms.adminforms;

import domain.VrstaTrotinetaEnum;
import forms.mainFormAdmin;

import javax.swing.*;
import java.awt.event.*;

public class TrotinetiForm extends JDialog {
    private JPanel contentPane;

    private JButton btnReturn;
    private JButton btnCreate;
    private JLabel lblSearch;
    private JComboBox comboBoxTrotineti;
    private JButton btnAllScooters;

    public TrotinetiForm() {
        setContentPane(contentPane);
        setBounds(500,200,300,200);
        setModal(true);


        try {
            prepareView();

        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Greska! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { onReturn();}
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
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CreateTrotinetForm().setVisible(true);
            }
        });
    }

    private void prepareView() {
        comboBoxTrotineti.removeAllItems();
        for(VrstaTrotinetaEnum vrstaTrotinetaEnum : VrstaTrotinetaEnum.values())
            comboBoxTrotineti.addItem(vrstaTrotinetaEnum);
        comboBoxTrotineti.addItem("Svi trotineti");
    }

    private void onReturn() {
        dispose();
        new mainFormAdmin().setVisible(true);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        TrotinetiForm dialog = new TrotinetiForm();
        dialog.setVisible(true);

    }
}
