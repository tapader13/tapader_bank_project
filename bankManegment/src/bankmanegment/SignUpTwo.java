package bankmanegment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;

public class SignUpTwo extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
    JButton submit, backlogin, chooser;
    JRadioButton r1, r2, r3, r4, job, business, student;
    JTextField t1, t2, t3, incomeF;
    JComboBox c1, c2, c3, c4, c5;
    String formno;
    ButtonGroup gp1, gp2, gp3;
    private Random random;

    SignUpTwo(String formno) {
        setLayout(null);
        setTitle("CREATE ACCOUNT");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/signin.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(100, 0, 150, 150);
        add(l14);

        random = new Random();

        this.formno = formno;
        //  setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        l1 = new JLabel("ACCOUNT NO." + formno);
        l1.setFont(new Font("Raleway", Font.BOLD, 38));

        l3 = new JLabel("Account Category:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));

        l4 = new JLabel("Income:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));

        l5 = new JLabel("Educational Degree:");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));

        l6 = new JLabel("Occupation:");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));

        l8 = new JLabel("ID card Number:");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));

        l10 = new JLabel("Existing Account:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);

        backlogin = new JButton("Back Login");
        backlogin.setFont(new Font("Raleway", Font.BOLD, 14));
        backlogin.setBackground(Color.BLACK);
        backlogin.setForeground(Color.WHITE);

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));

        job = new JRadioButton("Job");
        job.setFont(new Font("Raleway", Font.BOLD, 14));
        job.setBackground(Color.WHITE);
        job.setBounds(350, 390, 100, 30);
        add(job);

        student = new JRadioButton("Student");
        student.setFont(new Font("Raleway", Font.BOLD, 14));
        student.setBackground(Color.WHITE);
        student.setBounds(450, 390, 100, 30);
        add(student);

        business = new JRadioButton("Business");
        business.setFont(new Font("Raleway", Font.BOLD, 14));
        business.setBackground(Color.WHITE);
        business.setBounds(550, 390, 100, 30);
        add(business);

        gp1 = new ButtonGroup();
        gp1.add(job);
        gp1.add(student);
        gp1.add(business);

        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);

        gp2 = new ButtonGroup();
        gp2.add(r3);
        gp2.add(r4);

        incomeF = new JTextField();
        incomeF.setBounds(350, 245, 320, 30);
        incomeF.setFont(new Font("Raleway", Font.BOLD, 14));
        add(incomeF);

        String category[] = {"General", "Securities account", "Current account", "Business", "Other"};
        c2 = new JComboBox(category);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));

        String education[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        c4 = new JComboBox(education);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));

        l1.setBounds(280, 70, 600, 40);
        add(l1);

        l3.setBounds(100, 170, 200, 30);
        add(l3);

        c2.setBounds(350, 170, 320, 30);
        add(c2);

        l4.setBounds(100, 245, 100, 30);
        add(l4);

        l5.setBounds(100, 310, 190, 30);
        add(l5);

        c4.setBounds(350, 310, 320, 30);
        add(c4);

        l6.setBounds(100, 390, 150, 30);
        add(l6);

//        c5.setBounds(350, 340, 320, 30);
//        add(c5);
        l8.setBounds(100, 470, 180, 30);
        add(l8);

        t2.setBounds(350, 470, 320, 30);
        add(t2);

        l10.setBounds(100, 540, 180, 30);
        add(l10);

        r3.setBounds(350, 540, 100, 30);
        add(r3);

        r4.setBounds(460, 540, 100, 30);
        add(r4);

        submit.setBounds(570, 600, 140, 30);
        add(submit);

        backlogin.setBounds(570, 640, 140, 30);
        add(backlogin);

        chooser = new JButton("Choose Bg Color");
        chooser.setBackground(Color.DARK_GRAY);
        chooser.setForeground(Color.WHITE);

        chooser.setFont(new Font("Arial", Font.BOLD, 14));
        chooser.setBounds(270, 660, 180, 30);
        add(chooser);

        backlogin.addActionListener(this);
        submit.addActionListener(this);

        chooser.addActionListener(this);
        getContentPane().setBackground(Color.WHITE);

        setSize(850, 750);
        setLocation(500, 60);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //String religion = (String)c1.getSelectedItem(); 
        String category = (String) c2.getSelectedItem();
        String income = (String) incomeF.getText();
        String education = (String) c4.getSelectedItem();

        String cardno = generateCardNumber();
        String pin = generatePIN();

        String occupation = null;
        if (job.isSelected()) {
            occupation = "Job";
        } else if (business.isSelected()) {
            occupation = "Business";
        } else {
            occupation = "student";
        }

        String idcard = t2.getText();

        if (ae.getSource() == chooser) {
            Color color = JColorChooser.showDialog(null, "Choose any color ", Color.yellow);
            getContentPane().setBackground(color);
        }
        String eaccount = "";
        if (r3.isSelected()) {
            eaccount = "Yes";
        } else if (r4.isSelected()) {
            eaccount = "No";
        }

        try {
            if (ae.getSource() == submit) {
                if (t2.getText().equals("") || (income.equals(""))) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {
                    Conn c1 = new Conn();
                    String q1 = "insert into signuptwo values('" + formno + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + idcard + "','" + eaccount + "')";
                    String q2 = "insert into login values('" + formno + "','" + cardno + "','" + pin + "')";

                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);

                    setVisible(false);
                    new LoginInFo(cardno, pin).setVisible(true);
                    new Deposite(pin).setVisible(true);

                }
            } else if (ae.getSource() == backlogin) {
                setVisible(false);
                new Login().setVisible(true);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String generateCardNumber() {
        long first7 = (random.nextInt() % 90000000L) + 50406759L;
        return String.valueOf(Math.abs(first7));
    }

    private String generatePIN() {
        long first3 = (random.nextInt() % 9000L) + 1000L;
        return String.valueOf(Math.abs(first3));
    }

    public static void main(String[] args) {
        new SignUpTwo("").setVisible(true);
    }
}
