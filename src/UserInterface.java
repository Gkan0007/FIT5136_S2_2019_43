import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserInterface {

    public UserInterface(){
        System.out.println("  **************************************************** ");
        System.out.println("** *                                                * **");
        System.out.println("** *                  Prime Events                  * **");
        System.out.println("** *                                                * **");
        System.out.println("  **************************************************** ");
        System.out.println(" Welcome to Prime Events, hope you enjoy the events! \n");
        System.out.println("- Please any key to navigate to Login/Register view ...\n");
    }

    public void displayMenu(Customer customer) {
        System.out.println("(1) View halls and request a quotation");
        System.out.println("(2) Write a review");
        System.out.println("(3) Manage bookings");
        System.out.println("(4) View quotations and create a booking");
        System.out.println("(5) Logout");
    }
    public void displayMenu(Owner owner) { }
    public void displayMenu(Admin admin) { }


    public void display(Hall hall) {
        System.out.println();
        System.out.println();

        System.out.println("Hall Name:\t\t\t" + hall.getName());
        System.out.println("Owner:\t\t\t\t" + hall.getOwner().getName());
        System.out.println("Description:\t\t\t" + hall.getDescription());
        System.out.println("Capacity:\t\t\t" + hall.getCapacity() + " people");
        System.out.println("Discount:\t\t\t" + hall.getDiscount() + "%");
        System.out.println("Hall Area:\t\t\t" + hall.getHallArea() + "sqft");
        System.out.println("Address:\t\t\t" + hall.getAddress());
        System.out.println("Price per person:\t\t$" + hall.getPricePerPerson() );
        if(hall.getAverageRating() != -1.0)
            System.out.println("Average Rating: \t\t" + hall.getAverageRating());
        System.out.println();
        System.out.println("Availability");
        System.out.println("Sno\tDate\t\t\t Morning\t Afternoon\t  Evening\t");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = format.parse("07/09/2019");
        }
        catch (ParseException e){
            System.out.println("Date parse ecxeption: " + e);
        }
        int sno = 1;
        for(Boolean[] array : hall.getAvailability())
        {
            System.out.print(sno++ + "\t" +format.format(date) + "\t\t");
            for(int i = 0; i < 3; i++)
            {
                if(array[i]){
                    System.out.print("Available\t");
                }
                else
                {
                    System.out.print(" Booked\t\t");
                }
            }
            System.out.println();
            date.setTime(date.getTime() + 86400000);
        }

        System.out.println();
        System.out.println("Reviews");
        for( Review review: hall.getReviews()){
            System.out.println("\tUser: " + review.getCustomer().getName() + "\t\t\t\t\t Rating: "  + review.getRating());
            System.out.println("\t" + review.getDescription());
            System.out.println();
        }
    }


    public void displayAllHalls(ArrayList<Hall> hallList) {
        int i = 1;
        for (Hall hall : hallList){
            System.out.println( ("(") + i++ + ")" + "\tHall Name:\t" + hall.getName());
            System.out.println("\tTotal Capacity: \t" + hall.getCapacity());
            System.out.println("\tPrice per Person: \t" + hall.getPricePerPerson());
            if(hall.getAverageRating() != -1.0)
                System.out.println("\tAverage Rating: \t" + hall.getAverageRating());
            System.out.println();
        }
    }
    public void display(Quotation quotation) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println();
        System.out.println("Quotation Date:\t\t\t\t" + dateFormat.format(quotation.getQuoteDate()));
        System.out.println("Quotation Time:\t\t\t\t" + quotation.getQuoteTime());
        System.out.println("Number of people:\t\t\t" + quotation.getCapacity());

        System.out.println("Quotation Total Price:\t\t\t" + quotation.getQuoteTotalPrice());
        System.out.println("Discount:\t\t\t\t" + quotation.getDiscount() + "%");
        if (quotation.isQuoteStatus()){
            System.out.println("Catering Options:\t\t\t" + "Yes");
        }else {
            System.out.println("Catering Options:\t\t\t" + "No");
        }
        System.out.println("Hall Name:\t\t\t\t" + quotation.getHall().getName());
        if (quotation.isQuoteStatus()){
            System.out.println("Quotation Status:\t\t\t" + "Accepted");
        }else {
            System.out.println("Quotation Status:t\t\t\t" + "Pending");
        }
    }

    public void displayAllQuotations(ArrayList<Quotation> quotationList) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int i = 1;
        for (Quotation quotation : quotationList){
            System.out.println("(" + i++ + ")" +"\tHall Name:\t\t" + quotation.getHall().getName());
            System.out.println("\tQuotation Date:\t\t" + dateFormat.format(quotation.getQuoteDate()));
            System.out.println("\tQuotation Time:\t\t" + quotation.getQuoteTime());
            if (quotation.isQuoteStatus()){
                System.out.println("\tQuotation Status:\t" + "Accepted");
            }else {
                System.out.println("\tQuotation Status:\t" + "Pending");
            }
            System.out.println();
        }
    }
    public void display(Booking booking) {}

    public void displayAllBookings(ArrayList<Booking> bookingList) {
        int sno = 1;
        Date today = new Date();
        for(Booking booking: bookingList){
                if (booking.isPaymentStatus() && booking.getBookingDate().before(today)){
                    System.out.println("(" + sno++ + ")" +"\tHall name:\t\t" +booking.getHall().getName());
                    System.out.println("\tBooking date:\t\t" +booking.getBookingDate());
                    System.out.println("\tBooking time:\t\t" +booking.getBookingTime());
                }
        }
    }
    public void displayMenu(Hall hall) {}
    public void displayMenu(Quotation quotation){}
    public void displayMenu(Booking booking){}
    public void displayReviews(Hall review){}
    public boolean askForConformation() { return true;}
    public void promptInputMessage(String message) {
        System.out.println(message);
    }
    public void displayMessage(String message){
        System.out.println(message);
    }
    public boolean  displayExitScreen() {return true;}
    public void displayError(String error) {}



}
