

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
    private ArrayList<Boolean[]> availability;
    private String address;
    private double hallArea;
    private int pricePerPerson;
    /**
     * Constructor is a method to initialize the attribute
     */
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
        availability = new ArrayList<Boolean[]>();
        Boolean[] array;
        for(int i = 0; i < 12; i++)
        {
            array = new Boolean[]{true, true, true};
            availability.add(array);
        }

    }
    /**
     * A method that to get the name from the Hall
     */
    public String getName() {
        return name;
    }
    /**
     * A method that to set the name of the Hall
     * @param name a String to set name of the Hall
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * A method that to get the owner from the Hall
     */
    public Owner getOwner() {
        return owner;
    }
    /**
     * A method that to set the name of the Hall
     * @param owner a Owner to set the owner of the Hall
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    /**
     * A method that to get the description from the Hall
     */
    public String getDescription() {
        return description;
    }
    /**
     * A method that to set the description of the Hall
     * @param description a String to set the description of the Hall
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * A method that to get the capacity from the Hall
     */
    public int getCapacity() {
        return capacity;
    }
    /**
     * A method that to set the capacity of the Hall
     * @param capacity a int to set the capacity of the Hall
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    /**
     * A method that to get the discount from the Hall
     */
    public double getDiscount() {
        return discount;
    }
    /**
     * A method that to set the discount of the Hall
     * @param discount a double to set the discount of the Hall
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    /**
     * A method that to get the reviews from the Hall
     */
    public ArrayList<Review> getReviews() {
        return reviews;
    }
    /**
     * A method that to set the reviews of the Hall
     * @param reviews a ArrayList<Review> to set the reviews of the Hall
     */
    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
    /**
     * A method that to get the address from the Hall
     */
    public String getAddress() {
        return address;
    }
    /**
     * A method that to set the address of the Hall
     * @param address a String to set the address of the Hall
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * A method that to get the hallArea from the Hall
     */
    public double getHallArea() {
        return hallArea;
    }
    /**
     * A method that to set the hallArea of the Hall
     * @param hallArea a double to set the hallArea of the Hall
     */
    public void setHallArea(double hallArea) {
        this.hallArea = hallArea;
    }
    /**
     * A method that to get the pricePerPerson from the Hall
     */
    public int getPricePerPerson() {
        return pricePerPerson;
    }
    /**
     * A method that to set the pricePerPerson of the Hall
     * @param pricePerPerson a int to set the pricePerPerson of the Hall
     */
    public void setPricePerPerson(int pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    /**
     * A method that to get the availability from the Hall
     */
    public ArrayList<Boolean[]> getAvailability() {
        return availability;
    }
    /**
     * A method that to set the availability of the Hall
     * @param availability an ArrayList<Boolean[]> to set the availability of the Hall
     */
    public void setAvailability(ArrayList<Boolean[]> availability) {
        this.availability = availability;
    }
    /**
     * A method that to get the average rating from the Hall
     */
    public double getAverageRating(){
        double avgRating = 0.0;
        if(getReviews().size() == 0)
            avgRating = -1.0;
        else{
            for (Review review : getReviews()){
                avgRating += review.getRating();
            }
            avgRating /= (getReviews().size());
        }
        return avgRating;
    }

    /**
     * A method that to add a review to the reviews of the Hall
     * @param rating an int to set the rating in the review
     * @param description a String to set the description in the review
     * @param customer a Customer to set the customer in the review
     * @param bookingId an int to set the bookingId in the review
     */
    public boolean addReview(int rating, String description, Customer customer, int bookingId){
        for(Review review: reviews)
        {
            if(review.getBookingId() == bookingId) {
                return false;
            }
        }
        Review review = new Review(rating, description, customer, bookingId);
        reviews.add(review);
        return true;
    }
}
