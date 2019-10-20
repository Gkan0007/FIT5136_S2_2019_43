import java.util.Date;

public class Quotation {

    private int quoteId;
    private int capacity;
    private boolean quoteStatus;
    private double quoteTotalPrice;
    private Date quoteDate;
    private String quoteTime;
    private double discount;
    private boolean cateringOptions;
    private Hall hall;
    private Customer customer;
    /**
     * Constructor is a method to initialize the attribute
     */
    public Quotation(int quoteId, int capacity, boolean quoteStatus, double quoteTotalPrice, Date quoteDate, String quoteTime, double discount, boolean cateringOptions, Hall hall, Customer customer) {
        this.quoteId = quoteId;
        this.capacity = capacity;
        this.quoteStatus = quoteStatus;
        this.quoteTotalPrice = quoteTotalPrice;
        this.quoteDate = quoteDate;
        this.quoteTime = quoteTime;
        this.discount = discount;
        this.cateringOptions = cateringOptions;
        this.hall = hall;
        this.customer = customer;
    }

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isQuoteStatus() {
        return quoteStatus;
    }

    public void setQuoteStatus(boolean quoteStatus) {
        this.quoteStatus = quoteStatus;
    }

    public double getQuoteTotalPrice() {
        return quoteTotalPrice;
    }

    public void setQuoteTotalPrice(double quoteTotalPrice) {
        this.quoteTotalPrice = quoteTotalPrice;
    }

    public Date getQuoteDate() {
        return quoteDate;
    }

    public void setQuoteDate(Date quoteDate) {
        this.quoteDate = quoteDate;
    }

    public String getQuoteTime() {
        return quoteTime;
    }

    public void setQuoteTime(String quoteTime) {
        this.quoteTime = quoteTime;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean getCateringOptions() {
        return cateringOptions;
    }

    public void setCateringOptions(boolean cateringOptions) {
        this.cateringOptions = cateringOptions;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
