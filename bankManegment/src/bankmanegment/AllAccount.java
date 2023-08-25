package bankmanegment;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class AllAccount extends JFrame implements ActionListener {

    private JTable table;
    private Container c;
    private JScrollPane scrollPane;
    private JLabel jl, j2;
    private Font f;
    private JButton b, b1;
    private JTextField tf;
    private Cursor car;
    String pin;
    private JButton pr;

    AllAccount(String pin) {
        this.pin = pin;
        this.setBounds(100, 50, 970, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jl = new JLabel("MTM BANK ");
        f = new Font("Arial", Font.BOLD, 22);
        jl.setBounds(50, 50, 150, 60);

        table = new JTable();
        table.setFont(new Font("Arial", Font.BOLD, 17));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 17));

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 200, 885, 320);

        this.setTitle("DETAILS INFORMATION");
        car = new Cursor(Cursor.HAND_CURSOR);
      this.setUndecorated(true);
        b = new JButton("DASHBOARD");
        b.setBounds(320, 50, 200, 60);
        b.setFont(f);
        b.setCursor(car);
        b.addActionListener(this);
        
         pr = new JButton("PRINT");
        pr.setBounds(400, 550, 130, 30);
        pr.setFont(f);
        pr.setCursor(car);
        pr.addActionListener(this);

        jl.setFont(f);
        c = this.getContentPane();
        c.setLayout(null);
        c.add(jl);
        c.add(b);
        c.add(scrollPane);
        c.add(pr);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Postcode");
        model.addColumn("Village");
        model.addColumn("Occupation");
        model.addColumn("Card Number");
        model.addColumn("ID Card Number");
       
        table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
      
        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT l.formno, l.cardnumber, s.Cname, s.postcode, s.village, st.occupation, st.idcardnumber "
                    + "FROM login AS l "
                    + "JOIN signup AS s ON l.formno = s.formno "
                    + "JOIN signuptwo AS st ON l.formno = st.formno");

            while (rs.next()) {
                String name = rs.getString("Cname");
                String postcode = rs.getString("postcode");
                String village = rs.getString("village");
                String occ = rs.getString("occupation");
                String cardNum = rs.getString("cardnumber");
                String idcar = rs.getString("idcardnumber");

                model.addRow(new Object[]{name, postcode, village, occ, cardNum, idcar});

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: " + e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == pr) {
            try {
                table.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == b) {
            new More(pin).setVisible(true);
            setVisible(false);
        }
       
    }

    public static void main(String[] args) {
        new AllAccount("").setVisible(true);
    }
}
