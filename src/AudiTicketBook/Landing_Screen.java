package AudiTicketBook;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Landing_Screen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {

		Auditorium obj=new Auditorium();
		Event.readFromMemory();
		Booking.readFromMemory();
		Student.readFromMemory();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Landing_Screen frame = new Landing_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				try {
					Student.writeToMemory();
					Booking.writeToMemory();
					Event.writeToMemory();
					System.out.println("Data Saved Successfully");
				} catch (Exception e) {
					System.out.println("Could not save data");
				}

			}
		}, "Shutdown-thread"));
	}

	/**
	 * Create the frame.
	 */
	public Landing_Screen() {
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(27, 153, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Log_Screen(e);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(173, 350, 107, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Admin");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Admin_Screen(e);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(383, 428, 107, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("AUDI BOOKING SYSTEM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(294, 69, 484, 151);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Register");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register();
			}
		});
		btnNewButton_2.setBounds(584, 350, 107, 23);
		contentPane.add(btnNewButton_2);
	}
	
	private void Log_Screen(MouseEvent E)
	{
		Log_in screen2=new Log_in();	
		screen2.setVisible(true);
		this.dispose();
	}
	private void Register()
	{
		Register_Screen sc=new Register_Screen();
		sc.setVisible(true);
		this.dispose();
	}
	private void Admin_Screen(MouseEvent E)
	{
		Admin_Screen screen2=new Admin_Screen();	
		screen2.setVisible(true);
		this.dispose();
	}
}
