package AudiTicketBook;

public class Admin extends User {

    public Admin(String p, String n) {
        super(p, n);
    }

    public void addEvent(Event e) {
        Auditorium.addEvent(this, e);
    }

    public void removeEvent(Event e) {
        Auditorium.removeEvent(this, e);
    }


}
