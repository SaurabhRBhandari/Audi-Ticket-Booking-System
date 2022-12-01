package AudiTicketBook;
import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class Movie_Booking extends JFrame {

	private JPanel contentPane;
	private Student user;
	private List<Auditorium.Seat> st;
	private List<JCheckBox> checkbox;
	private Auditorium.Seat allseat[];
	private Event e;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		Student s=new Student("","","");
//		Event e=
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Movie_Booking frame = new Movie_Booking(data,s);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Movie_Booking(Event ev,Student s) {
		checkbox=new ArrayList<JCheckBox>();
		e=ev;
		user=s;
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
				User_Screen();
			}
		});
		btnNewButton.setBounds(10, 453, 107, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Movie Name:".concat(ev.getName()));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(23, 26, 426, 106);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Time:".concat(ev.getTime()));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(23, 88, 426, 106);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Date:".concat(ev.getDate()));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(23, 57, 426, 106);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Price:".concat(ev.getPrice()+""));
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(23, 118, 426, 106);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton_1 = new JButton("Book");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					book();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(504, 357, 107, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_3.setBounds(409, 427, 384, 63);
		contentPane.add(lblNewLabel_3);
		JCheckBox arr[]=new JCheckBox[25];
		st=Auditorium.getAvailableSeats(ev);
		allseat= Auditorium.getMatrix();
		for(int i=0;i<100;i++)
		{
		JCheckBox chckbxNewCheckBox = new JCheckBox((i/10+1)+"-"+(i%10+1));
		
		if (!st.contains(allseat[i]))
				{
						chckbxNewCheckBox.setEnabled(false);
				}
		chckbxNewCheckBox.setBounds(250+(i%10+1)*52, 10+(i/10+1)*30, 60, 25);
		
		checkbox.add(chckbxNewCheckBox);
		contentPane.add(chckbxNewCheckBox);
		}
		
		
		
		
		
		
		
		
	}
	
	private void book() throws InterruptedException
	{
		List<Auditorium.Seat> Selected=new ArrayList<Auditorium.Seat>();
		int c=0;
		for (int i=0;i<100;i++)
		{
			if(checkbox.get(i).isSelected())
			{
				c++;
				Selected.add(allseat[i]);
			}
		}
		if (c==0)
		{
			lblNewLabel_3.setText("Select a seat");
			return;
		}
		
		user.book(e, Selected);
		
			lblNewLabel_3.setText("Booking Done");
//		Thread.sleep(3000);
//				User_Screen sc=new User_Screen(user);
//		sc.setVisible(true);	
//		this.dispose();
		
		
	}
	
	private void User_Screen()
	{
		User_Screen sc2=new User_Screen(user);
		sc2.setVisible(true);
		this.dispose();
	}
}
