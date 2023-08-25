package bankmanegment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Date;

import java.sql.*;

public class ConvertTaka extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3, l11, l111, l1111;
    String pin;
    private JButton btn1, btn2;
    private Font f;
    private Cursor crc;
    private JComboBox jcb;

    ConvertTaka(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/deposite.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(20, 20, 150, 150);
        add(l3);

        crc = new Cursor(Cursor.NE_RESIZE_CURSOR);
        String str[] = {"Doller", "Rupee", "Ruble", "Rial"};
        jcb = new JComboBox(str);
        jcb.setBounds(300, 266, 146, 25);
        jcb.setEditable(true);
        jcb.setSelectedItem("Doller");
        jcb.setFont(new Font("Arial", Font.BOLD, 18));
        // jcb.addItem("mar");
        add(jcb);
        jcb.addActionListener(this);

        l1 = new JLabel("MTM BANK ");
        //l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        l11 = new JLabel("CONVERT TK AND DEPOSITE ");
        // l11.setForeground(Color.WHITE);
        l11.setFont(new Font("System", Font.BOLD, 16));

        l111 = new JLabel("SELECT AMOUNT TYPE: ");
        // l111.setForeground(Color.WHITE);
        l111.setFont(new Font("System", Font.BOLD, 16));

        l1111 = new JLabel("ENTER AMOUNT : ");
        // l111.setForeground(Color.WHITE);
        l1111.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 22));
        t2.setBounds(300, 200, 146, 25);
        add(t2);

        b1 = new JButton("DEPOSITE");
        b2 = new JButton("DESHBOARD");
        b3 = new JButton("Choose Bg Color");
        b3.setBackground(Color.DARK_GRAY);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(150, 390, 180, 30);
        add(b3);
        // this.setTitle("CONVERT BOARD");
        setLayout(null);

        l1.setBounds(280, 50, 400, 35);
        add(l1);
        l11.setBounds(240, 100, 450, 35);
        add(l11);
        l111.setBounds(40, 260, 210, 35);
        add(l111);

        l1111.setBounds(60, 200, 210, 35);
        add(l1111);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // t1.setBounds(300, 266, 140, 25);
        // add(t1);
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

            Date date = new Date();
            if (ae.getSource() == b1) {
                if (t2.getText().trim().isEmpty() || Double.parseDouble(t2.getText()) <= 0) {
                    JOptionPane.showMessageDialog(null, "Enter amount");

                } else {
                     double amount = 0;
                String inputAmount = t2.getText().trim();
                double tk = Double.parseDouble(inputAmount);
                    Conn c1 = new Conn();
                    String cardnumber = null;
                    ResultSet rs6 = c1.s.executeQuery("select * from login where pin = '" + pin + "'");
                    if (rs6.next()) {
                        cardnumber = rs6.getString("cardnumber");
                    }
                    if (jcb.getSelectedItem().toString().equals("Doller")) {

                        amount = amount + tk * 110;
                        c1.s.executeUpdate("insert into history values('" + pin + "', '" + date + "', '" + cardnumber + "', 'Deposit', '" + amount + "')");

                        c1.s.executeUpdate("insert into balance values('" + pin + "', 'Deposit', '" + amount + "')");
                        JOptionPane.showMessageDialog(null, "Convert and Deposit Done");
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    } else if (jcb.getSelectedItem().toString().equals("Rupee")) {

                        amount = amount + tk * 1.78;
                        c1.s.executeUpdate("insert into history values('" + pin + "', '" + date + "', '" + cardnumber + "', 'Deposit', '" + amount + "')");

                        c1.s.executeUpdate("insert into balance values('" + pin + "', 'Deposit', '" + amount + "')");
                        JOptionPane.showMessageDialog(null, "Convert and Deposit Done");
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    } else if (jcb.getSelectedItem().toString().equals("Ruble")) {

                        amount = amount + tk * 1.27;
                        c1.s.executeUpdate("insert into history values('" + pin + "', '" + date + "', '" + cardnumber + "', 'Deposit', '" + amount + "')");

                        c1.s.executeUpdate("insert into balance values('" + pin + "', 'Deposit', '" + amount + "')");
                        JOptionPane.showMessageDialog(null, "Convert and Deposit Done");
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    } else if (jcb.getSelectedItem().toString().equals("Rial")) {

                        amount = amount + tk * 32;
                        c1.s.executeUpdate("insert into history values('" + pin + "', '" + date + "', '" + cardnumber + "', 'Deposit', '" + amount + "')");

                        c1.s.executeUpdate("insert into balance values('" + pin + "', 'Deposit', '" + amount + "')");
                        JOptionPane.showMessageDialog(null, "Convert and Deposit Done");
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    }
                    this.setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            } else if (ae.getSource() == b2) {
                setVisible(false);
                new More(pin).setVisible(true);
            } else if (ae.getSource() == b3) {
                Color color = JColorChooser.showDialog(null, "Choose any color ", Color.yellow);
                getContentPane().setBackground(color);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ConvertTaka("").setVisible(true);
    }
}
