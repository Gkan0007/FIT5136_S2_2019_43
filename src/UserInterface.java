public class UserInterface {
    public void displayMenu(Customer customer) {
        System.out.println("(1) View halls and request a quotation");
        System.out.println("(2) Write a review");
        System.out.println("(3) Manage bookings");
        System.out.println("(4) View quotations");
        System.out.println("(5) Logout");
    }
    public void displayMenu(Owner owner) { }
    public void displayMenu(Admin admin) { }
    public void display(Hall hall) {}
    public void display(Hall[] hallList) {}
    public void display(Quotation quotation) {}
    public void display(Quotation[] quotationList) {}
    public void display(Booking booking) {}
    public void display(Booking[] bookingList) {}
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
