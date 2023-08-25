package bankmanegment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class ApplyIncu extends JFrame implements ActionListener {
    
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JRadioButton r1, r2, r3, r4, r5, r8, r9;
    JButton b, b4, b5;
    JComboBox c1, c2, c3, c4, c5;
    Cursor crc;
    
    Random ran = new Random();
    int first4 = (ran.nextInt() % 900) + 100;
    String first = "" + Math.abs(first4);
    String pin;
    
    ApplyIncu(String pin) {
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
        
        l3 = new JLabel("Name:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l4 = new JLabel("id: ");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l5 = new JLabel("Plane Option: ");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l6 = new JLabel("Sex:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l7 = new JLabel("Mobile: ");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l8 = new JLabel("Marital status:");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l9 = new JLabel("Spouse Occupation:");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l10 = new JLabel("Coverage Option:");
        l10.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l11 = new JLabel("Spouse Sex:");
        l11.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l12 = new JLabel("Spouse Name:");
        l12.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l13 = new JLabel("Date");
        l13.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l14 = new JLabel("Month");
        l14.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l15 = new JLabel("Year");
        l15.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t2 = new JTextField("" + first);
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));
        
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
        
        b5 = new JButton("BACK");
        b5.setFont(new Font("Raleway", Font.BOLD, 14));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setCursor(crc);
        
        b4 = new JButton("Choose Bg Color");
        b4.setBackground(Color.DARK_GRAY);
        b4.setForeground(Color.WHITE);
        
        b4.setFont(new Font("Arial", Font.BOLD, 14));
        b4.setBounds(320, 660, 180, 30);
        add(b4);
        
        b5.setFont(new Font("Arial", Font.BOLD, 14));
        b5.setBounds(100, 660, 150, 30);
        add(b5);
        
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        
        r4 = new JRadioButton("Unmarried");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        
        r8 = new JRadioButton("Male");
        r8.setFont(new Font("Raleway", Font.BOLD, 14));
        r8.setBackground(Color.WHITE);
        
        r9 = new JRadioButton("Female");
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
        
        String religion[] = {"Silver", "Silver Plus", "Gold", "Platinum"};
        c1 = new JComboBox(religion);
        c1.setBackground(Color.WHITE);
        c1.setSelectedItem("Platinum");
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        c1.setBounds(300, 240, 400, 30);
        add(c1);
        
        String cover[] = {"Self", "Couple", "Family"};
        c2 = new JComboBox(cover);
        c2.setBackground(Color.WHITE);
        c2.setSelectedItem("Self");
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        c2.setBounds(300, 440, 400, 30);
        add(c2);
        
        setLayout(null);
        l1.setBounds(280, 20, 600, 40);
        add(l1);

        //l2.setBounds(290,80,600,30);
        //add(l2);
        l3.setBounds(100, 140, 100, 30);
        add(l3);
        
        t1.setBounds(300, 140, 400, 30);
        add(t1);
        
        l4.setBounds(100, 190, 200, 30);
        add(l4);
        
        t2.setBounds(300, 190, 400, 30);
        add(t2);
        
        l5.setBounds(100, 240, 200, 30);
        add(l5);
        
        l6.setBounds(100, 290, 200, 30);
        add(l6);
        
        r1.setBounds(300, 290, 60, 30);
        add(r1);
        
        r2.setBounds(450, 290, 90, 30);
        add(r2);
        
        l7.setBounds(100, 340, 200, 30);
        add(l7);
        
        t3.setBounds(300, 340, 400, 30);
        add(t3);
        
        l8.setBounds(100, 390, 200, 30);
        add(l8);
        
        r3.setBounds(300, 390, 100, 30);
        add(r3);
        
        r4.setBounds(450, 390, 100, 30);
        add(r4);

//        r5.setBounds(635,390,100,30);
//        add(r5);
        l9.setBounds(100, 590, 200, 30);
        add(l9);

        //t4.setBounds(300, 440, 400, 30);
        //add(t4);
        l10.setBounds(100, 440, 200, 30);
        add(l10);
        
        t5.setBounds(300, 490, 400, 30);
        add(t5);
        
        l11.setBounds(100, 540, 200, 30);
        add(l11);

        // t6.setBounds(300, 540, 400, 30);
        // add(t6);
        r8.setBounds(300, 540, 100, 30);
        add(r8);
        
        r9.setBounds(450, 540, 100, 30);
        add(r9);
        
        l12.setBounds(100, 490, 200, 30);
        add(l12);
        
        t7.setBounds(300, 590, 400, 30);
        add(t7);
        
        b.setBounds(620, 660, 80, 30);
        add(b);
        
        b.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        this.setUndecorated(true);
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
        if (ae.getSource() == b5) {
            setVisible(false);
            new More(pin).setVisible(true);
        } else {
            String formno = first;
            String name = t1.getText();
            String plane = c1.getSelectedItem().toString();
            
            String sex = null;
            if (r1.isSelected()) {
                sex = "Male";
            } else if (r2.isSelected()) {
                sex = "Female";
            }
            String mobile = t3.getText();
            System.out.println(mobile);
            String marital = null;
            if (r3.isSelected()) {
                marital = "Married";
            } else if (r4.isSelected()) {
                marital = "Unmarried";
            }
            
            String coverage = c2.getSelectedItem().toString();
            String SpouseN = t5.getText();
            String SpouseS = null;
            if (r8.isSelected()) {
                marital = "yes";
            } else if (r9.isSelected()) {
                marital = "no";
            }
            String SpouseOcc = t7.getText();
            System.out.println(SpouseOcc);
            try {
                if (t1.getText().equals("")
                        || c1.getSelectedItem().equals("")
                        || t3.getText().equals("")
                        || c2.getSelectedItem().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {
                    Conn c = new Conn();
                    String q1 = "INSERT INTO insurance VALUES('" + pin + "','" + formno + "','" + name + "','" + plane + "','" + mobile + "','" + sex + "','" + coverage + "','" + marital + "','" + SpouseN + "','" + SpouseS + "','" + SpouseOcc + "')";
                    c.s.executeUpdate(q1);
                    setVisible(false);
                    new ApplyIncuOne(first, pin).setVisible(true);
                    
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
    }
    
    public static void main(String[] args) {
        new ApplyIncu("").setVisible(true);
    }
}
