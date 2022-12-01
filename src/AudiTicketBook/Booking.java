package AudiTicketBook;

import java.util.List;

public class Booking {
    private final String bookingID;
    private final Event e;
    private final List<Auditorium.Seat> seats;


    private boolean isCancelled;

    public Booking(Event e, List<Auditorium.Seat> seats) throws Exception {
        this.bookingID = null;
        if (!Auditorium.getEvents().contains(e)) throw new Exception("Event does not exist.");
        for (Auditorium.Seat i : seats) {
            if (i.getIsBooked(e)) throw new Exception("Reserved!");
        }
        this.e = e;
        this.seats = seats;
        for (Auditorium.Seat i : seats) {
            i.book(e);
        }
    }

    public boolean getStatus() {
        return Auditorium.getEvents().contains(e);
    }

    public void cancel() {
        isCancelled = false;
    }

    public Event getEvent() {
        return this.e;
    }

    public List<Auditorium.Seat> getSeats() {
        return seats;
    }
}
