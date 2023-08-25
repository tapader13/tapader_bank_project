
package bankmanegment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ChangePassword extends JFrame implements ActionListener{
    
    JPasswordField t1,t2;
    JButton b1,b2,b3;                               
    JLabel l1,l2,l3;
    String pin;
    ChangePassword(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/password.jpg"));
        Image i2 = i1.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(40, 40, 160, 160);
        add(l4);
        
        l1 = new JLabel("RE-SET YOUR PASSWORD");
        l1.setFont(new Font("System", Font.BOLD, 23));
        
        l2 = new JLabel("New Password:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("RE-SET");
        b2 = new JButton("DASHBOARD");
        b3=new JButton("Choose Bg Color");
         b3.setBackground(Color.DARK_GRAY);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial", Font.BOLD, 14));
       // b3.setBounds(150, 390, 180, 30);
        //add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        setLayout(null);
        
        l1.setBounds(300,120,300,35);
        add(l1);
        
        l2.setBounds(230,200,150,35);
        add(l2);
        
        
        
        
        t2.setBounds(390,205,180,25);
        t2.setEchoChar('$');
        add(t2);
        
        b1.setBounds(220,260,150,35);
        add(b1);
        
        b2.setBounds(390,260,150,35);
        add(b2);
        
        b3.setBounds(45,260,160,35);
        add(b3);
        
        setSize(660,400);
        setLocation(200,100);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        try{        
            String npin = t2.getText();
            
           
            
            if(ae.getSource()==b1){
                if (t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New Password");
                }
           
                
                Conn c1 = new Conn();
                String q1 = "update balance set pin = '"+npin+"' where pin = '"+pin+"' ";
                String q2 = "update login set pin = '"+npin+"' where pin = '"+pin+"' ";
                String q3 = "update history set pin = '"+npin+"' where pin = '"+pin+"' ";

                //String q3 = "update signup3 set pin = '"+npin+"' where pin = '"+pin+"' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
               c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "Changed Done");
                setVisible(false);
                new More(npin).setVisible(true);
            
            }else if(ae.getSource()==b2){
                new More(pin).setVisible(true);
                setVisible(false);
            }
             else if (ae.getSource() == b3) {
            Color color = JColorChooser.showDialog(null, "Choose any color ", Color.yellow);
            getContentPane().setBackground(color);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new ChangePassword("").setVisible(true);
    }
}
