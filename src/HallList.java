import jdk.nashorn.internal.runtime.ParserException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HallList {

    public ArrayList<Hall> getHallList() {
        return hallList;
    }

    public void setHallList(ArrayList<Hall> hallList) {
        this.hallList = hallList;
    }

    private ArrayList<Hall> hallList;

    public HallList(){
        hallList = new ArrayList<>();
    }

    public boolean createHall(String name, Owner owner, String description, int capacity, double discount) throws ParseException {
        hallList.add(new Hall(name, owner, description, capacity, discount));
        return false;
    }

    public void getAllHalls(){
        for (Hall hall : hallList){
            System.out.println(hall.getName());
            System.out.println(hall.getOwner().getName());
            System.out.println(hall.getDescription());
            System.out.println(hall.getCapacity());
            System.out.println(hall.getDiscount());
            System.out.println("\t\t\t Morning\t Afternoon\t  Evening\t");
            for(Map.Entry<Date, Map<String, Boolean>> entry : hall.getAvailability().entrySet()) {
                String date = entry.getKey().getDate() + "/" + entry.getKey().getMonth() + "/" + entry.getKey().getYear();
                System.out.print(date);
                for (Map.Entry<String, Boolean> availabilityEntry : entry.getValue().entrySet() ){
                    if availabilityEntry.getValue()
                }


                // do what you have to do here
                // In your case, another loop.
            }


        }
    }
}
