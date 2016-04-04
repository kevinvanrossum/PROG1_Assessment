package nl.kevinvanrossum;

import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kevin van Rossum on 4-4-2016.
 *
 * @author Kevin van Rossum
 * @version 1.0
 */
class Room {

    /**
     * Instance variables
     *
     */
    private String description;
    private ArrayList<Item> items = new ArrayList<>(); // TODO: change to HashMap
    private HashMap<String, Room> exits = new HashMap<>();


    /**
     * Room contructor method
     * @param description of the room
     *
     */
    public Room(String description) {
        this.description = description;
    }

}
