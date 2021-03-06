package nl.kevinvanrossum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Kevin van Rossum on 4-4-2016.
 *
 * @author Kevin van Rossum
 * @version 1.0
 */
class Game {

    /**
     * Instance variables
     */
    private Player player;
    private ArrayList<Room> rooms = new ArrayList<>();
    private boolean playing;

    /**
     * Game constructor method
     */
    Game() {
        // Initialize everything I need:
        // The player, the rooms, items I want in the rooms
        // then call the run() method

        // Create the player and his items
        player = new Player(0);
        player.addItem(new Item("Orc helm", "De helm valt van je hoofd, hij is 5 maten te groot"));

        // Create the rooms and its items
        rooms.add(new Room("Start kamer"));
        rooms.add(new Room("Tweede kamer"));
        rooms.add(new Room("Derde kamer"));
        rooms.add(new Room("Vierde kamer"));
        rooms.add(new Room("Vijfde kamer"));
        rooms.add(new Room("Zesde kamer"));
        rooms.add(new Room("Zevende kamer"));
        rooms.add(new Room("Achtste kamer"));
        rooms.add(new Room("Negende kamer"));
        rooms.add(new Room("Tiende kamer"));
        rooms.add(new Room("Elfde kamer"));
        rooms.add(new Room("Twaalfde kamer"));

        // Room items
        rooms.get(0).addItem(new Item("Brandend Zwaard", "Je zwaait wild met het zwaard in het rond, tot het doofde."));
        rooms.get(1).addItem(new Item("Tweehandig Zwaard", "Het zwaard gebruikt zijn handen om extra zwaarden vast te houden."));
        rooms.get(4).addItem(new Item("Vervloekt Amulet", "Het amulet begint te gloeien en wordt warm.", true));
        rooms.get(7).addItem(new Item("Supersnelleschoenen", "Je probeert de schoenen aan te trekken maar krijgt ze niet te pakken."));

        // Enemies
        rooms.get(1).setEnemy(new Enemy("Internet Troll", "Hij heeft geen speciale krachten en is daar boos om!", 1));
        rooms.get(11).setEnemy(new Enemy("Squidzilla", "De orginele japanse octopus", 5));

        // MAP of the game
        //  8--9--10-12
        //  |     |  |
        //  7  2--3--11
        //  |  |  |
        //  6 -1  4--5

        // Path to the final item
        rooms.get(0).addExit("North", rooms.get(1));
        rooms.get(1).addExit("South", rooms.get(0));
        rooms.get(1).addExit("East", rooms.get(2));
        rooms.get(2).addExit("West", rooms.get(1));
        rooms.get(2).addExit("South", rooms.get(3));
        rooms.get(3).addExit("North", rooms.get(2));
        rooms.get(3).addExit("East", rooms.get(4));
        rooms.get(4).addExit("West", rooms.get(3));

        // Rooms to get lost in
        rooms.get(0).addExit("West", rooms.get(5));
        rooms.get(5).addExit("East", rooms.get(0));
        rooms.get(5).addExit("North", rooms.get(6));
        rooms.get(6).addExit("South", rooms.get(5));
        rooms.get(6).addExit("North", rooms.get(7));
        rooms.get(7).addExit("South", rooms.get(6));
        rooms.get(7).addExit("East", rooms.get(8));
        rooms.get(8).addExit("West", rooms.get(7));
        rooms.get(8).addExit("East", rooms.get(9));
        rooms.get(9).addExit("West", rooms.get(8));
        rooms.get(9).addExit("South", rooms.get(2));
        rooms.get(2).addExit("North", rooms.get(9));
        rooms.get(9).addExit("East", rooms.get(11));
        rooms.get(11).addExit("West", rooms.get(9));
        rooms.get(11).addExit("South", rooms.get(10));
        rooms.get(10).addExit("North", rooms.get(11));
        rooms.get(10).addExit("West", rooms.get(2));
        rooms.get(2).addExit("East", rooms.get(10));

        // Run the game :)
        run();
    }


    /**
     * Run the game
     */
    private void run() {
        Scanner in = new Scanner(System.in);
        printIntro();
        printRoomInfo(player.getRoomNumber());

        try {
            // As long as the command isn't to quit:
            // get the next input line and handle it. (handleCommand())
            playing = true;
            while (playing) {
                System.out.println("\nVul hieronder een comando in:");
                handleCommand(in.nextLine());
            }

            // Game loop has stopped, exiting game
            in.close();
            System.exit(1);
        } catch (Exception e) {
            // Something went wrong, inform the user
            e.printStackTrace();
        }
    }


    /**
     * Method to handle the userInput
     *
     * @param userInput "use stick" has "use" as command and "stick as extra information
     */
    private void handleCommand(String userInput) {
        String command = "";
        String extraInfo = "";

        // Split the user input string at the first whitespace.
        // The first word is a command. The rest is extra information
        String[] splitInput = userInput.split(" ", 2);

        if (splitInput.length >= 1) {
            command = splitInput[0].trim().toLowerCase();
        }
        if (splitInput.length == 2) {
            extraInfo = splitInput[1].trim().toLowerCase();
        }

        // Check if the command is to travel between rooms. If so, handle
        // the room travelling using the method: checkRoomTravel()
        if (command.equals("go")) {
            checkRoomTravel(extraInfo);
            return;
        }

        // If there isn't any room travel, then check all other command options.
        // Using a switch over the command string.
        // Depending on the command, you might also need the extra information.
        // e.g. "use stick" has "use" as command and "stick as extra information
        switch (command) {
            case "quit":
                handleQuitCommand();
                break;
            case "use":
                handleUseCommand(extraInfo);
                break;
            case "drop":
                handleDropCommand(extraInfo);
                break;
            case "get":
                handleGetCommand(extraInfo);
                break;
            case "pack":
                handlePackCommand();
                break;
            case "help":
                handleHelpCommand();
                break;
            case "look":
                handleLookCommand();
                break;
            default:
                System.out.println("Onbekend commando\n");
                break;
        }
    }


    /**
     * Handle the use command
     *
     * @param itemName Item in Player.items or Room.items
     */
    private void handleUseCommand(String itemName) {
        Item item;
        Room currentRoom = rooms.get(player.getRoomNumber());

        // Check if the player has the item in his backpack.
        if (player.hasItem(itemName)) {
            // If in the backpack: use it
            item = player.getItem(itemName);
            useItem(item);
        }
        // If not in the backpack: check if in the room
        else if (currentRoom.hasItem(itemName)) {
            // If the item is in the room: use it.
            item = currentRoom.getItem(itemName);
            useItem(item);
        }
        else {
            // If no item with that name is present: tell the user he's
            // trying to use something that isn't there.
            System.out.println("Item is niet in de rugzak of kamer te vinden");
        }

    }

    /**
     * Use a given item
     * If the item is a winning item the has won
     * @param item from backpack or Room
     */
    private void useItem(Item item) {
        System.out.println(item.getName() + ": " + item.getUsageText());
        if (item.isWinning()) {
            System.out.println("Je hebt het winnende item gevonden");
            System.out.println("Het spel is afgelopen");
            playing = false;
        }
    }


    /**
     * Handle the drop command
     *
     * @param itemName Item in Player.items
     */
    private void handleDropCommand(String itemName) {
        // Check if the item is in the backpack.
        if (player.hasItem(itemName)) {
            // If so: remove the item from the backpack and put it
            // in the room
            Item dropItem = player.getItem(itemName);
            player.removeItem(dropItem);
            rooms.get(player.getRoomNumber()).addItem(dropItem);
            System.out.println(dropItem.getName() + " is in de kamer achter gelaten");
        }
        else {
            // If not: tell the player he can't drop that.
            System.out.println("Je hebt dit item niet in je rugzak");
        }
    }


    /**
     * Handle the get command
     *
     * @param itemName Item in Room.items
     */
    private void handleGetCommand(String itemName) {
        // Check if the item is in the room.
        Room currentRoom = rooms.get(player.getRoomNumber());
        if (currentRoom.hasItem(itemName)) {
            // If so: remove the item from the room and put it
            // in the backpack
            Item dropItem = currentRoom.getItem(itemName);
            currentRoom.removeItem(dropItem);
            player.addItem(dropItem);
            System.out.println(dropItem.getName() + " is in de rugzak gestopt");
        }
        else {
            // If not: tell the player he can't get that.
            System.out.println("Dit item ligt niet in deze kamer");
        }
    }


    /**
     * Handle the pack command
     * Print a list of items in backpack
     */
    private void handlePackCommand() {
        // Get all the items in the backpack
        ArrayList<Item> backpack = player.getItems();

        // If backpack is empty give a message
        printPackInfo(backpack);

    }

    /**
     * Handle the help command
     * Print a list of commands
     */
    private void handleHelpCommand() {
        // Show a list of available commands in console
        printHelpInfo();
    }


    /**
     * Handle the look command
     * Show a list of Room.items and all the exits in the room
     */
    private void handleLookCommand() {
        // Get the enemy, items and doors in the room
        HashMap<String, Item> roomItems = rooms.get(player.getRoomNumber()).getItems();
        HashMap<String, Room> roomExits = rooms.get(player.getRoomNumber()).getExits();
        Enemy roomEnemy = rooms.get(player.getRoomNumber()).getEnemy();

        // enemy
        printEnemyInfo(roomEnemy);

        // items
        printItemInfo(roomItems);

        // exits
        printRoomExits(roomExits);
    }

    /**
     * Handle the quit command
     * Set playing boolean to false to quit game loop
     */
    private void handleQuitCommand() {
        System.out.println("Spel afgesloten");
        playing = false;
    }


    /**
     * Check if and travel to another room
     *
     * @param command e.g. "go east"
     * @return boolean hasTravelled
     */
    private boolean checkRoomTravel(String command) {
        // Get the currentRoom from the player and check if this room
        // has an exit in the direction of command(East, South,
        // North, West)
        HashMap<String, Room> currentRoomExits = rooms.get(player.getRoomNumber()).getExits();

        // If there is an exit in that direction, ask the currentRoom
        // to get that room.
        // Tell the player to travel to the destination room.
        if (currentRoomExits.containsKey(command)) {
            player.setRoomNumber(rooms.indexOf(currentRoomExits.get(command)));
            printRoomInfo(player.getRoomNumber());
            return true;
        }

        // If there is no exit in that direction, tell the player.
        // If travel was successful, return true. If not, return false
        System.out.println("Geen uitgang in die richting, kijk nog eens goed.");
        return false;
    }


    /**
     * Print the intro screen of the game
     */
    private void printIntro() {
        String intro = "______                      _______   __      _                     \n" +
                "| ___ \\                    |  ___\\ \\ / /     | |                    \n" +
                "| |_/ /___   ___  _ __ ___ | |__  \\ V / _ __ | | ___  _ __ ___ _ __ \n" +
                "|    // _ \\ / _ \\| '_ ` _ \\|  __| /   \\| '_ \\| |/ _ \\| '__/ _ \\ '__|\n" +
                "| |\\ \\ (_) | (_) | | | | | | |___/ /^\\ \\ |_) | | (_) | | |  __/ |   \n" +
                "\\_| \\_\\___/ \\___/|_| |_| |_\\____/\\/   \\/ .__/|_|\\___/|_|  \\___|_|   \n" +
                "                                       | |                          \n" +
                "                                       |_|                          ";
        System.out.println(intro);
        System.out.println("Beweeg jezelf door het doolhof.");
        System.out.println("Je missie is het vinden van het vervloekt amulet");
        System.out.println("Succes!\n");
    }

    private void printRoomInfo(int roomNumber) {
        System.out.println("Je trapt de deur in en betreed de kamer");
        Room room = rooms.get(roomNumber);
        System.out.println(room.getDescription());
        handleLookCommand();
    }

    private void printRoomExits(HashMap<String, Room> roomExits) {
        if (roomExits.size() == 0) {
            System.out.println("De GM is vergeten een deur te plaatsen, je zit hier nu vast!");
        }
        else {
            System.out.println(roomExits.size() + " deuren in deze kamer:");
            roomExits.forEach((direction, room) -> System.out.println("- " + direction));
        }
    }

    private void printItemInfo(HashMap<String, Item> roomItems) {
        if (roomItems.size() == 0) {
            System.out.println("Geen items in deze kamer");
        }
        else {
            System.out.println(roomItems.size() + " items in deze kamer:");
            roomItems.forEach((itemName, item) -> System.out.println("- " + item.getName()));
        }
    }

    private void printEnemyInfo(Enemy roomEnemy) {
        if (roomEnemy != null) {
            System.out.println("Deze kamer bevat een vijand!");
            System.out.println("- " + roomEnemy.getName());
            System.out.println("  " + roomEnemy.getDescription());
        }
    }

    private void printHelpInfo() {
        System.out.println("go  {{richting}} - Ga door een deur in de gekozen richting.");
        System.out.println("    - go north, go south");
        System.out.println("use  {{item naam}} - Gebruik een item in de kamer of je rugzak.");
        System.out.println("    - use stok, use sleutel");
        System.out.println("get  {{item naam}} - Pak een item uit de kamer, leg hem in de rugzak.");
        System.out.println("    - get stok, get schild");
        System.out.println("drop {{item naam}} - Pak een item uit de rugzak, leg hem in de kamer.");
        System.out.println("    - drop stok, drop schild");
        System.out.println("look - Bekijk welke uitgangen en items in deze kamer zijn.");
        System.out.println("pack - Bekijk welke items in de rugzak zitten.");
        System.out.println("quit - Stop met spelen en sluit de game af.");
        System.out.println("help - Laat deze help informatie zien.");
    }

    private void printPackInfo(ArrayList<Item> backpack) {
        if (backpack.size() == 0) {
            System.out.println("Rugzak is leeg");
        }
        else {
            // Print backpack contents to console
            System.out.println(backpack.size() + " items in rugzak;");
            backpack.forEach(item -> System.out.println("- " + item.getName()));
        }
    }
}
