public class Review  {
    private int rating;
    private String description;
    private Customer customer;
    private int bookingId;
    /**
     * Constructor is a method to initialize the attribute
     */
    public Review(int rating, String description, Customer customer, int bookingId) {
        this.rating = rating;
        this.description = description;
        this.customer = customer;
        this.bookingId = bookingId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
