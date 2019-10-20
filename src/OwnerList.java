import java.util.ArrayList;

public class OwnerList {
    private ArrayList<Owner> ownerList;

    public OwnerList()
    {
        ownerList = new ArrayList<>();
    }

    public ArrayList<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(ArrayList<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    public boolean addOwner(String userName, String password, String name, boolean status, int id){
        ownerList.add(new Owner(userName, password, name, status, id));
        return true;

    }

    public Owner getOwner(String userName){
        Owner requiredOwner = ownerList.get(0);
        boolean flag = false;
        for (Owner owner : ownerList)
        {
            if (owner.getName().equals(userName))
            {
                requiredOwner = owner;
                flag=  true;
            }
        }
        if(flag == false)
            System.out.println("Owner not found. Setting default owner");
        return requiredOwner;
    }

    public boolean isValidUser(String userName, String password){
        boolean flag = false;
        for ( Owner owner : ownerList) {
            if(owner.getUserName().equals(userName) && owner.getPassword().equals(password)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
