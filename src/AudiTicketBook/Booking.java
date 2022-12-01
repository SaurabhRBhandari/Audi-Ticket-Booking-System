package AudiTicketBook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Booking implements Savable{
    private final Event e;
    private final List<Auditorium.Seat> seats;

    private static List<Booking> bookingList;

    private boolean isCancelled;

    public static void readFromMemory() throws IOException {
        bookingList=new ArrayList<>();
        FileReader reader = new FileReader("data/BookingDetail.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String arr[]=line.split("\\$");
            int event_id=Integer.parseInt(arr[0]);
            Event e=Event.getAllInstances().get(event_id);
            List<Auditorium.Seat> seats=new ArrayList<>();
            for(int i=1;i< arr.length;i++)
            {
                int seatid=Integer.parseInt(arr[i]);
                Auditorium.Seat s=Auditorium.getMatrix()[i];
                s.book(e);
                seats.add(s);
            }
            Booking b=new Booking(e,seats);
            bookingList.add(b);
        }
        reader.close();
    }

    public static void writeToMemory() throws IOException {
        FileWriter writer = new FileWriter("data/BookingDetail.txt",false);
        for(Booking b:bookingList)
        {
            writer.write(b.toString());
        }
        writer.close();
    }

    public static List<Booking> getAllInstances()
    {
        return bookingList;
    }
    public Booking(Event e, List<Auditorium.Seat> seats)  {
            this.e=e;
            this.seats=seats;
    }

    public static Booking book(Event e, List<Auditorium.Seat> seats)
    {
        Booking b=new Booking(e,seats);
        bookingList.add(b);
        return b;
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

    @Override
    public String toString() {
        String seatList="";
        for(Auditorium.Seat s:seats)
        {
            seatList+="$"+s.getId();
        }
        System.out.println(Event.getAllInstances());
        return Event.getAllInstances().indexOf(e)+seatList;

    }
}
