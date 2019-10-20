import java.util.ArrayList;

public class CustomerList {

    private ArrayList<Customer> customerList;
    /**
     * Constructor is a method to initialize the attribute
     */
    public CustomerList(){
        customerList = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    /**
     * A method that to set the customerList of the CustomerList
     * @param customerList an ArrayList<Customer> to set the customerList
     */
    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
    /**
     * A method that to add a Customer to the customerList
     * @param customer a customer need to be added in the customerList
     */
    public boolean addCustomer(Customer customer){
        customerList.add(customer);
        return true;

    }
    /**
     * A method that to check if the login is valid
     * @param userName is a String to provide the user name
     * @param password is a String to provide the password
     */
    public boolean isValidUser(String userName, String password){
        boolean flag = false;
        for ( Customer customer : customerList) {
            if(customer.getUserName().equals(userName) && customer.getPassword().equals(password)){
                flag = true;
                break;
            }
        }
        return flag;
    }
    /**
     * A method that to get a Customer by using userName
     * @param userName is a String to provide the userName
     */
    public Customer getCustomer(String userName){
        Customer customer = customerList.get(0);
        for (Customer cust: customerList){
            if (cust.getUserName().equals(userName))
                customer = cust;
        }
        return customer;
    }

    public Customer getCustomerByUserName(String userName){
        for(Customer customer: customerList){
            if(customer.getUserName().equals(userName)){
                return customer;
            }
        }
        return null;
    }
}
