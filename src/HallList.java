
import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HallList {

    public ArrayList<Hall> getHallList() {
        return hallList;
    }

    public void setHallList(ArrayList<Hall> hallList) {
        this.hallList = hallList;
    }

    private ArrayList<Hall> hallList;

    public HallList(){
        hallList = new ArrayList<>();
    }

    public boolean createHall(String name, Owner owner, String description, int capacity, double discount, String address, double hallArea, int pricePerPerson) {
        hallList.add(new Hall(name, owner, description, capacity, discount, address, hallArea, pricePerPerson));
        return false;
    }

    public Hall getHallDetails(int id){

        return hallList.get(id);
    }


}
