package bankmanegment;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pay extends JFrame implements ActionListener {

    JLabel j1, j2, j3;
    JTextField jt1;
    JButton jb1, jb2, jb3;
    String pin;

    Pay(String pin) {
        this.pin = pin;
        this.setTitle("PAY BOARD");
        this.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/pay.jpg"));
        Image i2 = i1.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(80, 20, 130, 130);
        getContentPane().add(l14);
        this.setUndecorated(true);
        j1 = new JLabel("MTM BANK");
        j1.setBounds(340, 35, 180, 60);
        j1.setFont(new Font("Arial", Font.BOLD, 22));
        add(j1);

        j2 = new JLabel("Pay Past Loan");
        j2.setBounds(320, 110, 180, 60);
        j2.setFont(new Font("Arial", Font.BOLD, 24));
        add(j2);

        j3 = new JLabel("Amount: ");
        j3.setBounds(140, 200, 120, 60);
        j3.setFont(new Font("Arial", Font.BOLD, 18));
        add(j3);

        jt1 = new JTextField();
        jt1.setBounds(250, 210, 130, 40);
        jt1.setFont(new Font("Arial", Font.BOLD, 18));
        add(jt1);

        jb1 = new JButton("PAY");
        jb1.setBounds(100, 290, 160, 40);
        jb1.setFont(new Font("Arial", Font.BOLD, 20));
        add(jb1);

        jb2 = new JButton("DASHBOARD");
        jb2.setBounds(280, 290, 170, 40);
        jb2.setFont(new Font("Arial", Font.BOLD, 20));
        add(jb2);

        jb3 = new JButton("Choose Bg Color");
        jb3.setBounds(190, 360, 180, 35);
        jb3.setFont(new Font("Arial", Font.BOLD, 16));
        add(jb3);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

        setSize(650, 450);
        setLocation(200, 60);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            int bal = 0;
            try {
                Conn c1 = new Conn();

                ResultSet rs1 = c1.s.executeQuery("select * from loan where pin = '" + pin + "'");
                if (rs1.next()) {
                    bal = Integer.parseInt(rs1.getString("amount"));
                }
                if (jt1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter amount ");
                } else if ((Integer.parseInt(jt1.getText())) < bal) {
                    JOptionPane.showMessageDialog(null, "Enter amount " + bal);

                } else if ((Integer.parseInt(jt1.getText())) > bal) {
                    JOptionPane.showMessageDialog(null, "Enter amount " + bal);

                } else {
                    String del = "delete from loan where pin = '" + pin + "'";
                    c1.s.executeUpdate(del);
                    JOptionPane.showMessageDialog(null, "Loan Payment Done.");
                    this.setVisible(false);
                   new Transactions(pin).setVisible(true);
                    

                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } else if (e.getSource() == jb2) {
            this.setVisible(false);
            new More(pin).setVisible(true);
        } else if (e.getSource() == jb3) {
            Color color = JColorChooser.showDialog(null, "Choose any color ", Color.yellow);
            getContentPane().setBackground(color);
        }

    }

    public static void main(String[] args) {
        new Pay("");
    }

}
