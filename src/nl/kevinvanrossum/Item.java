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
     */
    private String name;
    private String usageText;
    private boolean winning;


    /**
     * Item constructor method
     *
     * @param name      Item name
     * @param usageText Text to display when using the use command
     */
    Item(String name, String usageText) {
        this.name = name;
        this.usageText = usageText;
    }

    /**
     * Item constructor method
     *
     * @param name      Item name
     * @param usageText Text to display when using the use command
     * @param winning   Is the item that ends the game
     */
    Item(String name, String usageText, Boolean winning) {
        this.name = name;
        this.usageText = usageText;
        this.winning = winning;
    }

    /**
     * Get the name of the Item
     *
     * @return Item name
     */
    String getName() {
        return name;
    }

    /**
     * Set the name of the Item
     *
     * @param name of the Item
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Get the usageText of the Item
     *
     * @return usageText of the Item
     */
    String getUsageText() {
        return usageText;
    }

    /**
     * @return Item.name
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Check if this Item ends the Game
     *
     * @return isWinning
     */
    boolean isWinning() {
        return winning;
    }

    void setWinning(boolean winning) {
        this.winning = winning;
    }
}
