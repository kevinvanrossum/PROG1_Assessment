package nl.kevinvanrossum;

/**
 * Created by Kevin van Rossum on 11-4-2016.
 *
 * @author Kevin van Rossum
 * @version 1.0
 */
class Enemy {
    /**
     * Instance variables
     */
    private String name;
    private String description;
    private int hitpoints;
    private Item[] items;

    /**
     * Constructor Method
     *
     * @param name        of the Enemy
     * @param description of the Enemy
     * @param hitpoints   to kill the Enemy
     */
    Enemy(String name, String description, int hitpoints) {
        this.name = name;
        this.description = description;
        this.hitpoints = hitpoints;
    }

    /**
     * Get the name of the Enemy
     *
     * @return Enemy name
     */
    String getName() {
        return name;
    }

    /**
     * Get the description of the Enemy
     *
     * @return Enemy description
     */
    String getDescription() {
        return description;
    }

    /**
     * Decrease the hitPoints by 1 with every hit
     */
    void hit() {
        this.hitpoints--;
    }
}
