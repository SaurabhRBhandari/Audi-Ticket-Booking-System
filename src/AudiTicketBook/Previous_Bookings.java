package AudiTicketBook;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Previous_Bookings extends JFrame {

    private final JPanel contentPane;
    private final Student user;
    private final JTable table;
    private final List<Booking> bookings;
    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Previous_Bookings frame = new Previous_Bookings();
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
    public Previous_Bookings(Student s) {
        user = s;
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
                Back();
            }
        });
        bookings = user.getBookings();

        btnNewButton.setBounds(10, 456, 107, 23);
        contentPane.add(btnNewButton);
        String[][] Rows = new String[bookings.size()][5];

        String[] Columns = {"Name", "Date", "Time", "Seats", "Price"};

        for (int i = 0; i < bookings.size(); i++) {
            Rows[i][0] = bookings.get(i).getEvent().getName();

            Rows[i][1] = bookings.get(i).getEvent().getDate();

            Rows[i][2] = bookings.get(i).getEvent().getTime();
            List<Auditorium.Seat> st = bookings.get(i).getSeats();
            String seats = "";
            for (int j = 0; j < st.size(); j++) {
                int id = st.get(j).getId();
                seats = seats + "," + (id / 10 + 1) + "-" + (id % 10 + 1);
            }
            Rows[i][3] = seats;
            if (bookings.get(i).getStatus())
                Rows[i][4] = "" + bookings.get(i).getEvent().getPrice() * st.size();
            else
                Rows[i][4] = "Cancelled";
        }
        table = new JTable(Rows, Columns);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(21, 11, 853, 427);
        contentPane.add(scrollPane);
    }

    private void Back() {
        User_Screen sc = new User_Screen(user);
        sc.setVisible(true);
        this.dispose();
    }
}
