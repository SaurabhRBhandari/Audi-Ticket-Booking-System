import AudiTicketBook.*;
import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Auditorium a=new Auditorium(5);
        Student s=new Student("noob5367","pass123","Saurabh","2412P");
        Event e=new Event("Java Not Good",LocalTime.now(),LocalTime.of(23,59,59),200 );
        s.book(e, Arrays.stream(a.getMatrix()).toList().subList(0,2));
        System.out.println(s.getBookings());
        System.out.println(s.getExpense());
        s.book(e, Arrays.stream(a.getMatrix()).toList().subList(0,2));
        System.out.println(s.getBookings());
        System.out.println(s.getExpense());
    }
}