import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Hall {

    private String name;
    private Owner owner;
    private String description;
    private int capacity;
    private double discount;
    private ArrayList<Review> reviews;
    private Map<Date, String> availability;

    public Hall(String name, Owner owner, String description, Map<Date, String> availability, int capacity, double discount, ArrayList<Review> reviews) {
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.availability = availability;
        this.capacity = capacity;
        this.discount = discount;
        this.reviews = reviews;
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

    public Map<Date, String>  getAvailability() {
        return availability;
    }

    public void setAvailability(Map<Date, String> availability) {
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
