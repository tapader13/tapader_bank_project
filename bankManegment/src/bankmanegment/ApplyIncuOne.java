package bankmanegment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class ApplyIncuOne extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JRadioButton r1, r2, r3, r4, r5, r8, r9;
    JButton b, b4;
    JComboBox c1, c2, c3, c4, c5;
    Cursor crc;
    String first, pin;

    ApplyIncuOne(String first, String pin) {
        this.first = first;
        this.pin = pin;
        setTitle("CREATE ACCOUNT");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/signin.jpg"));
        Image i2 = i1.getImage().getScaledInstance(180, 120, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l111 = new JLabel(i3);
        l111.setBounds(160, 0, 100, 100);
        add(l111);

        crc = new Cursor(Cursor.HAND_CURSOR);

        l1 = new JLabel("ACCOUNT NO. " + first);
        l1.setFont(new Font("Raleway", Font.BOLD, 38));

        l3 = new JLabel("Suffering From: ");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));

        l4 = new JLabel("Duration: ");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));

        //   l5 = new JLabel("Plane Option: ");
        //  l5.setFont(new Font("Raleway", Font.BOLD, 20));
        l6 = new JLabel("Receiving Treatment:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));

        l7 = new JLabel("Doctor Name: ");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));

        l8 = new JLabel("Medical Test:");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));

        l11 = new JLabel("Are You Smoker? ");
        l11.setFont(new Font("Raleway", Font.BOLD, 20));

        l12 = new JLabel("Medical Name:");
        l12.setFont(new Font("Raleway", Font.BOLD, 20));

        l13 = new JLabel("Date");
        l13.setFont(new Font("Raleway", Font.BOLD, 14));

        l14 = new JLabel("Month");
        l14.setFont(new Font("Raleway", Font.BOLD, 14));

        l15 = new JLabel("Year");
        l15.setFont(new Font("Raleway", Font.BOLD, 14));

        // t1 = new JTextField();
        // t1.setFont(new Font("Raleway", Font.BOLD, 14));
        t2 = new JTextField("" + first);
        t2.setFont(new Font("Raleway", Font.BOLD, 14));

        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));
        this.setUndecorated(true);
        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));

        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));

        // t6 = new JTextField();
        // t6.setFont(new Font("Raleway", Font.BOLD, 14));
        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 14));

        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setCursor(crc);

        this.setUndecorated(true);
        b4 = new JButton("Choose Bg Color");
        b4.setBackground(Color.DARK_GRAY);
        b4.setForeground(Color.WHITE);

        b4.setFont(new Font("Arial", Font.BOLD, 14));
        b4.setBounds(270, 660, 180, 30);
        add(b4);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);

        r8 = new JRadioButton("Yes");
        r8.setFont(new Font("Raleway", Font.BOLD, 14));
        r8.setBackground(Color.WHITE);

        r9 = new JRadioButton("No");
        r9.setFont(new Font("Raleway", Font.BOLD, 14));
        r9.setBackground(Color.WHITE);

//        r5 = new JRadioButton("Other");
//        r5.setFont(new Font("Raleway", Font.BOLD, 14));
//        r5.setBackground(Color.WHITE);
        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(r3);
        groupstatus.add(r4);
        //groupstatus.add(r5);

        ButtonGroup groupstatu = new ButtonGroup();
        groupstatu.add(r8);
        groupstatu.add(r9);

        String suffer[] = {"asthma", "diabetes", "tuberculosis", "rheumatic fever", "heart disease", "hypertension", "epilepsy", "kidney disease", "cancer", "mental illness", "Choronic illness", "others"};
        c1 = new JComboBox(suffer);
        c1.setBackground(Color.WHITE);
        c1.setSelectedItem("Platinum");
        c1.setFont(new Font("Raleway", Font.BOLD, 14));

        c1.setBounds(300, 140, 400, 30);
        add(c1);

        String cover[] = {"Six month", "One Year", "More then One Year"};
        c2 = new JComboBox(cover);
        c2.setBackground(Color.WHITE);
        // c2.setSelectedItem("Self");
        c2.setFont(new Font("Raleway", Font.BOLD, 14));

        c2.setBounds(300, 205, 400, 30);
        add(c2);

        setLayout(null);
        l1.setBounds(280, 20, 600, 40);
        add(l1);

        //l2.setBounds(290,80,600,30);
        //add(l2);
        l3.setBounds(100, 140, 160, 30);
        add(l3);

        // t1.setBounds(300, 140, 400, 30);
        //add(t1);
        l4.setBounds(100, 205, 200, 30);
        add(l4);

        //t2.setBounds(300, 190, 400, 30);
        //add(t2);
        // l5.setBounds(100, 240, 200, 30);
        // add(l5);
        l6.setBounds(100, 270, 220, 30);
        add(l6);

        r1.setBounds(330, 270, 60, 30);
        add(r1);

        r2.setBounds(470, 270, 90, 30);
        add(r2);

        l7.setBounds(100, 340, 200, 30);
        add(l7);

        t3.setBounds(300, 340, 400, 30);
        add(t3);

        l8.setBounds(100, 410, 200, 30);
        add(l8);

        r3.setBounds(300, 410, 100, 30);
        add(r3);

        r4.setBounds(450, 410, 100, 30);
        add(r4);

        t5.setBounds(300, 470, 400, 30);
        add(t5);

        l11.setBounds(100, 540, 200, 30);
        add(l11);

        r8.setBounds(300, 540, 100, 30);
        add(r8);

        r9.setBounds(450, 540, 100, 30);
        add(r9);

        l12.setBounds(100, 470, 200, 30);
        add(l12);

        b.setBounds(620, 660, 80, 30);
        add(b);

        b.addActionListener(this);
        b4.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 750);
        setLocation(500, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b4) {
            Color color = JColorChooser.showDialog(null, "Choose any color ", Color.yellow);
            getContentPane().setBackground(color);
        }
        if (ae.getSource() == b) {
            String formno = first;
            String suffer = c1.getSelectedItem().toString();
            String cov = c2.getSelectedItem().toString();

            String trt = null;
            if (r1.isSelected()) {
                trt = "Yes";
            } else if (r2.isSelected()) {
                trt = "No";
            }

            String doctor = t3.getText();
            String test = null;
            if (r3.isSelected()) {
                test = "Yes";
            } else if (r4.isSelected()) {
                test = "No";
            }

            String madiname = t5.getText();
            String smoke = null;
            if (r8.isSelected()) {
                smoke = "Yes";
            } else if (r9.isSelected()) {
                smoke = "No";
            }
            try {
                if (c1.getSelectedItem().equals("")
                        || c2.getSelectedItem().equals("")
                        || t5.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {
                    Conn c = new Conn();
                    String q1 = "INSERT INTO insuranceOne VALUES('" + formno + "','" + suffer + "','" + cov + "','" + trt + "','" + doctor + "','" + test + "','" + madiname + "','" + smoke + "')";
                    c.s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Your Policy ID " + formno);

                    setVisible(false);
                    new Transactions(pin).setVisible(true);

                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public static void main(String[] args) {
        new ApplyIncuOne("", "").setVisible(true);
    }
}
