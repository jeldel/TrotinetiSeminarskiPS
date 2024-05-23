import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IznajmljivanjeTrotineta extends JFrame {

    public IznajmljivanjeTrotineta() {

        setTitle("Iznajmljivanje trotineta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 250);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Ime:");
        JTextField nameField = new JTextField(30);
        JLabel addressLabel = new JLabel("Adresa:");
        JTextField addressField = new JTextField(30);
        JLabel phoneLabel = new JLabel("Telefon:");
        JTextField phoneField = new JTextField(30);
        JLabel scooterLabel = new JLabel("Trotinet:");
        String[] scooters = {"Segway", "XIAOMI", "MS Energy", "Soflow", "Sharp"};
        JComboBox<String> scooterComboBox = new JComboBox<>(scooters);
        JLabel durationLabel = new JLabel("Trajanje iznajmljivanja(dani):");
        JTextField durationField = new JTextField(5);

        JButton submitButton = new JButton("Sačuvaj");
        JButton clearButton = new JButton("Izbriši");

        add(nameLabel);
        add(nameField);
        add(addressLabel);
        add(addressField);
        add(phoneLabel);
        add(phoneField);
        add(scooterLabel);
        add(scooterComboBox);
        add(durationLabel);
        add(durationField);
        add(submitButton);
        add(clearButton);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String address = addressField.getText();
                String phone = phoneField.getText();
                String scooter = (String) scooterComboBox.getSelectedItem();
                String duration = durationField.getText();

                JOptionPane.showMessageDialog(IznajmljivanjeTrotineta.this,
                        "Korisnik:\nIme: " + name + "\nAdresa: " + address +
                                "\nTelefon: " + phone + "\nTrotinet: " + scooter + "\nTrajanje: " + duration + " dana");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nameField.setText("");
                addressField.setText("");
                phoneField.setText("");
                durationField.setText("");
                scooterComboBox.setSelectedIndex(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IznajmljivanjeTrotineta t = new IznajmljivanjeTrotineta();

            t.setVisible(true);
        });
    }
}
