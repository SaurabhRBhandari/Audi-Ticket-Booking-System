package AudiTicketBook;

import java.util.*;
public class Auditorium{
    public class Seat
    {
        Set<Event> is_booked;
        private int id;
        public Seat(int i)
        {
        	id=i;
            is_booked=new HashSet<>();
        }
        public boolean getIsBooked(Event e)
        {
            return is_booked.contains(e);
        }
        public int getId()
        {
        	return id;
        }
        public void book(Event e)
        {
            is_booked.add(e);
        }
    }
    private static Seat matrix[];

    private static final int N=100;
    private static List<Event> events;


    public Auditorium()
    {
        matrix=new Seat[N];

        for(int i=0;i<N;i++)
        {
            matrix[i]=new Seat(i);
        }
        events=new ArrayList<>();

    }

    public static Seat[] getMatrix() {
        return matrix;
    }

    public static List<Event> getEvents()
    {
        return events;
    }

    public static void addEvent(Event e){
        events.add(e);
    }

    public static void removeEvent(Event e) {
        events.remove(e);
        e.cancel();
    }

    public static int getRevenue(Event e)
    {
        int ans=0;
        for(int i=0;i<N;i++)
        {
                if(matrix[i].getIsBooked(e))
                {
                    ans+=e.getPrice();
                }
        }
        return ans;
    }

    public static List<Seat> getAvailableSeats(Event e)
    {
        List<Seat> ans=new ArrayList<>();
        for(Seat s: matrix)
        {
            if(!s.getIsBooked(e))ans.add(s);
        }
        return ans;
    }


}
