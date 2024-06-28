package forms.osobaForms;

import controller.Controller;
import domain.Osoba;
import forms.components.TableModelOsoba;
import forms.voznjeForms.VoznjeNovaForm;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class OsobeMainForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTable tblOsobe;
    private JLabel lblSearch;
    private JTextField txtSearch;
    private JButton btnSearch;
    private JButton btnCreateOsoba;

    public OsobeMainForm() {
        setContentPane(contentPane);
        setModal(true);
        setBounds(400, 200, 500, 300);
        setTitle("Rad sa osobama");

        try {
            tblOsobe.setVisible(true);
            prepareView();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Greska! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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
        btnCreateOsoba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CreateOsobaForm().setVisible(true);
            }
        });
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Osoba> osobe = Controller.getInstance().getByBrojLK(Long.valueOf(txtSearch.getText()));
                    TableModelOsoba tableModelOsoba = new TableModelOsoba(osobe);
                    tblOsobe.setModel(tableModelOsoba);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(btnSearch, "Niste uneli adekvatan broj licne karte!");
                }
            }
        });
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = tblOsobe.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(buttonOK, "Niste izabrali osobe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    Long brojLicneKarte = (Long) tblOsobe.getValueAt(selectedRow, 0);
                    List<Osoba> osobe = Controller.getInstance().getByBrojLK(brojLicneKarte);
                    Osoba o = osobe.get(0);
                    Controller.getInstance().setIzabranaOsoba(o);
                    JOptionPane.showMessageDialog(buttonOK, "Uspesno dodavanje osobe " + o.getIme() + " " + o.getPrezime(), "Success", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(Controller.getInstance().getIzabranaOsoba());
                    dispose();
                    new VoznjeNovaForm().setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(buttonOK, "Neuspesno dodavanje osobe!", "Error", JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void prepareView() {
        List<Osoba> osobe = new ArrayList<>();
        TableModelOsoba tableModelOsoba = new TableModelOsoba(osobe);
        tblOsobe.setModel(tableModelOsoba);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        OsobeMainForm dialog = new OsobeMainForm();
        dialog.setVisible(true);
    }
}
