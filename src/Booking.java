import java.util.Date;

public class Booking extends Quotation {

    private int bookingId;
    private boolean paymentStatus;
    private Date bookingDate;
    private String bookingTime;

    public Booking(int quoteId, int capacity, boolean quoteStatus, double quoteTotalPrice, Date quoteDate, String quoteTime, double discount, boolean cateringOptions, Hall hall, Customer customer, boolean paymentStatus, Date bookingDate, String bookingTime, int bookingId) {
        super(quoteId, capacity, quoteStatus, quoteTotalPrice, quoteDate, quoteTime, discount, cateringOptions, hall, customer);
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.paymentStatus = paymentStatus;
        this.bookingId = bookingId;
    }


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }
}
