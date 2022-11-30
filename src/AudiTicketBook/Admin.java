package AudiTicketBook;

public class Admin extends User implements Runnable{
    Thread t;

    public Admin(String s,String p,String n)
    {
        super(s,p,n);
        t = new Thread(this);
        t.start();
    }
    public void run(){}
    public void addEvent(Event e)
    {
        Auditorium.addEvent(this,e);
    }

    public void removeEvent(Event e)
    {
        Auditorium.removeEvent(this,e);
    }

}
