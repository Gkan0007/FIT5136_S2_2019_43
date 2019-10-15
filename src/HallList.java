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

    public boolean createHall(String name, Owner owner, String description, int capacity, double discount, String address, double hallArea, int pricePerPerson) throws ParseException {
        hallList.add(new Hall(name, owner, description, capacity, discount, address, hallArea, pricePerPerson));
        return false;
    }

    public void getHallDetails(int id){

        Hall hall = hallList.get(id);
        System.out.println();
        System.out.println();

        System.out.println(hall.getName());
        System.out.println(hall.getOwner().getName());
        System.out.println(hall.getDescription());
        System.out.println(hall.getCapacity());
        System.out.println(hall.getDiscount());
        System.out.println(hall.getHallArea());
        System.out.println(hall.getAddress());
        System.out.println(hall.getPricePerPerson());
        System.out.println("Date\t\t\t Morning\t Afternoon\t  Evening\t");
        for(int i = 1; i <= 12; i++)
        {
            String stringDate = new String();
            if (i <= 3 )
                System.out.print("0" + (i+6) + "/09/2019\t\t");
            else
                System.out.print((i+6) + "/09/2019\t\t");

            for(int j = 0; j < 3; j++)
            {
                if (hall.getAvailability()[i][j] == true)
                    System.out.print("Available\t");
                else
                    System.out.print("Unavailable\t");
            }
            System.out.println();
        }
    }

    public void getAllHalls(HallList hallList){
        int i = 1;
        for (Hall hall : hallList.getHallList()){
            System.out.println( ("(") + i++ + ")" + "\tHall Name:\t\t\t" + hall.getName());
            System.out.println("\tTotal Capacity: \t" + hall.getCapacity());
            System.out.println("\tPrice per Person: \t" + hall.getPricePerPerson());
            System.out.println("\tAverage Rating: \t" + getAverageRating(hall));
            System.out.println();
        }
    }

    public double getAverageRating(Hall hall){
        double avgRating = 0.0;
        if(hall.getReviews().size() == 0)
            ;
        else{
            for (Review review : hall.getReviews()){
                avgRating += review.getRating();
            }
            avgRating /= (hall.getReviews().size());
        }
        return avgRating;
    }
}
