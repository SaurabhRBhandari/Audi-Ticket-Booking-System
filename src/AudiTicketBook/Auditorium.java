package AudiTicketBook;

import java.util.*;
public class Auditorium {
    public class Seat
    {
        Set<Event> is_booked;
        public Seat()
        {
            is_booked=new HashSet<>();
        }
        public boolean getIsBooked(Event e)
        {
            return is_booked.contains(e);
        }
        public void book(Event e)
        {
            is_booked.add(e);
        }
    }
    private static Seat matrix[];

    static int n;
    private static List<Event> events;
    public Auditorium(int n)
    {
        matrix=new Seat[n];
        this.n=n;
        for(int i=0;i<n;i++)
        {
            matrix[i]=new Seat();
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

    public static void addEvent(User u,Event e) throws RuntimeException {
        if(!(u instanceof Admin))throw new RuntimeException(" You are not authorized to add new Event");
        events.add(e);
    }

    public static void removeEvent(User u,Event e) throws RuntimeException {
        if(!(u instanceof Admin))throw new RuntimeException(" You are not authorized to remove an event");
        events.remove(e);
    }

    public static int getRevenue(Event e)
    {
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i].getIsBooked(e))
                {
                    ans+=e.getPrice();
                }
            }
        }
        return ans;
    }


}
