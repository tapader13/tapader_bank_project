package bankmanegment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class CheckBalance extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3, l11, l111;
    String pin;

    CheckBalance(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/deposite.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(20, 20, 200, 200);
        add(l3);

        l1 = new JLabel("MTM BANK ");
        //l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 23));

        l11 = new JLabel();
        // l11.setForeground(Color.WHITE);
        l11.setFont(new Font("System", Font.BOLD, 23));
        b2 = new JButton("DESHBOARD");
        b3 = new JButton("Choose Bg Color");
        b3.setBackground(Color.DARK_GRAY);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(150, 390, 180, 30);
        add(b3);

        setLayout(null);

        l1.setBounds(280, 50, 400, 35);
        add(l1);
        l11.setBounds(260, 140, 400, 35);
        add(l11);
        // l111.setBounds(70, 260, 100, 35);
        //add(l111);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //t1.setBounds(200, 266, 140, 25);
        //add(t1);
        // b1.setBounds(90, 320, 140, 35);
        // add(b1);
        b2.setBounds(230, 320, 140, 35);
        add(b2);

        //b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        this.setTitle("BALANCE BOARD");
        setSize(650, 500);
        setUndecorated(true);
        setLocation(90, 90);
        setVisible(true);

        try {
            // String amount = t1.getText();

            Conn c1 = new Conn();

            ResultSet rs = c1.s.executeQuery("select * from balance where pin = '" + pin + "'");
           double balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Double.parseDouble(rs.getString("amount"));
                } else {
                    balance -= Double.parseDouble(rs.getString("amount"));
                }
            }
            l11.setText("Your Total Balance is: " + balance);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: " + e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b2) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        } else if (ae.getSource() == b3) {
            Color color = JColorChooser.showDialog(null, "Choose any color ", Color.yellow);
            getContentPane().setBackground(color);
        }

    }

    public static void main(String[] args) {
        new CheckBalance("").setVisible(true);
    }
}
