package AudiTicketBook;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JTextPane;

public class Log_in extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel Error = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log_in frame = new Log_in();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Log_in() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(27, 153, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblNewLabel.setBounds(338, 82, 415, 55);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(304, 301, 227, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(207, 292, 124, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1.setBounds(207, 350, 124, 32);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(304, 360, 227, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				log();
			}
		});
		btnNewButton.setBounds(360, 431, 107, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Landing();
			}
		});
		btnNewButton_1.setBounds(10, 467, 107, 23);
		contentPane.add(btnNewButton_1);
		
		
		Error.setFont(new Font("Tahoma", Font.BOLD, 19));
		Error.setForeground(new Color(255, 28, 28));
		Error.setBounds(277, 179, 298, 46);
		contentPane.add(Error);
	}
	private void log()
	{
		String name=textField.getText();
		String password=passwordField.getText();
		
		if (name.equals("") || password.equals(""))
		{
			Error.setText("Field cannot be empty");
			return;
		}
		Student s;
		try {
			s=Student.login(name, password);
		} catch (Exception e) {
			Error.setText(e.getMessage());
			e.printStackTrace();
			return;
		}
		
		User_Screen sc=new User_Screen(s);
		sc.setVisible(true);	
		this.dispose();
		
	}
	
	private void Landing()
	{
		Landing_Screen sc=new Landing_Screen();
		sc.setVisible(true);	
		this.dispose();
	}
}