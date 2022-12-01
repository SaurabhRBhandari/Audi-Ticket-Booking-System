package AudiTicketBook;

import java.time.LocalTime;

public class Event {
    private final String name;
    private final LocalTime st;
    private final LocalTime et;
    private final int price;

    public Event(String name, LocalTime st, LocalTime et, int price) {
        this.name = name;
        this.et = et;
        this.st = st;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Event " + name + " starts at " + st + " and ends at " + et;
    }

    public int getPrice() {
        return price;
    }


}
