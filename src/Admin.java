public class Admin extends User{

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    private int adminId;
    /**
     * Constructor is a method to initialize the attribute
     */
    public Admin() {
        super("admin","admin", "Adminstrator", true);
        this.adminId = 1;
    }

    public boolean isValidUser(String userName, String password){
        boolean flag = false;
        if(this.getUserName().equals(userName) && this.getPassword().equals(password)){
                flag = true;
        }
        return flag;
    }
}
