import java.util.Date;

public class Booking extends Quotation {

    private int bookingId;
    private boolean paymentStatus;
    private Date bookingDate;
    private String bookingTime;
    /**
     * Constructor is a method to initialize the attribute
     */
    public Booking(Quotation quotation, boolean paymentStatus, Date bookingDate, String bookingTime, int bookingId) {
        super(quotation.getQuoteId(), quotation.getCapacity(), quotation.isQuoteStatus(), quotation.getQuoteTotalPrice(), quotation.getQuoteDate(), quotation.getQuoteTime(), quotation.getDiscount(), quotation.getCateringOptions(), quotation.getHall(), quotation.getCustomer());
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.paymentStatus = paymentStatus;
        this.bookingId = bookingId;
    }

    /**
     * A method that to get the bookingId from the booking
     */
    public int getBookingId() {
        return bookingId;
    }
    /**
     * A method that to set the bookingId of the booking
     * @param bookingId an int to set the bookingId
     */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
    /**
     * A method that check the paymentStatus of the booking
     */
    public boolean isPaymentStatus() {
        return paymentStatus;
    }
    /**
     * A method that to set the paymentStatus of the booking
     * @param paymentStatus an boolean to set the paymentStatus
     */
    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    /**
     * A method that to get the bookingDate from the booking
     */
    public Date getBookingDate() {
        return bookingDate;
    }
    /**
     * A method that to set the bookingDate of the booking
     * @param bookingDate a Date to set the bookingDate
     */
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
    /**
     * A method that to get the paymentStatus from the booking
     */
    public String getBookingTime() {
        return bookingTime;
    }
    /**
     * A method that to set the bookingTime of the booking
     * @param bookingTime a Date to set the bookingTime
     */
    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }
}
