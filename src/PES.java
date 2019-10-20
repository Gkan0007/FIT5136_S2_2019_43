import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PES {


    private String loggedInUser;
    private CustomerList listOfCustomers;
    private OwnerList listOfOwners;
    private QuotationList listOfQuotations;
    private Admin admin;
    private HallList listOfHalls;
    private BookingList listOfBookings;
    private UserInterface userInterface;


    PES()
    {
        loggedInUser = " ";
        listOfCustomers = new CustomerList();
        listOfOwners = new OwnerList();
        admin = new Admin();
        listOfHalls = new HallList();
        listOfQuotations = new QuotationList();
        listOfBookings = new BookingList();
        userInterface = new UserInterface();
        init();
    }

    public void init(){
        listOfOwners.addOwner("owner1", "password", "Owner", true, 1);
        listOfCustomers.addCustomer(new Customer("cust1", "password", "Customer 1", true, false, false, 1));
        listOfCustomers.addCustomer(new Customer("cust2", "password", "Customer 2", true, true, false, 1));
        listOfCustomers.addCustomer(new Customer("cust3", "password", "Customer 3", true, true, false, 1));
        listOfCustomers.addCustomer(new Customer("cust4", "password", "Customer 4", true, true, false, 1));

        listOfHalls.createHall("Hall1", listOfOwners.getOwner("user1"), "abcd", 500, 15, "address", 3000.0, 40);
        listOfHalls.createHall("Hall2", listOfOwners.getOwner("user1"), "abcd", 700, 20, "address", 3000.0, 50);
        listOfQuotations.createQuotation(1,100,true,2000.0,parseDate("10/09/2019"),"Evening",15.0,true,listOfHalls.getHallDetails(1),listOfCustomers.getCustomer("cust2"));
        listOfQuotations.createQuotation(2,200,true,4000.0,parseDate("14/09/2019"),"Morning",20.0,false,listOfHalls.getHallDetails(1),listOfCustomers.getCustomer("cust3"));
        listOfQuotations.createQuotation(3,300,true,26000.0,parseDate("18/09/2019"),"Afternoon",15.0,true,listOfHalls.getHallDetails(1),listOfCustomers.getCustomer("cust4"));

        listOfBookings.addBooking(listOfQuotations.getQuotationDetails(0), true);
        listOfBookings.addBooking(listOfQuotations.getQuotationDetails(1), true);
        listOfBookings.addBooking(listOfQuotations.getQuotationDetails(2), true);
        listOfBookings.getBookingList().get(0).getHall().addReview(5, "Excellent", listOfCustomers.getCustomerByUserName("cust2"), 1);
        listOfBookings.getBookingList().get(1).getHall().addReview(4, "One of the best", listOfCustomers.getCustomerByUserName("cust3"), 2);
        listOfBookings.getBookingList().get(2).getHall().addReview(3, "Good service", listOfCustomers.getCustomerByUserName("cust4"), 3);

        ArrayList<Boolean[]> availability = listOfHalls.getHallDetails(1).getAvailability();
        availability.get(4)[1] = false;
        availability.get(11)[0] = false;
        availability.get(8)[2] = false;
        listOfHalls.getHallDetails(1).setAvailability(availability);


    }

    public  void welcome() {
        Scanner scanner = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        s.nextLine();
        System.out.println("1.Login");
        System.out.println("2.Register");
        String input = scanner.next();
        if(isValidInteger(input)) {
            int choice = Integer.parseInt(input);
            if (choice == 1) {
                login();
            }
            else if (choice == 2) {
                register();
            }
            else {
                userInterface.displayMessage("Your choice is invalid. Please try again!");
                welcome();
            }
        }
        else
        {
            userInterface.displayError("Invalid input format. Please try again");
            welcome();
        }
    }

    private  void login() {
        Scanner scanner = new Scanner(System.in);
        userInterface.promptInputMessage("Please enter your username");
        String name = scanner.nextLine();
        userInterface.promptInputMessage("Please enter your password");
        String password = scanner.nextLine();
        //check the password and user name
        if(listOfCustomers.isValidUser(name,password)) {
            loggedInUser = name;
            customerHome();
        }
        else if (listOfOwners.isValidUser(name,password)){
            loggedInUser = name;
            ownerHome();
        }
        else if (admin.isValidUser(name,password)){
            loggedInUser = name;
            adminHome();
        }
        else {
            userInterface.displayError("Invalid credentials. Please try again");
            login();
        }
        //customerHome();
    }

    private  void register() {
        Scanner scanner = new Scanner(System.in);

//            User’s name (first name, last name)
//            Email
//            Password
//            Confirm password
//            Concession? (Senior citizen or veterans)

        System.out.println("Please enter your full name");
        String fullName = scanner.nextLine();
        System.out.println("Please enter your password");
        String passWord = scanner.nextLine();
        System.out.println("Please confirm your password");
        String confirm = scanner.nextLine();
        System.out.println("Please enter your email");
        String email = scanner.nextLine();
        System.out.println("Concession? (please enter 'senior citizen' or 'veterans' or 'none')");
        String concession = scanner.nextLine();

        if (concession.equals("senior citizen")){
        }
        else if (concession.equals("veterans") ){
        }
        else if (concession.equals("none") ){
        }
//        else {
//            System.out.println("your input is not valid, please try again!");
//            register();
//        }
        System.out.println("Do you want to register as a (1)halls owner or (2)customer?");
        int type = scanner.nextInt();
        if (type == 1){
            //owner
            System.out.println("Your account has been successfully created");
            login();
        }
        if (type == 2){
            //customer
            System.out.println("Your account has been successfully created");
            login();
        }

        else {
            System.out.println("Your input is not valid, please try again!");
            register();
        }
    }

    private  void customerHome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Home");
        boolean flag = true;
        while(flag) {
            userInterface.displayMenu(listOfCustomers.getCustomerByUserName(loggedInUser));
            System.out.println("");
            userInterface.promptInputMessage("Please select an option from the menu");
            String choice = scanner.next();
            if( isValidInteger(choice)) {
                switch (Integer.parseInt(choice)) {
                    case 1:
                        userInterface.displayAllHalls(listOfHalls.getHallList());
                        userInterface.promptInputMessage("Please select a hall by the index number");

                        System.out.println();
                        String input = scanner.next();
                        if (isValidInteger(input)) {
                            int hallIndex = Integer.parseInt(input);
                            if(hallIndex < 1 || hallIndex > listOfHalls.getHallList().size() ){
                                userInterface.displayError("Invalid choice. Returning to home");
                            }
                            else {
                                userInterface.display(listOfHalls.getHallDetails(hallIndex - 1));
                                userInterface.promptInputMessage("Would you like to request a quotation for this hall: Y/N");
                                input = scanner.next();
                                if (input.equalsIgnoreCase("Y"))
                                    requestQuote(hallIndex - 1);
                                else if (input.equalsIgnoreCase( "N")) {
                                }
                                else {
                                    userInterface.displayError("Invalid choice. Considering it as No.");
                                    continue;
                                }
                            }
                        }
                        else
                        {
                            userInterface.displayError("Invalid Input. Going to home");
                        }
                        break;

//                    case 2:
//                        System.out.println("Please select a booking");
//                        //[Bookings]
//                        //System.out.println("(1) Name: 'Library'");
//                        System.out.println();
//                        int booking = scanner.nextInt();
//                        if (booking == 1) {
//                            bookingDetail();
//                        }
//                        customerHome();
//                        break;
//
//                    case 3:
//                        profile();
//                        break;

                    case 2:
                        //[Bookings]
                        BookingList completedBookingsByUser = new BookingList();
                        completedBookingsByUser.setBookingList(listOfBookings.getAllCompletedBookingsByUser(loggedInUser));
                        userInterface.displayAllBookings(completedBookingsByUser.getBookingList());
                        if(completedBookingsByUser.getBookingList().isEmpty())
                        {
                            userInterface.displayError("There are no bookings. Going to Home");
                            continue;
                        }
                        userInterface.promptInputMessage("Please select a booking");

                        System.out.println();
                        input = scanner.next();
                        if (isValidInteger(input)) {
                            int bookingIndex = Integer.parseInt(input) - 1;
                            if(bookingIndex >= 0 && bookingIndex < completedBookingsByUser.getBookingList().size() )
                            {
                                userInterface.promptInputMessage("Would you like to leave a review? Y/N");
                                input = scanner.next();
                                if(input.equalsIgnoreCase("Y"))
                                {
                                    writeAReview(completedBookingsByUser, bookingIndex);
                                }
                                else if(input.equalsIgnoreCase("N")){
                                    userInterface.displayError("You chose no. Going to home menu");
                                }
                                else {
                                    userInterface.displayError("Invalid choice. Considering it as No.");

                                }
                            }
                            else{
                                userInterface.displayError("Invalid choice. Returning to home");
                            }
                        }
                        else
                        {
                            userInterface.displayError("Invalid Input. Showing Customer Home menu");
                        }
                        break;

                    case 3:
                        listOfBookings.getBookingList();
                        userInterface.promptInputMessage("If you want to change the date or cancel, please contact the admin.");
//                        int booking3 = scanner.nextInt();
//                        switch (booking3) {
//                            case 1:
//                                cancel();
//                        }
                        break;

                    case 4:
                        createBooking();
                        break;
                    case 5:
                        userInterface.displayError("Loggin out...");
                        userInterface.displayError("Logged out");
                        flag = false;
                        System.exit(0);
                        break;

                    default:
                        userInterface.displayError("Invalid choice. Please try again");

                }
            }
        }
    }

    public void writeAReview(BookingList completedBookings, int bookingIndex){
        int rating = 0;
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean flag = true;
        while(flag) {
            userInterface.promptInputMessage("Provide a rating between 0 and 5 (integer only)");
            input = scanner.next();
            if (isValidInteger(input)) {
                rating = Integer.parseInt(input);
                if (rating < 0 || rating > 5) {
                    userInterface.displayError("Invalid rating. Please try again");
                } else {
                    ;
                }
            } else {
                userInterface.displayError("Invalid input please try again");
                writeAReview(completedBookings, bookingIndex);
            }
            userInterface.promptInputMessage("Enter the description for the review");
            scanner.nextLine();
            String description = scanner.nextLine();
            if (!isValidDescription(input)) {
                userInterface.displayError("Invalid input please try again");
            } else {
                ;
            }

            userInterface.displayMessage("Review for hall: " + completedBookings.getBookingList().get(bookingIndex).getHall().getName());
            userInterface.displayMessage("Rating: " + rating);
            userInterface.displayMessage("Review description: " + description);
            System.out.println();
            userInterface.promptInputMessage("Post this review to the hall? Y/N");
            input = scanner.next();
            if (input.equalsIgnoreCase("Y")) {
                if (completedBookings.getBookingList().get(bookingIndex).getHall().addReview(rating, description, listOfCustomers.getCustomerByUserName(loggedInUser), completedBookings.getBookingList().get(bookingIndex).getBookingId())) {
                    userInterface.displayMessage("Review successful");
                } else {
                    userInterface.displayMessage("This booking has already been reviewed.");
                }
            } else if (input.equalsIgnoreCase("N")) {
                userInterface.displayMessage("You chose no. Going to home menu");
                flag = false;
            } else {
                userInterface.displayError("Invalid choice. Considering it as No. Going to home");
                flag = false;
            }
        }

    }

    public void createBooking(){
        Scanner scanner = new Scanner(System.in);
        QuotationList quotationsByUser = new QuotationList();
        quotationsByUser.setQuotationList(listOfQuotations.getQuotationsByUsername(loggedInUser));
        userInterface.displayAllQuotations(quotationsByUser.getQuotationList());
        if(quotationsByUser.getQuotationList().isEmpty()){
            userInterface.displayMessage("No quotaions have been requested. Going to home menu");
            return;
        }
        System.out.println();
        userInterface.promptInputMessage("Please select a quotation by the index number");
        System.out.println();
        String input = scanner.next();
        if (isValidInteger(input)) {
            int quotationIndex= Integer.parseInt(input) - 1;
            if(quotationIndex >= 0 && quotationIndex < quotationsByUser.getQuotationList().size()) {
                if (listOfBookings.isBookingExistsForQuote(quotationsByUser.getQuotationDetails(quotationIndex).getQuoteId())) {
                    userInterface.displayError("A booking has already been made for this quotation.");
                    return;
                }
                else {
                    userInterface.display(quotationsByUser.getQuotationDetails(quotationIndex));
                    userInterface.promptInputMessage("Would you like to continue with the booking?: Y/N");
                    input = scanner.next();
                    if (input.equalsIgnoreCase("Y")) {
                        userInterface.promptInputMessage("Would you like to proceed with the payment?: Y/N");
                        input = scanner.next();
                        if (input.equalsIgnoreCase("Y")) {
                            userInterface.displayMessage("Proceeding to payment site");
                            boolean flag = listOfBookings.addBooking(quotationsByUser.getQuotationDetails(quotationIndex), true);
                            if (flag) {
                                String[] timeslots = new String[]{"Morning", "Afternoon", "Evening"};
                                int timeSlot = 0;
                                for (int i = 0; i < 3; i++) {
                                    if (quotationsByUser.getQuotationDetails(quotationIndex).getQuoteTime().equals(timeslots[i])) {
                                        timeSlot = i;
                                    }
                                }
                                Date firstDate = parseDate("07/09/2019");
                                long dateDifference = (quotationsByUser.getQuotationDetails(quotationIndex).getQuoteDate().getTime() - firstDate.getTime()) / 86400000;
                                ArrayList<Boolean[]> availability = quotationsByUser.getQuotationDetails(quotationIndex).getHall().getAvailability();
                                availability.get((int) dateDifference)[timeSlot] = false;
                                quotationsByUser.getQuotationDetails(quotationIndex).getHall().setAvailability(availability);
                            }
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            userInterface.displayMessage("Payment received");
                            userInterface.displayMessage("Hall has been booked");
                            System.out.println();
                        }
                    }
                    return;
                }
            }
            else
            {
                userInterface.displayError("Invalid choice. Returning to home");
            }
        }
        else{
            userInterface.displayError("Invalid input. Please try again");
            createBooking();
        }
    }

    private  void ownerHome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(1) Manage halls");
        System.out.println("(2) Create halls");
        System.out.println("(3) Manage discount");
        System.out.println("(4) Update payment status");
        System.out.println("(5) Manage bookings");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Please select a hall");
                //[Bookings]
                System.out.println("(1) Name: 'Library'");
                System.out.println("(2) Home");
                System.out.println();
                int hall = scanner.nextInt();
                if (hall == 1){
                    manageHall();
                }
                if(hall == 2){
                    ownerHome();
                };break;
            case 2:
//              Halls name
//              Owner details
//              description
//              availability
//              quotes
                System.out.println("Please enter the name of your hall");
                String hallName = scanner.next();
                System.out.println("Please write the description of your hall");
                String hallDes = scanner.next();
//                System.out.println("Please set the initial availability value of your hall ");
//                boolean available = true;
                System.out.println("You have created a hall successfully!");
                ownerHome();
                break;

            case 3:
                //setStatusMethod
                System.out.println("Please input the corresponding number of halls");
                System.out.println("Would you like to apply the discount? Yes/No");
                String c = scanner.next();
                if (c == "Yes")
                {
                    System.out.println("You has successfully apply the discount");break;
                }
            case 4:
                //set

                System.out.println("Please select a booking");
                //[Bookings]
                System.out.println("(1) Name: 'Library', Status: unpaid");
                System.out.println("(2) Home");
                System.out.println();
                int a = scanner.nextInt();
                if (a == 1){
                    System.out.println("Please select the payment status you want to change to: (Unpaid/Paid)");
                    String status = scanner.next();
                    switch (status){
                        case "Unpaid":
                            System.out.println("The status of booking has been changed to unpaid!");
                            break;
                        case "paid":
                            System.out.println("The status of booking has been changed to Deposit Paid!");
                            break;
                    }

                }
                if(a == 2){
                    ownerHome();
                };break;

            case 5:
                System.out.println(" If you'd like to cancel the booking ,please input 1");break;


        }
        ownerHome();
    }

    private  void manageHall() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(1) Name: 'Library'");
        System.out.println("(2) Description: this hall is a very good place to have dinner. The Location is 5 Peter Street, the capacity is 200 people.");
        System.out.println("(3) Home");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Please enter the name");
                String Name = scanner.next();
                manageHall();
            case 2:
                System.out.println("Please enter the description");
                String Description = scanner.next();
                manageHall();
            case 3: ownerHome();
        }

    }

    private  void adminHome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" If you want to Look through the users details, please press1");
        System.out.println(" If you want to Change User Status, please press 2");
        System.out.println(" If you want to Manage Discount, please press 3");
        int choice = scanner.nextInt();
        if (choice == 1)
        {
            System.out.println("displayMethod");
        }
        if (choice == 2)
        {
            System.out.println("Please input the corresponding number of user");
            //setMethod
            System.out.println("You has successfully change the user status");
        }
        if (choice == 3)
        {
            System.out.println("Please input the corresponding number of booking");
            System.out.println("Would you like to apply the discount? Y/N");
            char c = scanner.next().charAt(0);
            if (c == 'Y')
            {
                System.out.println("You has successfully apply the discount");
            }
            else
            {
                adminHome();
            }

        }

    }

    private  void profile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(1) Name: A");
        System.out.println("(2) Email: zxcv@abc.com");
        System.out.println("(3) Concession: no");
        System.out.println("(4) Home");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Please enter your full name");
                String fullName = scanner.next();
                System.out.println(fullName);
                profile();
                break;
            case 2:
                System.out.println("Please enter your email");
                String email = scanner.next();
                profile();
                break;
            case 3:
                System.out.println("Concession? (please enter 'senior citizen' or 'veterans' or 'none')");
                String concession = scanner.next();
                profile();
                break;
            case 4: customerHome();
                break;

        }
    }

    private  void bookingDetail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: 'Library'");
        System.out.println("Duration: 20/09/2019 - 22/09/2019");
        System.out.println("Other service: include a meal");
        System.out.println("Discount rate: 15%");
        System.out.println("(1) Home");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: customerHome();
        }

    }

    private  void cancel() {
        System.out.println("Your booking has been successfully canceled!");
    }

    private  void hallDetail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: 'Library'");
        System.out.println("Description: this hall is a very good place to have dinner. The Location is 5 Peter Street, the capacity is 200 people.");
        System.out.println("Availability: Yes");
        System.out.println("(1) Request for quotation");
        System.out.println("(2) Back to home");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: requestQuote(1);
            case 2: customerHome();
        }
    }

    private  void requestQuote(int hallIndex) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        Date quoteDate = new Date();
        int timeSlot = 0;
        int capacity = 0;
        String discount = "none";
        String purpose = "";
        boolean cateringOptions = false;
        String input = "";
        String[] timeslots = new String[]{"Morning" ,"Afternoon", "Evening"};
        double expectedPrice = 0.0;

        while(flag){
            userInterface.promptInputMessage("Please enter the slot number for the chosen date");
            String choice = scanner.next();
            if(isValidInteger(choice)){
                int serialNo = Integer.parseInt(choice);
                if(serialNo > 0 && serialNo <= listOfHalls.getHallDetails(hallIndex).getAvailability().size())
                {
                    userInterface.displayMessage("Choose the time slot.\n(1) Morning\n(2) Afternoon\n(3) Evening");
                    userInterface.promptInputMessage("Enter the index number to choose date for booking");
                    String timeInput = scanner.next();
                    if(isValidInteger(timeInput))
                    {
                        timeSlot = Integer.parseInt(timeInput);
                        if(timeSlot >= 1 && timeSlot <= 3 )
                        {
                            if (listOfHalls.getHallDetails(hallIndex).getAvailability().get(serialNo - 1)[timeSlot - 1])
                            {
                                quoteDate.setTime(parseDate("07/09/2019").getTime() + ((serialNo - 1) * 86400000));

                                userInterface.displayMessage("Chosen slot: " + new SimpleDateFormat("dd/MM/yyyy").format(quoteDate) + " " + timeslots[timeSlot-1]);
                                userInterface.promptInputMessage("Proceed with this date time combination? Y/N");
                                choice = scanner.next();
                                if(choice.equalsIgnoreCase("Y")) {
                                    userInterface.displayError("Setting chosen combination");
                                    flag = false;
                                }
                                else if(!choice.equalsIgnoreCase("N")){
                                    userInterface.displayError("Invalid input. Setting choice as no. ");
                                }
                            }
                            else
                            {
                                userInterface.displayError("Slot has already been booked. Please choose another slot");
                            }
                        }
                        else
                        {
                            userInterface.displayError("Invalid time slot chosen. Please try again");
                        }
                    }
                    else
                    {
                        userInterface.displayError("Invalid input type entered. Please try again");
                    }
                }
                else
                {
                    userInterface.displayError("Invalid date chosen. Please choose a date from the dates displayed by entering the respective serialNo.");
                }
            }
            else
            {
                userInterface.displayError("Invalid input type entered. Please try again");
            }

        }

        System.out.println();
        flag = true;
        userInterface.promptInputMessage("Enter the number of people attending the event" );
        while(flag)
        {
            input = scanner.next();
            if(isValidInteger(input)){
                capacity = Integer.parseInt(input);
                if(capacity > 0 && capacity <= listOfHalls.getHallDetails(hallIndex).getCapacity()){
                    flag = false;
                    expectedPrice = capacity * listOfHalls.getHallDetails(hallIndex).getPricePerPerson();
                }
                else{
                    userInterface.displayError("Number of people attending the event is not correct. Please try again");
                }
            }
            else{
                userInterface.displayError("Invalid input type entered. Please try again");
            }
        }

        System.out.println();
        userInterface.promptInputMessage("Would you like catering for the event? It is additional $20/person Y/N" );
        input = scanner.next();
        if(input.equalsIgnoreCase("Y")){
            cateringOptions = true;
            expectedPrice += capacity * 20.0;
        }
        else if (input.equalsIgnoreCase("N"))
        {
            cateringOptions = false;
        }
        else
        {
            userInterface.displayError("Invalid choice. Considering it as No.");
            cateringOptions = false;
        }

        System.out.println();
        userInterface.displayMessage("Event Types\n(1) Birthday\n(2) Wedding ceremony\n(3) Wedding reception\n(4) Anniversary");
        userInterface.promptInputMessage("Enter the index number to chose the event type.");
        flag = true;
        while(flag) {
            purpose = scanner.next();
            if (isValidInteger(purpose)) {
                switch (Integer.parseInt(purpose)){
                    case 1:
                        purpose = "Birthday";
                        flag = false;
                        break;
                    case 2:
                        purpose = "Wedding ceremony";
                        flag = false;
                        break;
                    case 3:
                        purpose = "Wedding reception";
                        flag = false;
                        break;
                    case 4:
                        purpose = "Anniversary";
                        flag = false;
                        break;
                    default:
                        userInterface.displayError("Please select from the above 4 options");
                }
            }
            else
            {
                userInterface.displayError("Invalid input. Please give a valid input.");
            }
        }

        System.out.println();
        userInterface.promptInputMessage("Would you like to apply for discount? Y/N");
        input = scanner.next();
        if(input.equalsIgnoreCase("Y")){
            userInterface.promptInputMessage("Enter your discount keyword.");
            flag = true;
            while (flag) {
                discount = scanner.next();
                if (discount.equalsIgnoreCase("prime")) {
                    userInterface.displayMessage("Discount code applied\nDisount: " + listOfHalls.getHallDetails(hallIndex).getDiscount() + "%\n");
                    expectedPrice = expectedPrice * (100.0 - listOfHalls.getHallDetails(hallIndex).getDiscount()) / 100;
                    flag = false;
                } else {
                    userInterface.displayError("Invalid discount keyword. Please try again");
                }
            }
        }
        else if (input.equalsIgnoreCase("N"))
        {
            userInterface.displayMessage("You chose not to provide discount code");
        }
        else
        {
            userInterface.displayError("Invalid choice. Considering it as No.");
        }

        userInterface.displayMessage("Please review the details before proceeding to next step");
        userInterface.displayMessage("Hall name: \t\t\t\t"+ listOfHalls.getHallDetails(hallIndex).getName());
        userInterface.displayMessage("Date and time: \t\t\t\t" + new SimpleDateFormat("dd/MM/yyyy").format(quoteDate) + " " + timeslots[timeSlot-1]);
        userInterface.displayMessage("Number of people: \t\t\t"+ capacity);
        userInterface.displayMessage("Event: \t\t\t\t\t" + purpose);
        if (cateringOptions){
            userInterface.displayMessage("Catering Options:\t\t\t" + "Yes");
        }else {
            userInterface.displayMessage("Catering Options:\t\t\t" + "No");
        }        if(!discount.equalsIgnoreCase("none"))
            userInterface.displayMessage("Discount: \t\t\t\t" + listOfHalls.getHallDetails(hallIndex).getDiscount() + "%");
        userInterface.displayMessage("Expected price to be paid: \t\t$" + expectedPrice);
        System.out.println();
        userInterface.promptInputMessage("Proceed with above details? Y/N");
        input = scanner.next();
        if(input.equalsIgnoreCase("Y")) {
            //send the request
            userInterface.displayMessage("Your quotation request has been sent!");
            listOfQuotations.createQuotation(listOfQuotations.getQuotationList().size() + 1, capacity, true, expectedPrice, quoteDate, timeslots[timeSlot -1], listOfHalls.getHallDetails(hallIndex).getDiscount(), cateringOptions, listOfHalls.getHallDetails(hallIndex), listOfCustomers.getCustomerByUserName(loggedInUser));
            customerHome();
        }
        else{
            userInterface.displayMessage("Resetting details.");
            System.out.println();
            System.out.println();
            userInterface.display(listOfHalls.getHallDetails(hallIndex));
            requestQuote(hallIndex);
        }
    }

    public boolean isValidInteger(String input){
        boolean flag = false;
        try {
            int givenInput = Integer.parseInt(input);
            flag = true;
        }
        catch ( NumberFormatException e)
        {
            ;
        }
        catch (Exception e)
        {
            userInterface.displayError("Unknown exception occurred");
        }
        return  flag;

    }

    public boolean isValidDescription(String description){
        boolean flag = true;
        if(description.length() > 2000 || description.isEmpty())
            flag = false;
        return flag;
    }



    public Date parseDate(String input){
        Date date =  new Date();
        try {
            SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            date = dateFormat.parse(input);
        }
        catch ( ParseException e)
        {
            userInterface.displayError("Invalid Date format. Please try again");
            date = null;
        }
        catch (Exception e)
        {
            userInterface.displayError("Unknown exception occurred");
            date = null;
        }
        return  date;

    }

}
