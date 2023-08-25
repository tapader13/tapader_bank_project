package bankmanegment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interest extends JFrame implements ActionListener {
    
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
    JButton submit, cancel, chooser;
    JRadioButton r1, r2, r3, r4, job, business, student, govtSer, Bekar;
    JTextField t1, t2, t3, incomeF;
    JComboBox c1;
    ButtonGroup gp1;
    String pin;

    Interest(String pin) {
        this.pin = pin;
        setLayout(null);
        setTitle("INTEREST CALCULATION");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/signin.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(100, 50, 200, 200);
        add(l14);
        
        l5 = new JLabel("GIVE SOME INFORMATION");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l6 = new JLabel("Ammount:");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l7 = new JLabel("Occupation:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l8 = new JLabel("Year:");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        this.setUndecorated(true);
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        
        cancel = new JButton("DASHBOARD");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        
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
        
        govtSer = new JRadioButton("Govt. Service");
        govtSer.setFont(new Font("Raleway", Font.BOLD, 14));
        govtSer.setBackground(Color.WHITE);
        govtSer.setBounds(350, 450, 150, 30);
        add(govtSer);
        
        Bekar = new JRadioButton("Bekar");
        Bekar.setFont(new Font("Raleway", Font.BOLD, 14));
        Bekar.setBackground(Color.WHITE);
        Bekar.setBounds(550, 450, 100, 30);
        add(Bekar);
        
        gp1 = new ButtonGroup();
        gp1.add(job);
        gp1.add(student);
        gp1.add(business);
        gp1.add(Bekar);
        gp1.add(govtSer);
        
        incomeF = new JTextField();
        incomeF.setBounds(330, 255, 320, 30);
        incomeF.setFont(new Font("Raleway", Font.BOLD, 14));
        add(incomeF);
        
        l5.setBounds(360, 100, 600, 40);
        l5.setFont(new Font("Arial", Font.BOLD, 26));
        add(l5);
        
        l6.setBounds(170, 250, 150, 30);
        add(l6);
        
        l8.setBounds(170, 300, 150, 30);
        add(l8);
        
        l7.setBounds(170, 400, 150, 30);
        add(l7);

//        c5.setBounds(350, 340, 320, 30);
//        add(c5);
        t2.setBounds(330, 300, 320, 30);
        add(t2);
        
        submit.setBounds(540, 600, 130, 30);
        add(submit);
        
        cancel.setBounds(540, 640, 130, 30);
        add(cancel);
        
        chooser = new JButton("Choose Bg Color");
        chooser.setBackground(Color.DARK_GRAY);
        chooser.setForeground(Color.WHITE);
        
        chooser.setFont(new Font("Arial", Font.BOLD, 14));
        chooser.setBounds(270, 660, 180, 30);
        add(chooser);
        
        cancel.addActionListener(this);
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
        
        if (ae.getSource() == cancel) {
            setVisible(false);
            new More(pin).setVisible(true);
        } else if (ae.getSource() == chooser) {
            Color color = JColorChooser.showDialog(null, "Choose any color ", Color.yellow);
            getContentPane().setBackground(color);
        } else {
            if (incomeF.getText().equals("") || t2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter full info");
                
            } else {
                int taka = Integer.parseInt(incomeF.getText());
                int year = Integer.parseInt(t2.getText());
                if (job.isSelected()) {
                    double res = (taka + (taka * 0.05 * year));
                    JOptionPane.showMessageDialog(null, "MTM BANK Give You Total : " + res + " Tk");
                    
                } else if (business.isSelected()) {
                    double res = (taka + (taka * 0.03 * year));
                    JOptionPane.showMessageDialog(null, "MTM BANK Give You Total : " + res + " Tk");
                } else if (student.isSelected()) {
                    double res = (taka + (taka * 0.01 * year));
                    JOptionPane.showMessageDialog(null, "MTM BANK Give You Total : " + res + " Tk");
                } else if (Bekar.isSelected()) {
                    double res = (taka + (taka * 0.07 * year));
                    JOptionPane.showMessageDialog(null, "MTM BANK Give You Total : " + res + " Tk");
                } else if (govtSer.isSelected()) {
                    double res = (taka + (taka * 0.04 * year));
                    JOptionPane.showMessageDialog(null, "MTM BANK Give You Total : " + res + " Tk");
                }
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        new Interest("").setVisible(true);
    }
}
