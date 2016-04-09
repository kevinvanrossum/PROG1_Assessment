package nl.kevinvanrossum;


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
    private HashMap<String, Item> items = new HashMap<>();
    private HashMap<String, Room> exits = new HashMap<>();


    /**
     * Room contructor method
     *
     * @param description of the room
     */
    Room(String description) {
        this.description = description;
    }


    /**
     * Add items to the room
     *
     * @param item to add to room
     */
    void addItem(Item item) {
        this.items.put(item.getName().toLowerCase(), item);
    }


    /**
     * Get the items in the Room
     *
     * @return items in Room
     */
    HashMap<String, Item> getItems() {
        return items;
    }


    /**
     * Get the exits in the Room
     *
     * @return exits in Room
     */
    HashMap<String, Room> getExits() {
        return exits;
    }

    /**
     * Add an exit to the Room
     *
     * @param direction of the exit
     * @param room      the exit leads to
     */
    void addExit(String direction, Room room) {
        direction = direction.toLowerCase();


        if (direction.equals("north") || direction.equals("south") || direction.equals("east") || direction.equals("west")) {
            exits.put(direction, room);
            return;
        }

        System.out.println("Geen geldige richting, probeer opnieuw");

    }

    String getDescription() {
        return description;
    }

    boolean hasItem(String itemName) {
        return items.containsKey(itemName.toLowerCase());
    }

    void removeItem(Item item) {
        items.values().remove(item);
    }

    /**
     * Get the item from the Room
     *
     * @param key
     * @return the item
     */
    Item getItem(String key) {
        return items.get(key.toLowerCase());
    }
}
