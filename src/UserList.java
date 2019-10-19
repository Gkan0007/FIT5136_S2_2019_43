import java.util.ArrayList;

public class UserList {
    private ArrayList<User> userList;

    public UserList() {
        userList = new ArrayList<>();
    }


    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public boolean addUser(User user){
        userList.add(user);
        System.out.println(user.getUserName());
        return true;

    }

    public boolean isValidUser(String userName, String password){
        boolean flag = false;
        for ( User user : userList) {
            if(user.getUserName().equals(userName) && user.getPassword().equals(password)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
