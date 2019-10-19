import java.util.Date;

public class Booking extends Quotation {

    private int bookingId;
    private boolean paymentStatus;
    private Date bookingDate;
    private String bookingTime;

    public Booking(Quotation quotation, boolean paymentStatus, Date bookingDate, String bookingTime, int bookingId) {
        super(quotation.getQuoteId(), quotation.getCapacity(), quotation.isQuoteStatus(), quotation.getQuoteTotalPrice(), quotation.getQuoteDate(), quotation.getQuoteTime(), quotation.getDiscount(), quotation.getCateringOptions(), quotation.getHall(), quotation.getCustomer());
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
