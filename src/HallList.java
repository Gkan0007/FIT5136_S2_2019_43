
import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HallList {
    /**
     * A method that to get the hallList from the HallList
     */
    public ArrayList<Hall> getHallList() {
        return hallList;
    }
    /**
     * A method that to set the hallList of the HallList
     * @param hallList a ArrayList<Hall> to set the hallList
     */
    public void setHallList(ArrayList<Hall> hallList) {
        this.hallList = hallList;
    }

    private ArrayList<Hall> hallList;
    /**
     * Constructor is a method to initialize the attribute
     */
    public HallList(){
        hallList = new ArrayList<>();
    }
    /**
     * A method that to create a Hall and add to hallList
     * @param name a String to set the name of the Hall
     * @param owner a String to set the owner of the Hall
     * @param description a String to set the description of the Hall
     * @param capacity a int to set the capacity of the Hall
     * @param discount a double to set the discount of the Hall
     * @param address a String to set the address of the Hall
     * @param hallArea a double to set the hallArea of the Hall
     * @param pricePerPerson a int to set the pricePerPerson of the Hall
     */
    public boolean createHall(String name, Owner owner, String description, int capacity, double discount, String address, double hallArea, int pricePerPerson) {
        hallList.add(new Hall(name, owner, description, capacity, discount, address, hallArea, pricePerPerson));
        return false;
    }
    /**
     * A method that to get all the details of a hall
     * @param id is the id of which hall details you want to get
     */
    public Hall getHallDetails(int id){

        return hallList.get(id);
    }


}
