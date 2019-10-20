
import javax.sound.midi.Soundbank;
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

    public boolean createHall(String name, Owner owner, String description, int capacity, double discount, String address, double hallArea, int pricePerPerson) {
        hallList.add(new Hall(name, owner, description, capacity, discount, address, hallArea, pricePerPerson));
        return false;
    }

    public Hall getHallDetails(int id){

        return hallList.get(id);
    }

    public void displayHallDetails(int id){

        Hall hall = hallList.get(id);

        System.out.println();
        System.out.println();

        System.out.println("Hall Name:\t\t\t" + hall.getName());
        System.out.println("Owner:\t\t\t\t" + hall.getOwner().getName());
        System.out.println("Description:\t\t" + hall.getDescription());
        System.out.println("Capacity:\t\t\t" + hall.getCapacity() + " people");
        System.out.println("Discount:\t\t\t" + hall.getDiscount() + "%");
        System.out.println("Hall Area:\t\t\t" + hall.getHallArea() + "sqft");
        System.out.println("Address:\t\t\t" + hall.getAddress());
        System.out.println("Price per person:\t$" + hall.getPricePerPerson() );
        if(hall.getAverageRating() != -1.0)
            System.out.println("Average Rating: \t\t" + hall.getAverageRating());
        System.out.println();
        System.out.println("Availability");
        System.out.println("Sno\tDate\t\t\t Morning\t Afternoon\t  Evening\t");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = format.parse("07/09/2019");
        }
        catch (ParseException e){
            System.out.println("Date parse ecxeption: " + e);
        }
        int sno = 1;
        for(Boolean[] array : hall.getAvailability())
        {
            System.out.print(sno++ + "\t" +format.format(date) + "\t\t");
            for(int i = 0; i < 3; i++)
            {
                if(array[i]){
                    System.out.print("Available\t");
                }
                else
                {
                    System.out.print(" Booked\t\t");
                }
            }
            System.out.println();
            date.setTime(date.getTime() + 86400000);
        }

        System.out.println();
        System.out.println("Reviews");
        for( Review review: hallList.get(id).getReviews()){
            System.out.println("\tUser: " + review.getCustomer().getName() + "\t\t\t\t\t Rating: "  + review.getRating());
            System.out.println("\t" + review.getDescription());
            System.out.println();
        }
    }

    public void getAllHalls(HallList hallList){
        int i = 1;
        for (Hall hall : hallList.getHallList()){
            System.out.println( ("(") + i++ + ")" + "\tHall Name:\t\t\t" + hall.getName());
            System.out.println("\tTotal Capacity: \t" + hall.getCapacity());
            System.out.println("\tPrice per Person: \t" + hall.getPricePerPerson());
            if(hall.getAverageRating() != -1.0)
                System.out.println("\tAverage Rating: \t" + getAverageRating(hall));
            System.out.println();
        }
    }

    public double getAverageRating(Hall hall){
        return hall.getAverageRating();
    }

}
