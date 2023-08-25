package bankmanegment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Date;
import java.sql.*;

public class Claim extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t16, t13, t14, t15, t17, t18;
    JRadioButton r1, r2, r3, r4, r5, r8, r9;
    JButton b, b4,b5;
    JComboBox c1, c2, c3, c4, c5;
    Cursor crc;

    Random ran = new Random();
    int first4 = (ran.nextInt() % 900) + 100;
    String first = "" + Math.abs(first4);
    String pin;
   

    Claim(String pin) {
//          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/pay.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(850, 800, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l2 = new JLabel(i3);
//        l2.setBounds(500, 50, 850, 800);
//        add(l2);
        this.pin = pin;
        setTitle("CLAIM POLICY");
      
        crc = new Cursor(Cursor.HAND_CURSOR);

        l3 = new JLabel("Policy Name:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));

        l4 = new JLabel("Policy id: ");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));

        l5 = new JLabel("Relation With Policyholder: ");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));

        l6 = new JLabel(" Breakup of treatment Expenses ");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        l6.setForeground(Color.RED);
        l7 = new JLabel("Name of Hospital: ");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));

        l1 = new JLabel("Account Name: ");
        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l2 = new JLabel("Password : ");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));

        l8 = new JLabel(" Hospital Accommodation Charge : ");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        l9 = new JLabel("Consultation fee : ");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        l10 = new JLabel("Medical Investigation Expense : ");
        l10.setFont(new Font("Raleway", Font.BOLD, 20));
        l11 = new JLabel("Medicines : ");
        l11.setFont(new Font("Raleway", Font.BOLD, 20));
        l16 = new JLabel("Surgical Expense : ");
        l16.setFont(new Font("Raleway", Font.BOLD, 20));
        l13 = new JLabel("Ancillary Services fee : ");
        l13.setFont(new Font("Raleway", Font.BOLD, 20));
        l14 = new JLabel("Other Expense(if any) : ");
        l14.setFont(new Font("Raleway", Font.BOLD, 20));
        l15 = new JLabel("Total Claim Amount : ");
        l15.setFont(new Font("Raleway", Font.BOLD, 20));

        l12 = new JLabel("Area:");
        l12.setFont(new Font("Raleway", Font.BOLD, 20));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));

        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));

        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));

        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));

        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setCursor(crc);
        
        b5 = new JButton("BACK");
        b5.setFont(new Font("Raleway", Font.BOLD, 14));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setCursor(crc);

        b4 = new JButton("Choose Bg Color");
        b4.setBackground(Color.DARK_GRAY);
        b4.setForeground(Color.WHITE);

        b4.setFont(new Font("Arial", Font.BOLD, 14));
        b4.setBounds(320, 710, 180, 30);
        add(b4);
        
         b5.setFont(new Font("Arial", Font.BOLD, 14));
        b5.setBounds(100, 710, 150, 30);
        add(b5);

        t8 = new JTextField();
        t8.setFont(new Font("Raleway", Font.BOLD, 14));

        t9 = new JTextField();
        t9.setFont(new Font("Raleway", Font.BOLD, 14));

        t10 = new JTextField();
        t10.setFont(new Font("Raleway", Font.BOLD, 14));

        t11 = new JTextField();
        t11.setFont(new Font("Raleway", Font.BOLD, 14));

        t16 = new JTextField();
        t16.setFont(new Font("Raleway", Font.BOLD, 14));

        t13 = new JTextField();
        t13.setFont(new Font("Raleway", Font.BOLD, 14));

        t14 = new JTextField();
        t14.setFont(new Font("Raleway", Font.BOLD, 14));

        t15 = new JTextField();
        t15.setFont(new Font("Raleway", Font.BOLD, 14));

        t17 = new JTextField();
        t17.setFont(new Font("Raleway", Font.BOLD, 14));

        t18 = new JTextField();
        t18.setFont(new Font("Raleway", Font.BOLD, 14));

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String religion[] = {"self", "husband", "wife", "son", "daughter", "mother", "father"};
        c1 = new JComboBox(religion);
        c1.setBackground(Color.WHITE);
        c1.setSelectedItem("self");
        c1.setFont(new Font("Raleway", Font.BOLD, 14));

        c1.setBounds(410, 140, 290, 30);
        add(c1);
        this.
                setLayout(null);
        this.setUndecorated(true);
        l3.setBounds(100, 60, 150, 30);
        add(l3);

        t1.setBounds(300, 60, 400, 30);
        add(t1);

        l4.setBounds(100, 100, 200, 30);
        add(l4);

        t2.setBounds(300, 100, 400, 30);
        add(t2);

        l5.setBounds(100, 140, 280, 30);
        add(l5);

        l7.setBounds(100, 180, 200, 30);
        add(l7);

        t3.setBounds(300, 180, 400, 30);
        add(t3);

        l8.setBounds(100, 310, 350, 30);
        add(l8);
        t8.setBounds(450, 310, 200, 30);
        add(t8);
        l9.setBounds(100, 350, 320, 30);
        add(l9);
        t9.setBounds(450, 350, 200, 30);
        add(t9);
        l10.setBounds(100, 390, 320, 30);
        add(l10);
        t10.setBounds(450, 390, 200, 30);
        add(t10);
        l11.setBounds(100, 430, 320, 30);
        add(l11);
        t11.setBounds(450, 430, 200, 30);
        add(t11);
        l16.setBounds(100, 470, 320, 30);
        add(l16);
        t16.setBounds(450, 470, 200, 30);
        add(t16);
        l13.setBounds(100, 510, 320, 30);
        add(l13);
        t13.setBounds(450, 510, 200, 30);
        add(t13);
        l14.setBounds(100, 550, 320, 30);
        add(l14);
        t14.setBounds(450, 550, 200, 30);
        add(t14);
        l15.setBounds(100, 590, 320, 30);
        add(l15);
        t15.setBounds(450, 590, 200, 30);
        add(t15);
        l1.setBounds(100, 630, 320, 30);
        add(l1);
        t17.setBounds(450, 630, 210, 30);
        add(t17);
        l2.setBounds(100, 670, 320, 30);
        add(l2);
        t18.setBounds(450, 670, 210, 30);
        add(t18);
        l6.setBounds(300, 270, 320, 30);
        add(l6);

        t5.setBounds(300, 220, 400, 30);
        add(t5);

        l12.setBounds(100, 220, 200, 30);
        add(l12);

        b.setBounds(620, 710, 80, 30);
        add(b);

        b.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        // System.out.println(t8.getText());
        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(500, 20);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b4) {
            Color color = JColorChooser.showDialog(null, "Choose any color ", Color.yellow);
            getContentPane().setBackground(color);
        }
        if(ae.getSource()==b5){
            this.setVisible(false);
             new More(pin).setVisible(true);
        }
        if (ae.getSource() == b) {
            try {
                JTextField[] textFields = {t8, t9, t10, t11, t16, t13, t14};
                for (JTextField textField : textFields) {
                    if (textField.getText().isEmpty()) {
                        textField.setText("0");
                    }
                }
                Date date = new Date();
                Conn c = new Conn();
                String formno = null;
                String plane = null;
                String name = null;
                ResultSet rs1 = c.s.executeQuery("select * from insurance where pin = '" + pin + "'");
                if (rs1.next()) {
                    formno = rs1.getString("formno");
                    plane = rs1.getString("plane");
                    name = rs1.getString("name");
                } else {
                    JOptionPane.showMessageDialog(null, "Account Not Available ");

                }
                //System.out.println(t2.getText());
                System.out.println(plane);
                System.out.println(name);
                ResultSet rs2 = c.s.executeQuery("select * from insuranceOne where formno = '" + formno + "'");

                String trt = null;
                if (rs2.next()) {
                    trt = rs2.getString("trt");
                }
                System.out.println(trt);
                double amn = Double.parseDouble(t15.getText());
                double amount = Double.parseDouble(t8.getText()) + Double.parseDouble(t9.getText()) + Double.parseDouble(t10.getText()) + Double.parseDouble(t11.getText()) + Double.parseDouble(t16.getText()) + Double.parseDouble(t13.getText()) + Double.parseDouble(t14.getText());
                if (t1.getText().equals(name) && t2.getText().equals(formno) && Double.compare(amn, amount) == 0) {
                    if (plane.equals("Silver") && trt.equals("Yes")) {
                        double val = Double.parseDouble(t15.getText());
                        if (val <= 300000) {
                            c.s.executeUpdate("insert into balance values('" + pin + "', 'Deposit', '" + val + "')");
                            c.s.executeUpdate("insert into history values('" + pin + "', '" + date + "', '" + t17.getText() + "', 'Deposit', '" + val + "')");
                            JOptionPane.showMessageDialog(null, "Done");

                        } else {
                            JOptionPane.showMessageDialog(null, "Not");

                        }
                    }
                    if (plane.equals("Silver") && trt.equals("No")) {
                        double val = Double.parseDouble(t15.getText());
                        if (val <= 250000) {
                            c.s.executeUpdate("insert into balance values('" + pin + "', 'Deposit', '" + val + "')");
                            c.s.executeUpdate("insert into history values('" + pin + "', '" + date + "', '" + t17.getText() + "', 'Deposit', '" + val + "')");
                            JOptionPane.showMessageDialog(null, "Done");

                        } else {
                            JOptionPane.showMessageDialog(null, "Not");

                        }
                    }
                    if (plane.equals("Silver Plus") && trt.equals("No")) {
                        double val = Double.parseDouble(t15.getText());
                        if (val <= 400000) {
                            c.s.executeUpdate("insert into balance values('" + pin + "', 'Deposit', '" + val + "')");
                            c.s.executeUpdate("insert into history values('" + pin + "', '" + date + "', '" + t17.getText() + "', 'Deposit', '" + val + "')");
                            JOptionPane.showMessageDialog(null, "Done");

                        } else {
                            JOptionPane.showMessageDialog(null, "Not");

                        }
                    }
                    if (plane.equals("Silver Plus") && trt.equals("Yes")) {
                        double val = Double.parseDouble(t15.getText());
                        if (val <= 700000) {
                            c.s.executeUpdate("insert into balance values('" + pin + "', 'Deposit', '" + val + "')");
                            c.s.executeUpdate("insert into history values('" + pin + "', '" + date + "', '" + t17.getText() + "', 'Deposit', '" + val + "')");
                            JOptionPane.showMessageDialog(null, "Done");

                        } else {
                            JOptionPane.showMessageDialog(null, "Not");

                        }
                    }
                    if (plane.equals("Gold") && trt.equals("No")) {
                        double val = Double.parseDouble(t15.getText());
                        if (val <= 800000) {
                            c.s.executeUpdate("insert into balance values('" + pin + "', 'Deposit', '" + val + "')");
                            c.s.executeUpdate("insert into history values('" + pin + "', '" + date + "', '" + t17.getText() + "', 'Deposit', '" + val + "')");
                            JOptionPane.showMessageDialog(null, "Done");

                        } else {
                            JOptionPane.showMessageDialog(null, "Not");

                        }
                    }
                    if (plane.equals("Gold") && trt.equals("Yes")) {
                        double val = Double.parseDouble(t15.getText());
                        if (val <= 400000) {
                            c.s.executeUpdate("insert into balance values('" + pin + "', 'Deposit', '" + val + "')");
                            c.s.executeUpdate("insert into history values('" + pin + "', '" + date + "', '" + t17.getText() + "', 'Deposit', '" + val + "')");
                            JOptionPane.showMessageDialog(null, "Done");

                        } else {
                            JOptionPane.showMessageDialog(null, "Not");

                        }
                    }
                    if (plane.equals("Platinum") && trt.equals("No")) {
                        double val = Double.parseDouble(t15.getText());
                        if (val <= 900000) {
                            c.s.executeUpdate("insert into balance values('" + pin + "', 'Deposit', '" + val + "')");
                            c.s.executeUpdate("insert into history values('" + pin + "', '" + date + "', '" + t17.getText() + "', 'Deposit', '" + val + "')");
                            JOptionPane.showMessageDialog(null, "Done");

                        } else {
                            JOptionPane.showMessageDialog(null, "Not");

                        }
                    }
                    if (plane.equals("Platinum") && trt.equals("Yes")) {
                        double val = Double.parseDouble(t15.getText());
                        if (val <= 1000000) {
                            c.s.executeUpdate("insert into balance values('" + t18.getText() + "', 'Deposit', '" + val + "')");
                            c.s.executeUpdate("insert into history values('" + t18.getText() + "', '" + date + "', '" + t17.getText() + "', 'Deposit', '" + val + "')");
                            JOptionPane.showMessageDialog(null, "Done");

                        } else {
                            JOptionPane.showMessageDialog(null, "Not");

                        }
                    }
                    //JOptionPane.showMessageDialog(null, "Not it");

                    this.setVisible(false);
                    new More(pin).setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public static void main(String[] args) {
        new Claim("").setVisible(true);
    }
}
