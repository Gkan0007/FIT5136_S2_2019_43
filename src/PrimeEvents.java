import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PrimeEvents {


    private UserList listOfUsers;
    private CustomerList listOfCustomers;
    private OwnerList listOfOwners;
    private QuotationList listOfQuotations;
    private Admin admin;
    private HallList listOfHalls;


    PrimeEvents()
    {
        listOfUsers = new UserList();
        listOfCustomers = new CustomerList();
        listOfOwners = new OwnerList();
        admin = new Admin();
        listOfHalls = new HallList();
        listOfQuotations = new QuotationList();
        init();

        System.out.println("  **************************************************** ");
        System.out.println("** *                                                * **");
        System.out.println("** *                  Prime Events                  * **");
        System.out.println("** *                                                * **");
        System.out.println("  **************************************************** ");
        System.out.println(" Welcome to Prime Events, hope you enjoy the events! \n");
    }

    public void init(){
        try {
            listOfOwners.addOwner(new Owner("user1", "password", "User 2", true, 1));
            listOfCustomers.addCustomer(new Customer(" ", " ", "User 2", true, true, true, 1));
            listOfHalls.createHall("Hall1", listOfOwners.getOwner("user1"), "abcd", 100, 15, "address", 3000.0, 20);
            listOfHalls.createHall("Hall2", listOfOwners.getOwner("user1"), "abcd", 100, 15, "address", 3000.0, 20);
            listOfQuotations.createQuotation(1,100,true,2000.0,new Date(),"Evening",0.15,true,listOfHalls.getHallDetails(1),listOfCustomers.getCustomer(" "));
        }
        catch (Exception e)
        {
            System.out.println("An error occurred. Error: " + e);
        }

    }

    public  void welcome() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("- Please any key to navigate to Login/Register view ...\n");
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
                System.out.println("Your choice is invalid. Please try again!");
                welcome();
            }
        }
        else
        {
            System.out.println("Invalid input format. Please try again");
            welcome();
        }
    }

    private  void login() {
        listOfUsers = new UserList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username");
        String name = scanner.nextLine();
        System.out.println("Please enter your password");
        String password = scanner.nextLine();
        //check the password and user name
        if(listOfCustomers.isValidUser(name,password))
            customerHome();
        else if (listOfOwners.isValidUser(name,password))
            ownerHome();
        else if (admin.isValidUser(name,password))
            adminHome();
        else {
            System.out.println("Invalid credentials. Please try again");
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
            System.out.println("(1) View halls and request a quotation");
            System.out.println("(2) View bookings");
            System.out.println("(3) View my profile");
            System.out.println("(4) Write a review");
            System.out.println("(5) Manage bookings");
            System.out.println("(6) View quotations");
            System.out.println("(7) Logout");
            System.out.println("Please select an option from the menu");
            String choice = scanner.next();
            if( isValidInteger(choice)) {
                switch (Integer.parseInt(choice)) {
                    case 1:
                        listOfHalls.getAllHalls(listOfHalls);
                        System.out.println("Please select a hall by the index number");
                        System.out.println();
                        String input = scanner.next();
                        if (isValidInteger(input)) {
                            int hallIndex = Integer.parseInt(input) - 1;
                            listOfHalls.displayHallDetails(hallIndex);
                            System.out.println("Would you like to request a quotation for this hall: Y/N");
                            input = scanner.next();
                            if(input.equalsIgnoreCase("Y"))
                                requestQuote(hallIndex);
                            else if(!input.equalsIgnoreCase("N"))
                                System.out.println("Invalid choice. Considering it as No.");
                        } else {
                            continue;
                        }
                        break;
                    case 2:
                        System.out.println("Please select a booking");
                        //[Bookings]
                        System.out.println("(1) Name: 'Library'");
                        System.out.println();
                        int booking = scanner.nextInt();
                        if (booking == 1) {
                            bookingDetail();
                        }
                        break;

                    case 3:
                        profile();
                        break;

                    case 4:
                        System.out.println("Please select a booking");
                        //[Bookings]
                        System.out.println("(1) Name: 'Library'");
                        System.out.println();
                        int booking2 = scanner.nextInt();
                        switch (booking2) {
                            case 1:
                                System.out.println("Please write your review about the booking");
                                String bookReview = scanner.next();
                                System.out.println("Your review has been post!");
                                customerHome();
                        }
                        ;

                        break;

                    case 5:
                        System.out.println("Please select a booking to cancel");
                        //[Bookings]
                        System.out.println("(1) Name: 'Library'");
                        System.out.println("If you want to change the date, please contact the admin.");
                        System.out.println();
                        int booking3 = scanner.nextInt();
                        switch (booking3) {
                            case 1:
                                cancel();
                        }
                        break;

                    case 6:
                        //[Quotations]
                        listOfQuotations.getAllQuotations(listOfQuotations);
                        System.out.println();
                        System.out.println("(H) Home");
                        System.out.println("Please select a hall by the index number");
                        System.out.println();
                        String h = scanner.next();


                    case 7:
                        System.out.println("Loggin out...");
                        System.out.println("Logged out");
                        flag = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again");

                }
            }
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
        int timeSlot;
        int capacity;
        double discount;
        String purpose;
        boolean cateringOptions;



        while(flag){
            System.out.println("Please enter the slot number for the chosen date");
            String choice = scanner.next();
            if(isValidInteger(choice)){
                int serialNo = Integer.parseInt(choice);
                if(serialNo > 0 && serialNo <= listOfHalls.getHallDetails(hallIndex).getAvailability().size())
                {
                    System.out.println("Choose the time slot.");
                    System.out.println("(1) Morning");
                    System.out.println("(2) Afternoon");
                    System.out.println("(3) Evening");
                    System.out.println("Enter the index number of chosen time slot");
                    String timeInput = scanner.next();
                    if(isValidInteger(timeInput))
                    {
                        timeSlot = Integer.parseInt(timeInput);
                        if(timeSlot >= 1 && timeSlot <= 3 )
                        {
                            if (listOfHalls.getHallDetails(hallIndex).getAvailability().get(serialNo - 1)[timeSlot - 1])
                            {
                                quoteDate.setTime(parseDate("07/09/2019").getTime() + ((serialNo - 1) * 86400000));
                                System.out.println( quoteDate);
                                flag = false;
                            }
                            else
                            {
                                System.out.println("Slot has already been booked. Please choose another slot");
                            }
                        }
                        else
                        {
                            System.out.println("Invalid time slot chosen. Please try again");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid input type entered. Please try again");
                    }
                }
                else
                {
                    System.out.println("Invalid date chosen. Please choose a date from the dates displayed by entering the respective serialNo.");
                }
            }
            else
            {
                System.out.println("Invalid input type entered. Please try again");
            }

        }

        flag = true;
        System.out.println("Enter the number of people attending the event" );
        while(flag)
        {
            String input = scanner.next();
            if(isValidInteger(input)){
                capacity = Integer.parseInt(input);
                if(capacity > 0 && capacity <= listOfHalls.getHallDetails(hallIndex).getCapacity()){
                    flag = false;
                }
                else{
                    System.out.println("Number of people attending the event is not correct. Please try again");
                }
            }
            else{
                System.out.println("Invalid input type entered. Please try again");
            }
        }


        System.out.println("Would you like catering for the event? Y/N" );
        String input = scanner.next();
        if(input.equalsIgnoreCase("Y")){
            cateringOptions = true;
        }
        else if (input.equalsIgnoreCase("N"))
        {
            cateringOptions = false;
        }
        else
        {
            System.out.println("Invalid choice. Considering it as No.");
            cateringOptions = false;
        }


        System.out.println("Choose your purpose for booking this hall?");
        System.out.println("(1) ");
        purpose = scanner.nextLine();
        System.out.println("Do you have discount keyword?");
        String keyword = scanner.nextLine();
        System.out.println("you want to book for: ");
        System.out.println("you also want a: ");
        System.out.println("your purpose is: "+purpose);
        System.out.println("your discount keyword is: "+keyword);
        System.out.println("Yes/No");
        String choice = scanner.nextLine();
        switch (choice) {
            case "Yes":
                //send the request
                System.out.println("Your request has been sent! :D");
                customerHome();
                break;
            case "No": requestQuote(1);
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
            System.out.println("Unknown exception occurred");
        }
        return  flag;

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
            System.out.println("Invalid Date format. Please try again");
            date = null;
        }
        catch (Exception e)
        {
            System.out.println("Unknown exception occurred");
            date = null;
        }
        return  date;

    }

}
