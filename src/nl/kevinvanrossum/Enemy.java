package nl.kevinvanrossum;

/**
 * Created by Kevin van Rossum on 11-4-2016.
 *
 * @author Kevin van Rossum
 * @version 1.0
 */
class Enemy {
    private String name;
    private String description;
    private int health;
    private Item[] items;

    Enemy(String name, String description, int health) {
        this.name = name;
        this.description = description;
        this.health = health;
    }

    String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }
}
