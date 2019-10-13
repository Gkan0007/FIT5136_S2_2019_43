public class Customer extends User {

    private boolean consession;
    private boolean veteranStatus;
    private int customerId;

    public Customer(String userName, String password, String name, boolean accountStatus ,boolean consession, boolean veteranStatus, int customerId) {
        super(userName, password, name, accountStatus);
        this.consession = consession;
        this.veteranStatus = veteranStatus;
        this.customerId = customerId;
    }


    public boolean isConsession() {
        return consession;
    }

    public void setConsession(boolean consession) {
        this.consession = consession;
    }

    public boolean isVeteranStatus() {
        return veteranStatus;
    }

    public void setVeteranStatus(boolean veteranStatus) {
        this.veteranStatus = veteranStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

}
