package forms.adminforms;

import controller.Controller;
import domain.Status;
import domain.Trotinet;
import domain.VrstaTrotinetaEnum;

import javax.swing.*;
import java.awt.event.*;

public class CreateTrotinetForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lblVrstaTrotineta;
    private JComboBox cmbVrsta;
    private JLabel lblKarakteristike;
    private JTextPane textPane1;
    private JComboBox cmbStatus;
    private JLabel lblStatus;


    public CreateTrotinetForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setBounds(500,200, 450,400);
        setTitle("Kreiranje trotineta");

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
        new TrotinetiForm().setVisible(true);
    }

    private void prepareView() {
        cmbVrsta.removeAllItems();
        cmbStatus.removeAllItems();

        for(VrstaTrotinetaEnum vrsta: VrstaTrotinetaEnum.values()) cmbVrsta.addItem(vrsta);
        for (Status status: Status.values()) cmbStatus.addItem(status);
    }

    private void onOK() {
        try{
            Trotinet t = new Trotinet();
            t.setVrstaTrotineta((VrstaTrotinetaEnum) cmbVrsta.getSelectedItem());
            t.setKarakteristike(textPane1.getText());
            t.setStatus((Status)cmbStatus.getSelectedItem());

            Controller.getInstance().addTrotinet(t);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio trotinet!");
            System.out.println(Controller.getInstance().getAllTrotinet());
            dispose();

        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti trotinet!" + e.getMessage(), "Greska!", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CreateTrotinetForm dialog = new CreateTrotinetForm();
        dialog.setVisible(true);
    }
}
