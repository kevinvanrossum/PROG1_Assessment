package nl.kevinvanrossum;

import java.util.ArrayList;

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
    private ArrayList<Item> items = new ArrayList<>();


    /**
     * Room contructor method
     * @param description of the room
     *
     */
    public Room(String description) {
        this.description = description;
    }


}
