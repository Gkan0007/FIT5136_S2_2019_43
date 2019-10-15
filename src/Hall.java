import com.sun.org.apache.xpath.internal.operations.Bool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Hall {

    private String name;
    private Owner owner;
    private String description;
    private int capacity;
    private double discount;
    private ArrayList<Review> reviews;
    private Map<Date, Map<String, Boolean>> availability;

    public Hall(String name, Owner owner, String description, int capacity, double discount) throws ParseException {
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.capacity = capacity;
        this.discount = discount;
        this.reviews = new ArrayList<>();
        Map<Date, Map<String, Boolean>> tempAvailability = new HashMap<Date, Map<String, Boolean>>();
        for (int i = 0; i < 14; i++)
        {
            String stringDate = (i+14)+ "/09/2019";
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
            Map<String, Boolean> valueAvilaibility = new HashMap<String, Boolean>();
            valueAvilaibility.put("Morning", true);
            valueAvilaibility.put("Afternoon", true);
            valueAvilaibility.put("Evening", true);
            tempAvailability.put(date,valueAvilaibility);
        }

        this.availability = tempAvailability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Date, Map<String, Boolean>> getAvailability() {
        return availability;
    }

    public void setAvailability(Map<Date, Map<String, Boolean>> availability) {
        this.availability = availability;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
}
