package bankmanegment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, baddacu, bDelacc, choose,
            interest, acc, trns, log, loan, upinfo, alltrn, apply, claim, del, pay, intr;
    String pin, formno;

    Transactions(String pin) {
        this.pin = pin;
        this.formno = formno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/transection.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(50, 50, 100, 100);
        add(l2);

        l1 = new JLabel("Select Your Service Type: ");
        l1.setForeground(Color.darkGray);
        l1.setFont(new Font("System", Font.BOLD, 16));

        choose = new JButton("Choose Bg Color");
        choose.setBackground(Color.DARK_GRAY);
        choose.setForeground(Color.WHITE);

       choose.setFont(new Font("Arial", Font.BOLD, 14));
        choose.setBounds(210, 150, 180, 30);
        add(choose);

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("WITHDRAW");
      
        b6 = new JButton("CHECK BALANCE");
        b7 = new JButton("EXIT");
        b3 = new JButton("MORE");
        setLayout(null);

        l1.setBounds(180, 80, 500, 35);
        l1.setFont(new Font("Arial", Font.ITALIC, 29));
        add(l1);

        b1.setBounds(120, 240, 145, 35);
        add(b1);

        b2.setBounds(320, 240, 145, 35);
        add(b2);

       
        
        b6.setBounds(120, 290, 145, 35);
        add(b6);

        b7.setBounds(320, 290, 145, 35);
        b7.setBackground(Color.cyan);
        add(b7);

        b3.setBounds(210, 410, 145, 35);
        add(b3);

        l2 = new JLabel("*If you want more click here* ");
        l2.setForeground(Color.RED);
        l2.setFont(new Font("System", Font.BOLD, 10));

        l2.setBounds(180, 365, 500, 35);
        l2.setFont(new Font("Arial", Font.BOLD, 17));
        add(l2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(600, 500);
        setLocation(300, 30);
        setUndecorated(true);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            new Deposite(pin).setVisible(true);
        } else if (ae.getSource() == b2) {
            setVisible(false);
            new Withdrow(pin).setVisible(true);
        } else if (ae.getSource() == b6) {
            this.setVisible(false);
            new CheckBalance(pin).setVisible(true);
        } else if (ae.getSource() == b7) {
            System.exit(0);
        } else if (ae.getSource() == b3) {
            this.setVisible(false);
            new More(pin).setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);

    }
}
