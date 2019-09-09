import java.util.Scanner;

public class PrimeEvents {



    PrimeEvents()
    {
    }


     public static void main(String[] args) {
         welcome();
     }
    private static void welcome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.login");
        System.out.println("2.register");
        int choice = scanner.nextInt();
        if (choice == 1) { login();}
        if (choice == 2) { register();}
        else {
            System.out.println("your input is not valid, please try again!");
            welcome();}
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your name");
        String name = scanner.nextLine();
        System.out.println("please enter your password");
        String password = scanner.nextLine();
        //check the password and user name
        System.out.println("(1)I am a customer");
        System.out.println("(2)I am a halls owner");
        int choice = scanner.nextInt();
        if (choice == 1) { customerHome();}
        if (choice == 2) { ownerHome();}

    }

    private static void register() {
        Scanner scanner = new Scanner(System.in);

//            User’s name (first name, last name)
//            Email
//            Password
//            Confirm password
//            Concession? (Senior citizen or veterans)

        System.out.println("please enter your first name");
        String first_name = scanner.nextLine();
        System.out.println("please enter your last name");
        String last_name = scanner.nextLine();
        System.out.println("please enter your password");
        String password = scanner.nextLine();
        System.out.println("please confirm your password");
        String Confirm = scanner.nextLine();
        System.out.println("please enter your email");
        String email = scanner.nextLine();
        System.out.println("Concession? (please enter 'senior citizen' or 'veterans' or 'no')");
        String concession = scanner.nextLine();

        if (concession.equals("senior citizen")){
        }
        else if (concession.equals("veterans") ){
        }
        else if (concession.equals("no") ){
        }
//        else {
//            System.out.println("your input is not valid, please try again!");
//            register();
//        }
        System.out.println("do you want to register as a (1)halls owner or (2)customer?");
        int type = scanner.nextInt();
        if (type == 1){
            //owner
        }
        if (type == 2){
            //customer
        }
        else {
            System.out.println("your input is not valid, please try again!");
            register();
        }
    }

    private static void ownerHome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(1)View halls");
        System.out.println("(2)View bookings");
        System.out.println("(3)View my profile");
        System.out.println("(4)Write a review");
        System.out.println("(5)Manage bookings");
        int choice = scanner.nextInt();

    }

    private static void customerHome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(1)Manage halls");
        System.out.println("(2)Create halls");
        System.out.println("(3)Manage discount");
        System.out.println("(4)Update payment status");
        System.out.println("(5)Manage bookings");
        int choice = scanner.nextInt();
    }



}
