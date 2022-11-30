package AudiTicketBook;

import java.util.*;

public class Student extends User implements Runnable{
    Thread t.
    private final String collegeID;
    private List<Booking> bookings;

    public Student(String userID, String password, String name,String collegeID)
    {
        super(userID,password,name);
        this.collegeID=collegeID;
        this.bookings=new ArrayList<>();
        t = new Thread(this);
        t.start();
    }

    public List<Booking> getBookings()
    {
        return bookings;
    }
    public void run(){};
    public void book(Event E,List<Auditorium.Seat> seats)
    {
        try
        {
            bookings.add(new Booking(E, seats));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public int getExpense()
    {
        int ans=0;
        for(Booking b: bookings)
        {
            if(b.getStatus())ans+=b.getEvent().getPrice()*(b.getSeats().size());
        }
        return ans;
    }

}
