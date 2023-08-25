package bankmanegment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateInfo extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField tf1, lreli, lmarital, lvill, lincome, loccu, lemail, lcity, lpost, ledu;
    JButton b1, b2, b3, b4;
    Cursor crc;
    String pin;
    JLabel reli, marital, vill, income, occu, email, city, post, edu;

    UpdateInfo(String pin) {
        setTitle("UPDATE INFORMATION");
        this.pin = pin;
        crc = new Cursor(Cursor.HAND_CURSOR);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(178, 178, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(0, 0, 178, 178);
        add(l14);
        l1 = new JLabel("MTM BANK");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(255, 40, 450, 40);
        add(l1);

        l3 = new JLabel("UPDATE INFORMATION FORM");
        l3.setFont(new Font("Raleway", Font.BOLD, 24));
        l3.setBounds(200, 120, 550, 30);
        add(l3);

        reli = new JLabel("Religion");
        reli.setFont(new Font("Raleway", Font.BOLD, 16));
        reli.setBounds(110, 190, 130, 30);
        add(reli);

        lreli = new JTextField();
        lreli.setFont(new Font("Raleway", Font.BOLD, 16));
        lreli.setBounds(255, 190, 130, 30);
        add(lreli);

        marital = new JLabel("Marital_status");
        marital.setFont(new Font("Raleway", Font.BOLD, 16));
        marital.setBounds(410, 190, 140, 30);
        add(marital);

        lmarital = new JTextField();
        lmarital.setFont(new Font("Raleway", Font.BOLD, 16));
        lmarital.setBounds(565, 190, 140, 30);
        add(lmarital);

        vill = new JLabel("Village");
        vill.setFont(new Font("Raleway", Font.BOLD, 16));
        vill.setBounds(110, 240, 130, 30);
        add(vill);

        lvill = new JTextField();
        lvill.setFont(new Font("Raleway", Font.BOLD, 16));
        lvill.setBounds(255, 240, 130, 30);
        add(lvill);

        income = new JLabel("Income");
        income.setFont(new Font("Raleway", Font.BOLD, 16));
        income.setBounds(410, 240, 130, 30);
        add(income);

        lincome = new JTextField();
        lincome.setFont(new Font("Raleway", Font.BOLD, 16));
        lincome.setBounds(565, 240, 130, 30);
        add(lincome);

        occu = new JLabel("Occupation");
        occu.setFont(new Font("Raleway", Font.BOLD, 16));
        occu.setBounds(110, 290, 140, 30);
        add(occu);

        loccu = new JTextField();
        loccu.setFont(new Font("Raleway", Font.BOLD, 16));
        loccu.setBounds(255, 290, 130, 30);
        add(loccu);

        email = new JLabel("Email");
        email.setFont(new Font("Raleway", Font.BOLD, 16));
        email.setBounds(410, 290, 140, 30);
        add(email);

        lemail = new JTextField();
        lemail.setFont(new Font("Raleway", Font.BOLD, 16));
        lemail.setBounds(565, 290, 200, 30);
        add(lemail);

        city = new JLabel("City");
        city.setFont(new Font("Raleway", Font.BOLD, 16));
        city.setBounds(110, 340, 130, 30);
        add(city);

        lcity = new JTextField();
        lcity.setFont(new Font("Raleway", Font.BOLD, 16));
        lcity.setBounds(255, 340, 130, 30);
        add(lcity);

        post = new JLabel("Post");
        post.setFont(new Font("Raleway", Font.BOLD, 16));
        post.setBounds(410, 340, 140, 30);
        add(post);

        lpost = new JTextField();
        lpost.setFont(new Font("Raleway", Font.BOLD, 16));
        lpost.setBounds(565, 340, 200, 30);
        add(lpost);

        edu = new JLabel("Education");
        edu.setFont(new Font("Raleway", Font.BOLD, 16));
        edu.setBounds(110, 390, 130, 30);
        add(edu);

        ledu = new JTextField();
        ledu.setFont(new Font("Raleway", Font.BOLD, 16));
        ledu.setBounds(255, 390, 130, 30);
        add(ledu);

        tf1 = new JTextField(15);
        tf1.setBounds(290, 195, 230, 30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        //add(tf1);

        b2 = new JButton("DASHBOARD");
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.WHITE);

        b3 = new JButton("UPDATE");
        b3.setBackground(Color.gray);
        b3.setForeground(Color.WHITE);

        b4 = new JButton("Choose Bg Color");
        b4.setBackground(Color.GRAY);
        b4.setForeground(Color.WHITE);

        setLayout(null);
        this.setResizable(false);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(350, 440, 140, 30);
        add(b2);

        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(120, 440, 100, 30);
        add(b3);

        b4.setFont(new Font("Arial", Font.BOLD, 14));
        b4.setBounds(580, 440, 180, 30);
        add(b4);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        b2.setCursor(crc);
        b3.setCursor(crc);
        b4.setCursor(crc);

        setSize(800, 500);
        setLocation(550, 200);
        this.setUndecorated(true);
        setVisible(true);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        //getContentPane().setBackground(Color.lightGray);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {

            if (ae.getSource() == b3) {
                Conn c = new Conn();
                String formno = null;
                String q1 = "select * from login where pin = '" + pin + "'";
                ResultSet rs1 = c.s.executeQuery(q1);
                if (rs1.next()) {
                    formno = rs1.getString("formno");
                }
                // String q2 = "select * from signup where formno = '" + formno + "'";
                // String q3 = "select * from signuptwo where formno = '" + formno + "'";

                // ResultSet rs2 = c.s.executeQuery(q2);
                // ResultSet rs3 = c.s.executeQuery(q3);
                //  if (rs2.next() && rs3.next()) {
                String mar = lmarital.getText();
                String vil = lvill.getText();
                String inc = lincome.getText();
                String ema = lemail.getText();
                String occ = loccu.getText();
                String cit = lcity.getText();
                String pos = lpost.getText();
                String ed = ledu.getText();
                String rel = lreli.getText();
                if (mar.equals("")) {

                } else {
                    String q5 = "update signup set marital_status = '" + mar + "' where formno = '" + formno + "' ";
                    c.s.executeUpdate(q5);
                }
                if (vil.equals("")) {

                } else {
                    String q6 = "update signup set village = '" + vil + "' where formno = '" + formno + "' ";
                    c.s.executeUpdate(q6);
                }
                if (inc.equals("")) {

                } else {
                    String q7 = "update signuptwo set income = '" + inc + "' where formno = '" + formno + "' ";
                    c.s.executeUpdate(q7);
                }
                if (pos.equals("")) {

                } else {
                    String q11 = "update signup set postcode = '" + pos + "' where formno = '" + formno + "' ";
                    c.s.executeUpdate(q11);
                }
                if (ed.equals("")) {

                } else {
                    String q12 = "update signuptwo set education = '" + ed + "' where formno = '" + formno + "' ";
                    c.s.executeUpdate(q12);
                }
                if (rel.equals("")) {

                } else {
                    String q4 = "update signup set religion = '" + rel + "' where formno = '" + formno + "' ";
                    c.s.executeUpdate(q4);
                }
                if (ema.equals("")) {

                } else {
                    String q8 = "update signup set email = '" + ema + "' where formno = '" + formno + "' ";
                    c.s.executeUpdate(q8);
                }
                if (occ.equals("")) {

                } else {
                    String q9 = "update signuptwo set occupation = '" + occ + "' where formno = '" + formno + "' ";
                    c.s.executeUpdate(q9);
                }
                if (cit.equals("")) {

                } else {
                    String q10 = "update signup set city = '" + cit + "' where formno = '" + formno + "' ";
                    c.s.executeUpdate(q10);
                }
     JOptionPane.showMessageDialog(null, "Update Done.");

                // System.out.println("done");
                //   }
            } else if (ae.getSource() == b4) {
                Color color = JColorChooser.showDialog(null, "Choose any color ", Color.yellow);
                getContentPane().setBackground(color);

            } else if (ae.getSource() == b2) {
                this.setVisible(false);
                new More(pin).setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new UpdateInfo("").setVisible(true);
    }

}
