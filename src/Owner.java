public class Owner extends User {

    private int ownerId;
    /**
     * Constructor is a method to initialize the attribute
     */
    public Owner(String userName, String password, String name, boolean accountStatus, int ownerId) {
        super(userName, password, name, accountStatus);
        this.ownerId = ownerId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
