package AudiTicketBook;

public class Admin extends User{

    public Admin(String s,String p,String n)
    {
        super(s,p,n);
    }

    public void addEvent(Event e)
    {
        Auditorium.addEvent(this,e);
    }

    public void removeEvent(Event e)
    {
        Auditorium.removeEvent(this,e);
    }

}
