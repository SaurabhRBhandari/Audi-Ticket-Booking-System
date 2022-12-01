package AudiTicketBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Student extends User implements Savable {
    private final String name;

    private List<Booking> bookings;

    private static List<Student> studentList;

    public static void readFromMemory() throws IOException {
        studentList=new ArrayList<>();
        FileReader reader = new FileReader("data/StudentDetail.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String arr[]=line.split("\\$");
            String name=arr[0];
            String userId=arr[1];
            String password=arr[2];
            List<Auditorium.Seat> seats=new ArrayList<>();
            Student s=new Student(name,password,userId);
            for(int i=3;i< arr.length;i++)
            {
                int bookingid=Integer.parseInt(arr[i]);
                Booking b=Booking.getAllInstances().get(bookingid);
                s.bookings.add(b);
            }
            studentList.add(s);
        }
        reader.close();
    }

    public static void writeToMemory() throws IOException {
        FileWriter writer = new FileWriter("data/StudentDetail.txt",false);
        for(Student s:studentList)
        {
            writer.write(s.toString());
        }
        writer.close();
    }
    public Student(String name, String password, String collegeID) {
        super(collegeID, password);
        this.name = name;
        this.bookings = new ArrayList<>();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void book(Event E, List<Auditorium.Seat> seats) {
        try {
            bookings.add(Booking.book(E,seats));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getExpense() {
        int ans = 0;
        for (Booking b : bookings) {
            if (b.getStatus()) ans += b.getEvent().getPrice() * (b.getSeats().size());
        }
        return ans;
    }

    public static Student newInstance(String n,String p,String id) {
        return new Student(n,p,id);
    }

    public static Student login(String u,String p) throws IOException {
    		for(Student s: studentList)
            {
                if(s.userid.equals(u) && s.password.equals(p))
                {
                    return s;
                }
            }
            throw new RuntimeException("Wrong username/password");
    }

    public static Student register(String name,String id,String pass) throws IOException {
        Student s=new Student(name,pass,id);
        for(Student s1: studentList)
        {
            if(s1.userid.equals(id) )
            {
                throw new RuntimeException("User Exists");
            }
        }
        studentList.add(s);
        return s;
    }

    @Override
    public String toString() {
        String bookingList="";
        for(Booking b:bookings)
        {
            bookingList+="$"+Booking.getAllInstances().indexOf(b);
        }
        return name+"$"+userid+"$"+password+bookingList;
    }
}
