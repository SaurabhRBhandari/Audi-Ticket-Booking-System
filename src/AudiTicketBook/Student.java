package AudiTicketBook;

import java.util.ArrayList;
import java.util.List;

public class Student extends User implements Runnable{
    Thread t;
    private final String collegeID;
    private final List<Booking> bookings;

    public Student(String name, String password, String collegeID) {
        super(password, name);
        this.collegeID = collegeID;
        this.bookings = new ArrayList<>();
        t = new Thread(this);
        t.start();
    }
    public void run(){}
    public List<Booking> getBookings() {
        return bookings;
    }

    synchronized public void book(Event E, List<Auditorium.Seat> seats) {
        try {
            bookings.add(new Booking(E, seats));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getExpense() {
        int ans = 0;
        for (Booking b : bookings) {
            if (b.getStatus()) ans += b.getEvent().getPrice() * (b.getSeats().size());
        }
        return ans;
    }

    public static Student newInstance(String n,String p,String id) {
        return new Student(n,p,id);
    }


}
