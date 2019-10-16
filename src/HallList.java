
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
        System.out.println("Availability");
        System.out.println("Date\t\t\t Morning\t Afternoon\t  Evening\t");
        for(int i = 0; i < 12; i++)
        {
            String stringDate = new String();
            if (i < 3 )
                System.out.print("0" + (i+7) + "/09/2019\t");
            else
                System.out.print((i+7) + "/09/2019\t");

            for(int j = 0; j < 3; j++)
            {
                if (hall.getAvailability()[i][j] == true)
                    System.out.print("\tAvailable");
                else
                    System.out.print("\t Booked\t");
            }
            System.out.println();
        }
        return hall;
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
        return hall.getAverageRating();
    }
}
