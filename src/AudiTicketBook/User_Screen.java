package AudiTicketBook;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class User_Screen extends JFrame {

    private final JPanel contentPane;
    private final JTable table;
    private final Student user;
    private final List<Event> ev;
    private final JLabel Error;

    /**
     * Create the frame.
     */
    public User_Screen(Student s) {
        user = s;
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 540);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(27, 153, 139));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JButton Back = new JButton("Back");
        Back.setBounds(10, 467, 107, 23);
        Back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Landing_Screen();
            }
        });
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        String[] Columns = {"Name", "Date", "Timing", "Price"};
        List<Event> evs = Event.getAllInstances();
        ev = new ArrayList<>();
        for (Event e : evs) if (e.getStatus()) ev.add(e);

        int n = ev.size();
        String[][] Rows = new String[n][4];
        for (int i = 0; i < ev.size(); i++) {
            if (!ev.get(i).getStatus()) continue;
            Rows[i][0] = ev.get(i).getName();

            Rows[i][1] = ev.get(i).getDate();
            Rows[i][2] = ev.get(i).getTime();
            Rows[i][3] = ev.get(i).getPrice() + "";
        }

        contentPane.setLayout(null);
        contentPane.add(Back);
        table = new JTable(Rows, Columns);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(21, 11, 853, 402);
        contentPane.add(scrollPane);

        JButton Next = new JButton("Next");
        Next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Next();

            }
        });
        Next.setBounds(767, 467, 107, 23);
        contentPane.add(Next);

        JButton btnNewButton = new JButton("See Previous bookings");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                prevBooking();
            }
        });
        btnNewButton.setBounds(353, 467, 181, 23);
        contentPane.add(btnNewButton);

        Error = new JLabel("");
        Error.setHorizontalAlignment(SwingConstants.CENTER);
        Error.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Error.setBounds(327, 412, 238, 52);
        contentPane.add(Error);


        contentPane.setVisible(true);

    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        Student s = new Student("", "", "");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    User_Screen frame = new User_Screen(s);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void Next() {
        int row = table.getSelectedRow();
        if (row == -1) {
            Error.setText("Select an Event");
            return;
        }

        Movie_Booking Sc = new Movie_Booking(ev.get(row), user);
        Sc.setVisible(true);
        this.dispose();
    }

    private void prevBooking() {
        Previous_Bookings sc = new Previous_Bookings(user);
        sc.setVisible(true);
        this.dispose();
    }

    private void Landing_Screen() {
        Landing_Screen Screen2 = new Landing_Screen();
        Screen2.setVisible(true);
        this.dispose();
    }
}
