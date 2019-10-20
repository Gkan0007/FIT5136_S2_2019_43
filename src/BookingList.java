import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class BookingList {

    private ArrayList<Booking> bookingList;

    /**
     * Constructor is a method to initialize the attribute
     */
    public BookingList()
    {
        bookingList = new ArrayList<>();
    }
    /**
     * A method that to get the bookingList object from the BookingList
     */
    public ArrayList<Booking> getBookingList() {
        return bookingList;
    }
    /**
     * A method that to set the bookingList object of the BookingList
     * @param bookingList an ArrayList<Booking> to set the bookingList
     */
    public void setBookingList(ArrayList<Booking> bookingList) {
        this.bookingList = bookingList;
    }
    /**
     * A method that to add a Booking to the BookingList
     * @param quotation an Quotation which contains attributes that the Booking need
     * @param paymentStatus a boolean to show the paymentStatus
     */
    public boolean addBooking(Quotation quotation, boolean paymentStatus){
        bookingList.add(new Booking(quotation, paymentStatus, quotation.getQuoteDate(), quotation.getQuoteTime(), bookingList.size()+1));
        return true;
    }
    /**
     * A method that to check if the Booking has the same quote id as a the input
     * @param quoteId an int which is a quoteId
     */
    public boolean isBookingExistsForQuote(int quoteId){
        boolean flag = false;
        for(Booking booking: bookingList){
            if(booking.getQuoteId() == quoteId){
                flag = true;
                break;
            }
        }
        return flag;
    }
    /**
     * A method that to get all completed Booking by the customer
     * @param userName an String which is the customer's name
     */
    public ArrayList<Booking> getAllCompletedBookingsByUser(String userName){
        Date today = new Date();
        ArrayList<Booking> completedBookings = new ArrayList<>();
        for(Booking booking: bookingList){
            if(booking.getCustomer().getUserName().equals(userName)){
                if (booking.isPaymentStatus() && booking.getBookingDate().before(today)){
                    completedBookings.add(booking);

                }
            }
        }
        return completedBookings;
    }
}
