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
    private Seat matrix[];

    int n;
    private List<Event> events;
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

    public Seat[] getMatrix() {
        return matrix;
    }

    public List<Event> getEvents()
    {
        return events;
    }

    public void addEvent(User u,Event e) throws IllegalAccessException {
        if(!(u instanceof Admin))throw new IllegalAccessException(" You are not authorized to add new Event");
        events.add(e);
    }

    public void removeEvent(User u,Event e) throws IllegalAccessException {
        if(!(u instanceof Admin))throw new IllegalAccessException(" You are not authorized to add new Event");
        events.remove(e);
    }

    public int getRevenue(Event e)
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
