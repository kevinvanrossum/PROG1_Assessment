package nl.kevinvanrossum;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kevin van Rossum on 4-4-2016.
 *
 * @author Kevin van Rossum
 * @version 1.0
 */
class Player {

    /**
     * Instance variables
     */
    //private ArrayList<Item> items = new ArrayList<>();
    private HashMap<String, Item> items = new HashMap<>();
    private int roomNumber;


    /**
     * Constructor Method
     *
     * @param roomNumber where Player starts
     */
    Player(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Get the roomnumber the player is currently exploring
     *
     * @return roomNumber
     */
    int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Set the roombnumber the player is currently exploring
     *
     * @param roomNumber player is exploring
     */
    void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Add an Item to the players.items
     *
     * @param item to add to player.items
     */
    void addItem(Item item) {
        // Add itemName.lowercase() as key for better lookup
        this.items.put(item.getName().toLowerCase(), item);
    }

    /**
     * Get all the items in player.items
     *
     * @return ArrayList of Items in player.items
     */
    ArrayList<Item> getItems() {
        if (items.size() < 0) {
            return null;
        }

        return new ArrayList<Item>(items.values());
    }

    /**
     * Get the item from the backpack
     *
     * @param key
     * @return the item
     */
    Item getItem(String key) {
        return items.get(key.toLowerCase());
    }

    /**
     * Remove the item from the backpack
     *
     * @param item
     */
    void removeItem(Item item) {
        items.values().remove(item);
    }

    boolean hasItem(String itemName) {
        return items.containsKey(itemName.toLowerCase());
    }


}
