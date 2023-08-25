package bankmanegment;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginInFo extends JFrame {

    private String cardno, pin;
    private JLabel jc, jp, l11;
    private ImageIcon img;

    LoginInFo(String cardno, String pin) {
        this.cardno = cardno;
        this.pin = pin;
        this.setVisible(true);
        this.setBounds(1000, 100, 400, 300);
        this.setTitle("Get PassWord and Card No");
        jc = new JLabel("card no: " + cardno);
        this.setLayout(null);
        jc.setForeground(Color.red);
        jc.setBounds(30, 110, 300, 50);
        jc.setFont(new Font("Arial", Font.BOLD, 22));
        add(jc);

        jp = new JLabel("password: " + pin);
        this.setLayout(null);
        jp.setBounds(30, 160, 190, 50);
        jp.setForeground(Color.red);
        jp.setFont(new Font("Arial", Font.BOLD, 22));

        add(jp);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegment/icons/info.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l11 = new JLabel(i3);
        l11.setBounds(0, 0, 300, 300);
        add(l11);

    }

    public static void main(String[] args) {
        new LoginInFo("", "");
    }
}
