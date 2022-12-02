package AudiTicketBook;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Add_Movie extends JFrame {

	private JPanel contentPane;
	private JTextField NewName;
	private JTextField NewDate;
	private JTextField NewTime;
	private JTextField NewPrice;
	private JLabel Eventadd;
	private JLabel Error;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Movie frame = new Add_Movie();
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
	public Add_Movie() {
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
				Admin();
			}
		});
		NewName = new JTextField();
		NewName.setBounds(323, 69, 260, 20);
		contentPane.add(NewName);
		NewName.setColumns(10);
		
		NewDate = new JTextField();
		NewDate.setColumns(10);
		NewDate.setBounds(323, 158, 260, 20);
		contentPane.add(NewDate);
		
		NewTime = new JTextField();
		NewTime.setColumns(10);
		NewTime.setBounds(323, 245, 260, 20);
		contentPane.add(NewTime);
		
		NewPrice = new JTextField();
		NewPrice.setColumns(10);
		NewPrice.setBounds(323, 322, 260, 20);
		contentPane.add(NewPrice);
		btnNewButton.setBounds(10, 456, 107, 23);
		contentPane.add(btnNewButton);
		JLabel lblEnterNewName = new JLabel("Enter Name");
		lblEnterNewName.setVerticalAlignment(SwingConstants.TOP);
		lblEnterNewName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterNewName.setBounds(205, 69, 426, 23);
		contentPane.add(lblEnterNewName);
		
		JLabel lblEnterNewDate = new JLabel("Enter Date");
		lblEnterNewDate.setVerticalAlignment(SwingConstants.TOP);
		lblEnterNewDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterNewDate.setBounds(205, 158, 426, 23);
		contentPane.add(lblEnterNewDate);
		
		JLabel lblEnterNewTime = new JLabel("Enter Time");
		lblEnterNewTime.setVerticalAlignment(SwingConstants.TOP);
		lblEnterNewTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterNewTime.setBounds(205, 245, 426, 23);
		contentPane.add(lblEnterNewTime);
		
		JLabel lblEnterNewPrice = new JLabel("Enter Price");
		lblEnterNewPrice.setVerticalAlignment(SwingConstants.TOP);
		lblEnterNewPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterNewPrice.setBounds(205, 322, 426, 23);
		contentPane.add(lblEnterNewPrice);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add_Details();
			}});
		btnNewButton_1.setBounds(382, 378, 107, 23);
		contentPane.add(btnNewButton_1);
		
		Eventadd = new JLabel("");
		Eventadd.setFont(new Font("Tahoma", Font.BOLD, 24));
		Eventadd.setBounds(365, 441, 328, 40);
		contentPane.add(Eventadd);
		
		Error = new JLabel("");
		Error.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Error.setHorizontalAlignment(SwingConstants.CENTER);
		Error.setBounds(251, 412, 358, 67);
		contentPane.add(Error);
	}
	private void Add_Details()
	{
String name,date,time,price;
		
		name=NewName.getText();
		date=NewDate.getText();
		time=NewTime.getText();
		price=NewPrice.getText(); 
		
		if (name.equals("") || date.equals("") || time.equals("") || price.equals(""))
		{
			Error.setText("Fields cannot be empty");
			return;
		}
		Admin.addEvent(name,date,time,Integer.parseInt(price));
		
		Eventadd.setText("Event Added");
	}
	private void Admin()
	{
		Admin_Screen sc=new Admin_Screen();
		sc.setVisible(true);
		this.dispose();
	}

}
