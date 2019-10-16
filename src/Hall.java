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
    private Boolean[][] availability;
    private String address;
    private double hallArea;
    private int pricePerPerson;

    public Hall(String name, Owner owner, String description, int capacity, double discount, String address, double hallArea, int pricePerPerson){
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.capacity = capacity;
        this.discount = discount;
        this.address = address;
        this.hallArea = hallArea;
        this.pricePerPerson = pricePerPerson;
        this.reviews = new ArrayList<>();
        availability = new Boolean[12][3];

        for(int i = 0; i < 12; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if (j == 2)
                    availability[i][j] = false;
                else
                    availability[i][j] = true;
            }
        }
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getHallArea() {
        return hallArea;
    }

    public void setHallArea(double hallArea) {
        this.hallArea = hallArea;
    }

    public int getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(int pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }


    public Boolean[][] getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean[][] availability) {
        this.availability = availability;
    }

    public double getAverageRating(){
        double avgRating = 0.0;
        if(getReviews().size() == 0)
            ;
        else{
            for (Review review : getReviews()){
                avgRating += review.getRating();
            }
            avgRating /= (getReviews().size());
        }
        return avgRating;
    }
}
