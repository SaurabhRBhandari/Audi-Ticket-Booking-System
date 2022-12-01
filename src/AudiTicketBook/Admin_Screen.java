package AudiTicketBook;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Admin_Screen extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<Event> ev;
	private JLabel Error;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Screen frame = new Admin_Screen();
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
	public Admin_Screen() {
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
				Landing_Screen();
			}
		});
		String[] Columns= {"Name","Date","Timing","Price","Revenue"};
		
        ev=Auditorium.getEvents();
		
		int n=ev.size();
		String[][] Rows=new String[n][5];
		for (int i=0;i<ev.size();i++)
		{
			Rows[i][0]=ev.get(i).getName();

			Rows[i][1]=ev.get(i).getDate();
			Rows[i][2]=ev.get(i).getTime();
			Rows[i][3]=ev.get(i).getPrice()+"";
			Rows[i][4]=Auditorium.getRevenue(ev.get(i))+"";
		}
		contentPane.setLayout(null);
	
		table = new JTable(Rows,Columns);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(21, 11, 853, 397);
		contentPane.add(scrollPane);
		btnNewButton.setBounds(10, 455, 107, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Events");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add();
			}
		});
		btnNewButton_1.setBounds(469, 455, 107, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Change Details");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeDetails();
			}
		});
		btnNewButton_2.setBounds(752, 455, 107, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remove Event");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				remove();
			}
		});
		btnNewButton_3.setBounds(265, 455, 107, 23);
		contentPane.add(btnNewButton_3);
		
		Error = new JLabel("");
		Error.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Error.setHorizontalAlignment(SwingConstants.CENTER);
		Error.setBounds(304, 408, 289, 47);
		contentPane.add(Error);
	}
	private void add()
	{
		Add_Movie sc=new Add_Movie();
	sc.setVisible(true);	
	this.dispose();
	
	}
	
	private void remove()
	{
		int row=table.getSelectedRow();
		
		if (row==-1)
		{
			Error.setText("Select an event");
			return;
		}
		Admin.removeEvent(ev.get(row));
		
		Admin_Screen sc=new Admin_Screen();
		sc.setVisible(true);
		this.dispose();
	}
	private void changeDetails()
	{
		int row=table.getSelectedRow();
		
		if (row==-1)
		{
			Error.setText("Select an event");
			return;
		}
		Change_Details Sc=new Change_Details(ev.get(row));
		Sc.setVisible(true);	
		this.dispose();
	}
	private void Landing_Screen()
	{
		Landing_Screen Screen2=new Landing_Screen();
		Screen2.setVisible(true);
		this.dispose();
	}
}
