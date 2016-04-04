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
    Player(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Get the roomnumber the player is currently exploring
     * @return roomNumber
     *
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Set the roombnumber the player is currently exploring
     * @param roomNumber player is exploring
     *
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Add an Item to the players.items
     * @param item to add to player.items
     *
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * Get all the items in player.items
     * @return ArrayList of Items in player.items
     *
     */
    public ArrayList<Item> getItems() {
        if (items.size() < 0) {
            return null;
        }

        return items;
    }
}
