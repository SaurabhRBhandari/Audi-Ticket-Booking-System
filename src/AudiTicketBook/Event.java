package AudiTicketBook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Event implements Savable {
    private String name;
    private String time;
    private String date;
    private int price;

    private boolean is_cancelled;

    private static List<Event> eventList;

    public Event(String name, String time,String date, int price) {
        this.name = name;
        this.time=time;
        this.date = date;
        this.price = price;
        this.is_cancelled=false;
    }

    public boolean getStatus()
    {
        return is_cancelled;
    }
    public static List<Event> getAllInstances()
    {
        return eventList;
    }

    public static void readFromMemory() throws IOException
    {
        eventList=new ArrayList<>();
        FileReader reader = new FileReader("data/EventDetail.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String arr[]=line.split("\\$");
            String name=arr[0];
            String time=arr[1];
            String date=arr[2];
            int price=Integer.parseInt(arr[3]);
            boolean is_cancelled=arr[4].equals("1");
            Event e=new Event(name,time,date,price);
            if(is_cancelled)e.cancel();
            else {
                System.out.println("here");
                Auditorium.addEvent(e);
            }
            eventList.add(new Event(name,time,date,price));
        }
        reader.close();
    }
    public void cancel()
    {
        is_cancelled=true;
    }
    public static void writeToMemory() throws IOException
    {
        FileWriter writer = new FileWriter("data/EventDetail.txt",false);
        for(Event e:eventList)
            writer.write(e.toString());
        writer.close();
    }

    public static Event newInstance(String name, String time,String date, int price)
    {
        Event e=new Event(name,time,date,price);
        eventList.add(e);
        return e;
    }
    @Override
    public String toString() {
        String tmp=is_cancelled?"1":"0";
        System.out.println(tmp);
        return this.name+"$"+this.time+"$"+this.date+"$"+this.price+"$"+tmp;
    }

    public int getPrice() {
        return price;
    }
    public String getName()
    {
    	return name;
    }
    public String getTime()
    {
    	return time;
    }
    public String getDate()
    {
    	return date;
    }
    
    public void setPrice(int price) {
        this.price=price;
    }
    public void setName(String name)
    {
    	this.name= name;
    }
    public void setSt(String St)
    {
    	this.time= St;
    }
    public void setDate(String Et)
    {
    	this.date=Et;
    }

    // setPrice()
}
