package nl.kevinvanrossum;

import java.util.ArrayList;

/**
 * Created by Kevin van Rossum on 4-4-2016.
 *
 * @author Kevin van Rossum
 * @version 1.0
 */
class Player {

    /**
     * Instance variables
     *
     */
    private ArrayList<Item> items = new ArrayList<>();
    private int roomNumber;


    /**
     * Constructor Method
     * @param roomNumber where Player starts
     *
     */
    public Player(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
