public class User {
    private String userName;
    private String password;
    private String name;
    private boolean accountStatus;
    /**
     * Constructor is a method to initialize the attribute
     */
    public User(String userName, String password, String name, boolean accountStatus) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.accountStatus = accountStatus;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAccountStatus(boolean accountStatus){
        this.accountStatus = accountStatus;
    }

    public boolean getAccountStatus() {
        return accountStatus;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

}
