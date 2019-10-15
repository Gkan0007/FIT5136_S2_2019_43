import java.util.ArrayList;

public class CustomerList {

    private ArrayList<Customer> customerList;

    public CustomerList(){
        customerList = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public boolean addCustomer(Customer customer){
        customerList.add(customer);
        return true;

    }

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
}