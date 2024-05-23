import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrotinetGUI extends JFrame {
    private JPanel panelMain;
    private JTextField txtName;
    private JButton btn1;

    public TrotinetGUI() {
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btn1, "Hello" + txtName.getText());
            }
        });

    }

    public static void main(String[] args) {
        TrotinetGUI t = new TrotinetGUI();
        t.setContentPane(t.panelMain);
        t.setTitle("Hello");
        t.setBounds(600,300,300,300);
        // t.setSize(300,400);
        t.setVisible(true);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
