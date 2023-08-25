package bankmanegment;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;

public class Transfer extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3, l11, l111, l22;
    String pin;
    JComboBox jcb;
    String str[] = {"Deposite", "Withdrow"};

    Transfer(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/transfer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 170, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 200, 170);
        add(l3);

        t2 = new JTextField();
        t2.setBounds(230, 220, 155, 25);
        add(t2);

        l1 = new JLabel("MTM BANK ");
        //l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        l11 = new JLabel("TRANSFER YOUR BALANCE");
        // l11.setForeground(Color.WHITE);
        l11.setFont(new Font("System", Font.BOLD, 16));

        l22 = new JLabel("PASSWORD: ");
        // l111.setForeground(Color.WHITE);
        l22.setFont(new Font("System", Font.BOLD, 16));

        l111 = new JLabel("AMOUNT: ");
        // l111.setForeground(Color.WHITE);
        l111.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        b1 = new JButton("TRANSFER");
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

        l22.setBounds(70, 210, 150, 35);
        add(l22);

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
            Date date = new Date();
            String amount = t1.getText();
            if (ae.getSource() == b1) {
                if (t1.getText().equals("") || t2.getText().equals("") || Double.parseDouble(t1.getText()) <= 0) {
                    JOptionPane.showMessageDialog(null, "Give some info ");
                } else {
                    Conn c1 = new Conn();
                    String npin = t2.getText();
                    ResultSet rs = c1.s.executeQuery("select * from balance where pin = '" + pin + "'");
                    double balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Double.parseDouble(rs.getString("amount"));
                        } else {
                            balance -= Double.parseDouble(rs.getString("amount"));
                        }
                        if (balance < Double.parseDouble(amount)) {
                            JOptionPane.showMessageDialog(null, "Insuffient Balance");
                            return;
                        }
                    }
                    String cardnumber = null;
                    ResultSet rs6 = c1.s.executeQuery("select * from login where pin = '" + pin + "'");
                    if (rs6.next()) {
                        cardnumber = rs6.getString("cardnumber");
                    }
                    c1.s.executeUpdate("insert into balance values('" + pin + "', 'Withdrow', '" + amount + "')");
                    c1.s.executeUpdate("insert into balance values('" + npin + "', 'Deposit', '" + amount + "')");
                    c1.s.executeUpdate("insert into history values('" + pin + "', '" + date + "', '" + cardnumber + "', 'Withdrow', '" + amount + "')");
                    c1.s.executeUpdate("insert into history values('" + npin + "', '" + date + "', '" + cardnumber + "', 'Deposit', '" + amount + "')");

                    JOptionPane.showMessageDialog(null, "Transfer Done.");

                    setVisible(false);
                    new More(pin).setVisible(true);
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
        new Transfer("").setVisible(true);
    }
}
