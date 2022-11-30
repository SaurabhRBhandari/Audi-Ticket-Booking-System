import AudiTicketBook.*;
import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Auditorium a=new Auditorium(5);
        Student s=new Student("noob5367","pass123","Saurabh","2412P");
        Admin an=new Admin("AUGSD","BaugsdK","Hello world");
        Event e=new Event("Java Not Good",LocalTime.of(22,59,59),LocalTime.of(23,59,59),200 );
        an.addEvent(e);
        s.book(e, Arrays.stream(a.getMatrix()).toList().subList(0,2));
        System.out.println(s.getBookings());
        System.out.println(s.getExpense());
        an.removeEvent(e);
        s.book(e, Arrays.stream(a.getMatrix()).toList().subList(0,2));
        System.out.println(s.getBookings());
        System.out.println(s.getExpense());
        System.out.println(e);
    }
}