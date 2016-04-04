package nl.kevinvanrossum;

/**
 * Created by Kevin van Rossum on 4-4-2016.
 *
 * @author Kevin van Rossum
 * @version 1.0
 */
class Game {

    /**
     * Instance variables
     *
     */
    private Player player;
    private Room[] rooms;

    /**
     * Game constructor method
     *
     */
    Game() {
        // Initialize everything I need:
        // The player, the rooms, items I want in the rooms
        // then call the run() method
    }


    /**
     * Run the game
     *
     */
    private void run() {
        try {
            // As long as the command isn't to quit:
            // get the next input line and handle it. (handleCommand())
        } catch (Exception e) {
            // Something went wrong, inform the user
        }
    }


    /**
     * Method to handle the userInput
     * @param userInput "use stick" has "use" as command and "stick as extra information
     *
     */
    private void handleCommand(String userInput) {
        // Split the user input string.
        // The first word is a command. The rest is extra information

        // Check if the command is to travel between rooms. If so, handle
        // the room travelling using the method: checkRoomTravel()

        // If there isn't any room travel, then check all other command options.
        // Using a switch over the command string.
        // Depending on the command, you might also need the extra information.
        // e.g. "use stick" has "use" as command and "stick as extra information
    }


    /**
     * Handle the use command
     * @param itemName Item in Player.items or Room.items
     *
     */
    private void handleUseCommand(String itemName) {
        // Check if the player has the item in his backpack.
        // If in the backpack: use it
        // If not in the backpack: check if in the room
        // If the item is in the room: use it.
        // If no item with that name is present: tell the user he's
        // trying to use something that isn't there.
    }


    /**
     * Handle the drop command
     * @param itemName Item in Player.items
     *
     */
    private void handleDropCommand(String itemName) {
        // Check if the item is in the backpack.
        // If so: remove the item from the backpack and put it
        // in the room
        // If not: tell the player he can't drop that.
    }


    /**
     * Handle the get command
     * @param itemName Item in Room.items
     *
     */
    private void handleGetCommand(String itemName) {
        // Check if the item is in the room.
        // If so: remove the item from the room and put it
        // in the backpack
        // If not: tell the player he can't get that.
    }


    /**
     * Handle the pack command
     *
     */
    private void handlePackCommand() {
        // Show a list Player.items
    }


    /**
     * Handle the help command
     *
     */
    private void handleHelpCommand() {
        // Show a list of available commands
    }


    /**
     * Handle the look command
     */
    private void handleLookCommand() {
        // Show a list of Room.items and all the exits in the room
    }


    private void handleQuitCommand() {
        // Quit the game
    }


    /**
     * Check if and travel to another room
     * @param command e.g. "go east"
     * @return boolean hasTravelled
     *
     */
    private boolean checkRoomTravel(String command) {
        // Get the currentRoom from the player and check if this room
        // has an exit in the direcetion of command(East, South,
        // North, West)
        // If there is an exit in that direction, ask the currentRoom
        // to get that room.
        // Tell the player to travel to the destination room.
        // If there is no exit in that direction, tell the player.
        // If travel was successful, return true. If not, return false

        return false;
    }




}
