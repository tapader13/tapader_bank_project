package bankmanegment;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.util.*;

public class Deposite extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3, l11, l111;
    String pin;

    Deposite(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/deposite.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(20, 20, 200, 200);
        add(l3);

        l1 = new JLabel("MTM BANK ");
        //l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        l11 = new JLabel("ENTER DEPOSIT AMOUNT");
        // l11.setForeground(Color.WHITE);
        l11.setFont(new Font("System", Font.BOLD, 16));

        l111 = new JLabel("AMOUNT: ");
        // l111.setForeground(Color.WHITE);
        l111.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        b1 = new JButton("DEPOSITE");
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
        l11.setBounds(270, 100, 400, 35);
        add(l11);
        l111.setBounds(70, 260, 100, 35);
        add(l111);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        t1.setBounds(200, 266, 140, 25);
        add(t1);

        b1.setBounds(90, 320, 140, 35);
        add(b1);

        b2.setBounds(260, 320, 140, 35);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        this.setTitle("DEPOSIT BOARD");
        setSize(500, 500);
        setUndecorated(true);
        setLocation(90, 90);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = t1.getText();
            Date date = new Date();
            if (ae.getSource() == b1) {
                if (t1.getText().equals("")||Double.parseDouble(t1.getText()) <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter some Amount ");
                } else {
                    Conn c1 = new Conn();
                    String cardnumber=null;
                    ResultSet rs = c1.s.executeQuery("select * from login where pin = '" + pin + "'");
                    if (rs.next()) {
                        cardnumber = rs.getString("cardnumber");
                    }
                    c1.s.executeUpdate("insert into balance values('" + pin + "', 'Deposit', '" + amount + "')");
                    c1.s.executeUpdate("insert into history values('" + pin + "', '" + date + "', '" + cardnumber + "', 'Deposit', '" + amount + "')");

                    JOptionPane.showMessageDialog(null, "Deposit Done");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            } else if (ae.getSource() == b2) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            } else if (ae.getSource() == b3) {
                Color color = JColorChooser.showDialog(null, "Choose any color ", Color.yellow);
                getContentPane().setBackground(color);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Deposite("").setVisible(true);
    }
}
