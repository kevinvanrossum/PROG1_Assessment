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

    Item(String name, String usageText, Boolean winning) {
        this.name = name;
        this.usageText = usageText;
        this.winning = winning;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsageText() {
        return usageText;
    }

    public void setUsageText(String usageText) {
        this.usageText = usageText;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean isWinning() {
        return winning;
    }

    public void setWinning(boolean winning) {
        this.winning = winning;
    }
}
