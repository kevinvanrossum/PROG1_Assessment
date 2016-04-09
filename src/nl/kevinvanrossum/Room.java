package nl.kevinvanrossum;


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
     */
    private String description;
    private ArrayList<Item> items = new ArrayList<>(); // TODO: change to HashMap
    private HashMap<String, Room> exits = new HashMap<>();


    /**
     * Room contructor method
     *
     * @param description of the room
     */
    public Room(String description) {
        this.description = description;
    }


    /**
     * Add items to the room
     *
     * @param item to add to room
     */
    public void addItem(Item item) {
        this.items.add(item);
    }


    /**
     * Get the items in the Room
     * @return items in Room
     */
    public ArrayList<Item> getItems() {
        return items;
    }


    /**
     * Get the exits in the Room
     * @return exits in Room
     */
    public HashMap<String, Room> getExits() {
        return exits;
    }

    /**
     * Add an exit to the Room
     * @param direction of the exit
     * @param room the exit leads to
     */
    public void addExit(String direction, Room room) {
        direction = direction.toLowerCase();


        if (direction.equals("north") || direction.equals("south") || direction.equals("east") || direction.equals("west")) {
            exits.put(direction, room);
            return;
        }

        System.out.println("Geen geldige richting, probeer opnieuw");

    }

    public String getDescription() {
        return description;
    }
}
