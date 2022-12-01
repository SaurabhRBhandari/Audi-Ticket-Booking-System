package AudiTicketBook;

public class Admin extends User implements Runnable{
    Thread t;
    public Admin(String p, String n) {
        super(p, n);
        t = new Thread(this);
        t.start();
    }
    public void run(){}
    public static void addEvent(Event e) {
        Auditorium.addEvent(e);
    }

    public static void removeEvent(Event e) {
        Auditorium.removeEvent(e);
    }
    public static void changeDetails(Event ev,String name,String date,String time,int price)
    {
    	ev.setName(name);
		ev.setDate(date);
		ev.setSt(time);
		ev.setPrice(price);
    }

}
