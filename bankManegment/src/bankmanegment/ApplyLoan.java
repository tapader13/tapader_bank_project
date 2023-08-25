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

public class ApplyLoan extends JFrame implements ActionListener {

    JLabel j1, j2, j3,j4;
    JTextField jt1;
    JButton jb1, jb2, jb3;
    String pin;

    ApplyLoan(String pin) {
        this.pin = pin;
        this.setTitle("LOAN BOARD");
        this.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/loan.jpg"));
        Image i2 = i1.getImage().getScaledInstance(190, 160, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(0, 0, 190, 160);
        getContentPane().add(l14);

        j1 = new JLabel("MTM BANK");
        j1.setBounds(340, 35, 180, 60);
        j1.setFont(new Font("Arial", Font.BOLD, 22));
        add(j1);

        j2 = new JLabel("Apply For Loan");
        j2.setBounds(320, 110, 180, 60);
        j2.setFont(new Font("Arial", Font.BOLD, 24));
        add(j2);

        j3 = new JLabel("Amount: ");
        j3.setBounds(140, 200, 120, 60);
        j3.setFont(new Font("Arial", Font.BOLD, 18));
        add(j3);

         j4 = new JLabel("Higest Loan 100 Million");
        j4.setBounds(320, 150, 240, 60);
        j4.setFont(new Font("Arial", Font.BOLD, 16));
        j4.setForeground(Color.red);
        add(j4);
        

        jt1 = new JTextField();
        jt1.setBounds(250, 210, 130, 40);
        jt1.setFont(new Font("Arial", Font.BOLD, 18));
        add(jt1);

        jb1 = new JButton("APPLY");
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

         this.setUndecorated(true);
        setSize(650, 450);
        setLocation(200, 60);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            if (jt1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter some amount");
            } else if ((Integer.parseInt(jt1.getText())) < 5000) {
                JOptionPane.showMessageDialog(null, "Minimum 5000");

            } else {
                Conn c1 = new Conn();
                try {
                    ResultSet rs1 = c1.s.executeQuery("select * from loan where pin = '" + pin + "'");
                    if (rs1.next()) {
                        JOptionPane.showMessageDialog(null, "First pay old loan then apply for new Loan.");

                       this.setVisible(false);
                       new Pay(pin).setVisible(true);
                    } else {
                        System.out.println("yes");
                        String formno = null;

                        int amont = Integer.parseInt(jt1.getText());
                        ResultSet rs5 = c1.s.executeQuery("select * from login where pin = '" + pin + "'");
                        if (rs5.next()) {
                            formno = rs5.getString("formno");

                        }
                        ResultSet rs2 = c1.s.executeQuery("select * from balance where pin = '" + pin + "'");
                        double balance = 0;
                        Boolean occu = null;
                        int income = 0;
                        while (rs2.next()) {
                            if (rs2.getString("type").equals("Deposit")) {
                                balance += Double.parseDouble(rs2.getString("amount"));
                            } else {
                                balance -= Double.parseDouble(rs2.getString("amount"));
                            }
                        }
                        ResultSet rs3 = c1.s.executeQuery("select * from signuptwo where formno = '" + formno + "'");
                        if (rs3.next()) {
                            occu = rs3.getString("occupation").equals("Job");
                            income = Integer.parseInt(rs3.getString("income"));
                        }
                        if (occu != null && occu.booleanValue()  && (income >= 10000) && (balance >= (amont / 5))) {

                            c1.s.executeUpdate("insert into loan values('" + pin + "', 'Withdrow', '" + amont + "')");
                            JOptionPane.showMessageDialog(null, "Loan Apply Accepted by Bank owner.");

                        } else {
                            JOptionPane.showMessageDialog(null, "Loan Apply Rejected by Bank owner.");

                        }

                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
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
        new ApplyLoan("");
    }

}
