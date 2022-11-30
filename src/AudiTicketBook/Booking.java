package AudiTicketBook;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String bookingID;
    private Event e;
    private List<Auditorium.Seat> seats;


    private boolean isCancelled;

    public Booking(Event e, List<Auditorium.Seat> seats) throws Exception {
        this.bookingID=null;
        for(Auditorium.Seat i:seats)
        {
            if(i.getIsBooked(e))throw new Exception("Reserved!");
        }
        this.e=e;
        this.seats=seats;
        for(Auditorium.Seat i:seats)
        {
            i.book(e);
        }
    }

    public boolean getStatus()
    {
        return !isCancelled;
    }

    public void cancel()
    {
        isCancelled=false;
    }

    public Event getEvent()
    {
        return this.e;
    }

    public List<Auditorium.Seat> getSeats()
    {
        return seats;
    }
}
