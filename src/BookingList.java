import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class BookingList {

    private ArrayList<Booking> bookingList;


    public BookingList()
    {
        bookingList = new ArrayList<>();
    }

    public ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(ArrayList<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public boolean addBooking(Quotation quotation, boolean paymentStatus){
        bookingList.add(new Booking(quotation, paymentStatus, quotation.getQuoteDate(), quotation.getQuoteTime(), bookingList.size()+1));
        return true;
    }

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
