package bankmanegment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DeletAccount extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1, b2, b3, b4;
    Cursor crc;
    JLabel l4, l5;
    String pin;

    DeletAccount(String pin) {
        setTitle("MTM BANK");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/delete.jpg"));
        Image i2 = i1.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(130, 0, 110, 110);
        add(l11);
        this.pin = pin;
        crc = new Cursor(Cursor.HAND_CURSOR);

        l1 = new JLabel("MTM BANK");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(300, 30, 450, 40);
        add(l1);

        l2 = new JLabel("Card Number:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(110, 150, 375, 30);
        add(l2);

        l4 = new JLabel("Delete Your Account");
        l4.setFont(new Font("Raleway", Font.BOLD, 30));
        l4.setBounds(260, 85, 300, 30);
        add(l4);

        l5 = new JLabel("Note: This action is irreversible. All your data will be deleted permanently.");
        l5.setFont(new Font("Arial", Font.PLAIN, 14));
        l5.setBounds(120, 400, 600, 30);
        l5.setForeground(Color.red);
        add(l5);

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

        b1 = new JButton("DELET");
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.WHITE);
        b1.setToolTipText("Delete All Data");

        b2 = new JButton("CLEAR");
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.WHITE);

        b3 = new JButton("BACK");
        b3.setBackground(Color.gray);
        b3.setForeground(Color.WHITE);

        b4 = new JButton("Choose Bg Color");
        b4.setBackground(Color.DARK_GRAY);
        b4.setForeground(Color.WHITE);

        setLayout(null);
        this.setResizable(false);
        this.setUndecorated(true);
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300, 300, 100, 30);
        add(b1);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430, 300, 100, 30);
        add(b2);

        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(170, 300, 100, 30);
        add(b3);

        b4.setFont(new Font("Arial", Font.BOLD, 14));
        b4.setBounds(270, 350, 180, 30);
        add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        b1.setCursor(crc);
        b2.setCursor(crc);
        b3.setCursor(crc);
        b4.setCursor(crc);

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
                    //  System.out.println(rs.getString("formno"));
                    String formno = rs.getString("formno");
                    // DELETE FROM your_table_name WHERE id = 100
                    String q2 = "delete from login where formno = '" + formno + "'";
                    String q3 = "delete from signup where formno = '" + formno + "'";
                    String q4 = "delete from signuptwo where formno = '" + formno + "'";

                    c1.s.executeUpdate(q4);
                    c1.s.executeUpdate(q2);
                    c1.s.executeUpdate(q3);

                    System.out.println("done");
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Card Number/PIN");
                }
            } else if (ae.getSource() == b2) {
                tf1.setText("");
                pf2.setText("");
            } else if (ae.getSource() == b3) {
                //System.exit(0);
                this.setVisible(false);
                new More(pin).setVisible(true);
            } else if (ae.getSource() == b4) {
                Color color = JColorChooser.showDialog(null, "Choose any color ", Color.yellow);
                getContentPane().setBackground(color);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DeletAccount("");
    }
}
