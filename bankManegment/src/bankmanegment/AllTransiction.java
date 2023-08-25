package bankmanegment;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AllTransiction extends JFrame implements ActionListener {

    private JTextArea ta;
    private Container c;
    private JScrollPane js;
    private JLabel jl, j2, j5, j6, j7;
    private Font f;
    private JButton b, b1;
    private JTextField tf;
    private Cursor car;
    String pin;
    private JButton printButton;

    AllTransiction(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/history.jpg"));
        Image i2 = i1.getImage().getScaledInstance(178, 178, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(0, 0, 178, 178);
        add(l14);
        this.setBounds(100, 50, 800, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jl = new JLabel("MTM BANK ");
        f = new Font("Arial", Font.BOLD, 26);
        jl.setBounds(260, 50, 160, 60);
        j5 = new JLabel();
        ta = new JTextArea();
        j6 = new JLabel();
        j7 = new JLabel();
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setFont(new Font("Arial", Font.BOLD, 17));
        ta.setBackground(Color.LIGHT_GRAY);
        j6.setFont(new Font("Arial", Font.BOLD, 17));
        j7.setFont(new Font("Arial", Font.BOLD, 17));
this.setUndecorated(true);
        ta.setBounds(50, 180, 700, 300);
        j6.setBounds(50, 140, 1000, 200);
        j7.setBounds(150, 500, 500, 80);
        // j5.setBackground(Color.red);
        this.setTitle("DETAILS INFORMATION");
        car = new Cursor(Cursor.HAND_CURSOR);

        b = new JButton("DASHBOARD");
        b.setBounds(480, 50, 200, 60);
        b.setFont(new Font("Arial", Font.BOLD, 17));
        b.setCursor(car);
        b.addActionListener(this);

        printButton = new JButton("PRINT");
        printButton.setBounds(300, 500, 100, 30);
        printButton.setFont(new Font("Arial", Font.BOLD, 14));
        printButton.setCursor(car);
        printButton.addActionListener(this);

        //js = new JScrollPane(ta);
        //js.setBounds(50, 200, 200, 320);
        jl.setFont(f);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);
        //c.add(js);
        c.add(jl);
        c.add(b);
        c.add(ta);
        // c.add(j6);
        c.add(j7);
        c.add(printButton);

        try {

            Conn c1 = new Conn();

            ResultSet rs = c1.s.executeQuery("select * from history where pin = '" + pin + "'");
            double balance = 0;
           // "                                    " + "All Transiction"

            ta.setText("                                                                All Transiction\n            Date                                    CardNumber          Pin           Type          Amount      \n");

            while (rs.next()) {
                ta.append(rs.getString("date") + "    " + rs.getString("cardnumber") + "           " + ("XXX") + "           " + rs.getString("type") + "     " + rs.getString("amount") + "\n");
                if (rs.getString("type").equals("Deposit")) {
                    balance += Double.parseDouble(rs.getString("amount"));
                } else {
                    balance -= Double.parseDouble(rs.getString("amount"));
                }
            }
            ta.append("\n\n\n\nYour total Balance is " + balance + " Tk");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: " + e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            new More(pin).setVisible(true);
            setVisible(false);
        } else if (e.getSource() == printButton) {
            try {
                ta.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new AllTransiction("").setVisible(true);
    }
}
