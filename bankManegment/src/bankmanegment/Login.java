package bankmanegment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1, b2, b3, b4, b5;
    Cursor crc;

    Login() {
        setTitle("MTM BANK");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/bank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(150, 10, 100, 100);
        add(l11);

        crc = new Cursor(Cursor.HAND_CURSOR);

        l1 = new JLabel("MTM BANK");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(300, 40, 450, 40);
        add(l1);

        l2 = new JLabel("Card Number:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(110, 150, 375, 30);
        add(l2);

        tf1 = new JTextField(15);
        tf1.setBounds(300, 150, 230, 30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);

        l3 = new JLabel("Password:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(150, 220, 375, 30);
        add(l3);

        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300, 220, 230, 30);
        pf2.setEchoChar('$');

        add(pf2);

        b1 = new JButton("LOGIN");
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("CLEAR");
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.WHITE);

        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.gray);
        b3.setForeground(Color.WHITE);

        b4 = new JButton("Choose Bg Color");
        b4.setBackground(Color.DARK_GRAY);
        b4.setForeground(Color.WHITE);

        b5 = new JButton("EXIT");
        b5.setBackground(Color.gray);
        b5.setForeground(Color.WHITE);

        setLayout(null);
        this.setResizable(false);

        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(280, 300, 100, 30);
        add(b1);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(410, 300, 100, 30);
        add(b2);

        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(150, 300, 100, 30);
        add(b3);

        b4.setFont(new Font("Arial", Font.BOLD, 14));
        b4.setBounds(270, 350, 180, 30);
        add(b4);

        b5.setFont(new Font("Arial", Font.BOLD, 14));
        b5.setBounds(540, 300, 100, 30);
        // add(b5);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

         this.setUndecorated(true);
        b1.setCursor(crc);
        b2.setCursor(crc);
        b3.setCursor(crc);
        b4.setCursor(crc);
        b5.setCursor(crc);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setLocation(550, 200);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) {
                Conn c1 = new Conn();
                String cardno = tf1.getText();
                String pin = pf2.getText();
                String q = "select * from login where cardnumber = '" + cardno + "' and pin = '" + pin + "'";

                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) {
                    // System.out.println(rs.getString("formno"));
                    // String formno=rs.getString("formno");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Card Number/PIN");
                }
            } else if (ae.getSource() == b2) {
                tf1.setText("");
                pf2.setText("");
            } else if (ae.getSource() == b3) {
                setVisible(false);
                new SignUpOne().setVisible(true);
            } else if (ae.getSource() == b4) {
                Color color = JColorChooser.showDialog(null, "Choose any color ", Color.yellow);
                getContentPane().setBackground(color);
            } else if (ae.getSource() == b5) {
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

}
