package bankmanegment;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Welcome extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JPasswordField tf1;
    JButton b1, b2, b3, b4;
    Cursor crc;

    Welcome() {
        setTitle("MTM BANK");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/welcome.jpg"));
        Image i2 = i1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(0, 0, 120, 120);
        add(l14);
        crc = new Cursor(Cursor.HAND_CURSOR);

        l1 = new JLabel("WELCOME TO MTM BANK");
        l1.setFont(new Font("Segoe UI", Font.BOLD, 38));
        l1.setBounds(130, 40, 600, 40);
        add(l1);

        l3 = new JLabel("Enter the Gate Key below to access our bank");
        l3.setFont(new Font("Arial", Font.BOLD, 18));
        l3.setBounds(150, 120, 550, 30);
        add(l3);

        l2 = new JLabel("Gate Key:");
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setBounds(200, 190, 120, 30);
        add(l2);

        tf1 = new JPasswordField(15);
        tf1.setBounds(320, 190, 200, 30);
        tf1.setFont(new Font("Arial", Font.BOLD, 18));
        tf1.setEchoChar('•'); // Use a small circle for password masking
        add(tf1);

        b2 = new JButton("CLEAR");
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.WHITE);

        b3 = new JButton("ENTER");
        b3.setBackground(Color.GRAY);
        b3.setForeground(Color.WHITE);

        b4 = new JButton("EXIT");
        b4.setBackground(Color.GRAY);
        b4.setForeground(Color.WHITE);

        setLayout(null);
        this.setResizable(false);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(400, 300, 100, 30);
        add(b2);

        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(230, 300, 100, 30);
        add(b3);

        b4.setFont(new Font("Arial", Font.BOLD, 14));
        b4.setBounds(570, 300, 100, 30);
        add(b4);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        b2.setCursor(crc);
        b3.setCursor(crc);
        b4.setCursor(crc);

        setSize(800, 480);
        setLocationRelativeTo(null); // Center the window on the screen
        this.setUndecorated(true);
        setVisible(true);
        getContentPane().setBackground(new Color(230, 230, 230)); // Light gray background

        // Set a stylish look and feel
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b3) {
                if (tf1.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(null, "Without Gate Key You Can't Enter Our Bank");
                } else {
                    String gateKey = new String(tf1.getPassword());
                    if (gateKey.equals("minhaj")) {
                        setVisible(false);
                        new Login().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Gate Key, please contact the bank owner");
                    }
                }
            } else if (ae.getSource() == b2) {
                tf1.setText("");
            } else if (ae.getSource() == b4) {
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Welcome().setVisible(true);
    }
}
