import AudiTicketBook.*;
import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Auditorium a=new Auditorium(50);
        Student s=new Student("noob5367","pass123","Saurabh","2412P");
        Student k=new Student("noob367","pass23","Sarabh","2422P");
        Admin an=new Admin("AUGSD","BaugsdK","Hello world");
        Event e=new Event("Java Not Good",LocalTime.of(22,59,59),LocalTime.of(23,59,59),200 );
        an.addEvent(e);
        System.out.println("S tries to book seats 1,2");
        s.book(e, Arrays.stream(a.getMatrix()).toList().subList(0,2));
        System.out.println("S's bookings:");
        System.out.println(s.getBookings());
        System.out.println("S's expense");
        System.out.println(s.getExpense());
        System.out.println();
        //an.removeEvent(e);
        System.out.println("S tries to book seats 1,2 again");
        s.book(e, Arrays.stream(a.getMatrix()).toList().subList(0,2));
        System.out.println("S's bookings:");
        System.out.println(s.getBookings());
        System.out.println("S's expense");
        System.out.println(s.getExpense());
        System.out.println();
        //System.out.println(e);
        System.out.println("S tries to book seats 3,4");
        s.book(e, Arrays.stream(a.getMatrix()).toList().subList(2,4));
        System.out.println("S's bookings:");
        System.out.println(s.getBookings());
        System.out.println("S's expense");
        System.out.println(s.getExpense());
        System.out.println();
        System.out.println();
        System.out.println("K tries to book seats 1,2 again");
        k.book(e, Arrays.stream(a.getMatrix()).toList().subList(0,2));
        System.out.println("K's bookings:");
        System.out.println(k.getBookings());
        System.out.println("K's expense");
        System.out.println(k.getExpense());
        System.out.println();
        System.out.println("K tries to book seats 5,6");
        k.book(e, Arrays.stream(a.getMatrix()).toList().subList(4,6));
        System.out.println("K's bookings:");
        System.out.println(k.getBookings());
        System.out.println("K's expense");
        System.out.println(k.getExpense());
        System.out.println();
        System.out.println();
        System.out.println(e);
        System.out.println("Event E removed");
        an.removeEvent(e);
    }
}
