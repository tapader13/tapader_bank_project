package bankmanegment;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AccountDetails extends JFrame implements ActionListener {

    private JTable table;
    private Container c;
    private JScrollPane scrollPane;
    private JLabel jl;
    private Font f;
    private JButton b, printButton;
    private Cursor car;
    String pin;

    AccountDetails(String pin) {
        this.pin = pin;
        this.setBounds(100, 20, 600, 800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jl = new JLabel("MTM BANK ");
        f = new Font("Arial", Font.BOLD, 22);
        jl.setBounds(50, 50, 150, 60);
        this.setTitle("DETAILS INFORMATION");
        car = new Cursor(Cursor.HAND_CURSOR);

        b = new JButton("DASHBOARD");
        b.setBounds(280, 60, 200, 60);
        b.setFont(f);
        b.setCursor(car);
        b.addActionListener(this);

        printButton = new JButton("PRINT");
        printButton.setBounds(200, 650, 100, 30);
        printButton.setFont(new Font("Arial", Font.BOLD, 14));
        printButton.setCursor(car);
        printButton.addActionListener(this);

        jl.setFont(f);
        c = this.getContentPane();
        c.setLayout(null);
        c.add(jl);
        c.add(b);
        c.add(printButton);
        this.setUndecorated(true);
        table = new JTable();
        table.setFont(new Font("Arial", Font.BOLD, 17));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 17));

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 140, 510, 478);
        c.add(scrollPane);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Attribute");
        model.addColumn("Value");

        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from balance where pin = '" + pin + "'");
            double balance = 0;
            String formno = null;
            String name = null;
            String fatherName = null;
            String sex = null;
            String village = null;
            String postcode = null;
            String email = null;
            String religion = null;
            String city = null;
            String pincode = null;
            String marital = null;
            String cat = null;
            String occ = null;
            String idcar = null;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Double.parseDouble(rs.getString("amount"));
                } else {
                    balance -= Double.parseDouble(rs.getString("amount"));
                }
            }
            ResultSet rs1 = c1.s.executeQuery("select * from login where pin = '" + pin + "'");
            if (rs1.next()) {
                formno = rs1.getString("formno");
                ResultSet rs2 = c1.s.executeQuery("select * from signup where formno = '" + formno + "'");
                if (rs2.next()) {
                    name = rs2.getString("Cname");
                    fatherName = rs2.getString("father_name");
                    sex = rs2.getString("sex");
                    postcode = rs2.getString("postcode");
                    email = rs2.getString("email");
                    religion = rs2.getString("religion");
                    city = rs2.getString("city");
                    marital = rs2.getString("marital_status");
                    pincode = rs2.getString("pincode");
                    village = rs2.getString("village");
                    ResultSet rs3 = c1.s.executeQuery("select * from signuptwo where formno = '" + formno + "'");
                    if (rs3.next()) {
                        cat = rs3.getString("category");
                        occ = rs3.getString("occupation");
                        idcar = rs3.getString("idcardnumber");
                    }
                }

            }

            model.addRow(new Object[]{"Your name is:", name});
            model.addRow(new Object[]{"Your father name is:", fatherName});
            model.addRow(new Object[]{"Total Balance:", balance});
            model.addRow(new Object[]{"Form Number:", formno});
            model.addRow(new Object[]{"sex:", sex});
            model.addRow(new Object[]{"email:", email});
            model.addRow(new Object[]{"city:", city});
            model.addRow(new Object[]{"village:", village});
            model.addRow(new Object[]{"postcode:", postcode});
            model.addRow(new Object[]{"religion:", religion});
            model.addRow(new Object[]{"marital_status:", marital});
            model.addRow(new Object[]{"pincode:", pincode});
            model.addRow(new Object[]{"id card number:", idcar});
            model.addRow(new Object[]{"occupation:", occ});
            model.addRow(new Object[]{"category:", cat});
            int rowHeight = 30;
           
            table.setModel(model);
             for (int i = 0; i < table.getRowCount(); i++) {
                table.setRowHeight(i, rowHeight);
            }

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
                table.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new AccountDetails("").setVisible(true);
    }
}
