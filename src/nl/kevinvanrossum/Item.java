package nl.kevinvanrossum;

/**
 * Created by Kevin van Rossum on 4-4-2016.
 *
 * @author Kevin van Rossum
 * @version 1.0
 */
class Item {

    /**
     * Instance variables
     *
     */
    private String name;
    private String usageText;


    /**
     * Item constructor method
     * @param name Item name
     * @param usageText Text to display when using the use command
     *
     */
    public Item(String name, String usageText) {
        this.name = name;
        this.usageText = usageText;
    }
}
