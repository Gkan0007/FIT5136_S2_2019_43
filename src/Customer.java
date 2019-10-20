public class Customer extends User {

    private boolean consession;
    private boolean veteranStatus;
    private int customerId;
    /**
     * Constructor is a method to initialize the attribute
     */
    public Customer(String userName, String password, String name, boolean accountStatus ,boolean consession, boolean veteranStatus, int customerId) {
        super(userName, password, name, accountStatus);
        this.consession = consession;
        this.veteranStatus = veteranStatus;
        this.customerId = customerId;
    }

    /**
     * A method that to check if the Customer is consession
     */
    public boolean isConsession() {
        return consession;
    }
    /**
     * A method that to set the consession of the Customer
     * @param consession a boolean to set the consession
     */
    public void setConsession(boolean consession) {
        this.consession = consession;
    }
    /**
     * A method that to check if the Customer is veteran
     */
    public boolean isVeteranStatus() {
        return veteranStatus;
    }
    /**
     * A method that to set the veteran of the Customer
     * @param veteranStatus a boolean to set the veteran
     */
    public void setVeteranStatus(boolean veteranStatus) {
        this.veteranStatus = veteranStatus;
    }
    /**
     * A method that to get the customerId from the Customer
     */
    public int getCustomerId() {
        return customerId;
    }
    /**
     * A method that to set the customerId of the Customer
     * @param customerId an int to set the customerId
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

}
