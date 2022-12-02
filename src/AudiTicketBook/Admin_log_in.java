package AudiTicketBook;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admin_log_in extends JFrame {

    private final JPanel contentPane;
    private final JTextField textField;
    private final JPasswordField passwordField;
    private final JLabel Error;

    /**
     * Create the frame.
     */
    public Admin_log_in() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 540);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(27, 153, 139));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                back();
            }
        });
        btnNewButton.setBounds(10, 467, 108, 23);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("Admin");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblNewLabel.setBounds(370, 81, 200, 73);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Log In");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblNewLabel_1.setBounds(368, 138, 138, 56);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(353, 330, 182, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(353, 381, 182, 20);
        contentPane.add(passwordField);

        JLabel lblNewLabel_2 = new JLabel("Username");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setBounds(242, 310, 182, 56);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("Password");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2_1.setBounds(242, 361, 182, 56);
        contentPane.add(lblNewLabel_2_1);

        JButton btnNewButton_1 = new JButton("Log In");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Log_in();
            }
        });
        btnNewButton_1.setBounds(369, 432, 108, 23);
        contentPane.add(btnNewButton_1);

        Error = new JLabel("");
        Error.setFont(new Font("Tahoma", Font.BOLD, 17));
        Error.setBounds(353, 237, 418, 152);
        contentPane.add(Error);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin_log_in frame = new Admin_log_in();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void Log_in() {
        String name = textField.getText();
        String pwd = passwordField.getText();
        if (name.equals("") || pwd.equals("")) {
            Error.setText("Field cannot be empty");
            return;
        }
        if (name.equals("admin") && pwd.equals("password")) {
            Admin_Screen sc = new Admin_Screen();
            sc.setVisible(true);
            this.dispose();
        } else {
            Error.setText("Username/Password incorrect");
		}
    }

    private void back() {
        Landing_Screen sc = new Landing_Screen();
        sc.setVisible(true);
        this.dispose();
    }

}
