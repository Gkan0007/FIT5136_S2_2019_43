
import java.sql.SQLOutput;
import java.util.Scanner;

public class PrimeEvents {



    PrimeEvents()
    {
    }


    public
    static void main(String[] args) {
         welcome();
     }
    private static void welcome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("  **************************************************** ");
        System.out.println("** *                                                * **");
        System.out.println("** *                  Prime Events                  * **");
        System.out.println("** *                                                * **");
        System.out.println("  **************************************************** ");
        System.out.println(" Welcome to Prime Events, hope you enjoy the events! \n");
        System.out.print("- Please press the 'Enter' key to the homepage ...\n");
        Scanner s = new Scanner(System.in);
        s.nextLine();
        System.out.println("1.Login");
        System.out.println("2.Register");
        int choice = scanner.nextInt();
        if (choice == 1) { login();}
        if (choice == 2) { register();}
        else {
            System.out.println("Your input is invalid, please try again!");
            welcome();}
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username");
        String name = scanner.nextLine();
        System.out.println("Please enter your password");
        String password = scanner.nextLine();
        //check the password and user name
        System.out.println("Login as a customer, enter 1");
        System.out.println("Login as an Owner of halls , enter 2");
        System.out.println("Login as an Admin, enter 3");
        int choice = scanner.nextInt();
        if (choice == 1) { customerHome();}
        if (choice == 2) { ownerHome();}
        if (choice == 3) { adminHome();}
        else{
            System.out.println("Your input is invalid , please try again");
            login();
        }
    }

    private static void register() {
        Scanner scanner = new Scanner(System.in);

//            User’s name (first name, last name)
//            Email
//            Password
//            Confirm password
//            Concession? (Senior citizen or veterans)

        System.out.println("Please enter your first name");
        String firstName = scanner.nextLine();
        System.out.println("Please enter your last name");
        String lastName = scanner.nextLine();
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
        }
        if (type == 2){
            //customer
            System.out.println("Your account has been successfully created");
        }

        else {
            System.out.println("Your input is not valid, please try again!");
            register();
        }
    }

    private static void customerHome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" If you want to View halls, please enter 1");
        System.out.println(" If you want to View bookings, please enter 2");
        System.out.println(" If you want to View my profile, please enter 3");
        System.out.println(" If you want to Write a review, please enter 4");
        System.out.println(" If you want to Manage bookings, please enter 5");
        int choice = scanner.nextInt();
        switch (choice)
        {
            case 1 :
                System.out.println("display all the halls information");break;
            case 2 :
                System.out.println("display all the booking information");break;

            case 3 :
                System.out.println("Your name is : getMethod, your DOB is : , etc");break;

            case 4 :
                System.out.println("Please choose the booked hall you'd like to write a review");break;

            case 5 :
                System.out.println("If you want to change the date ,press 1");
                System.out.println("If you want to cancel the booking , press 2");
                int c = scanner.nextInt();
                break;
            default :
                System.out.println("Unknown number");
        }
    }

    private static void ownerHome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" If you want to Manage halls, please enter 1");
        System.out.println(" If you want to Create halls, please enter 2");
        System.out.println(" If you want to Manage discount, please enter 3");
        System.out.println(" If you want to Update payment status,please enter 4");
        System.out.println(" If you want to Authorise bookings, please enter 5");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                //set available
                System.out.println("You has successfully change the status of your hall");
                break;
            case 2:
//              Halls name
//              Owner details
//              description
//              availability
//              quotes
                System.out.println("Please enter the name of your hall");
                String hallName = scanner.nextLine();
                System.out.println("Please write the description of your hall");
                String hallDes = scanner.nextLine();
                System.out.println("Please set the initial availability value of your hall ");
                boolean available = true;
                break;

            case 3:
                //setStatusMethod
                System.out.println("Please input the corresponding number of halls");
                System.out.println("Would you like to apply the discount? Y/N");
                char c = scanner.next().charAt(0);
                if (c == 'Y')
                {
                    System.out.println("You has successfully apply the discount");break;
                }
            case 4:
                //set
                System.out.println(" You has successfully change the payment status");break;

            case 5:
                System.out.println(" If you'd like to cancel the booking ,please input 1");break;


        }
    }

    private static void adminHome() {
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


}
