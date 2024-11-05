import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @ Leslie Acevedo
 * @version 2024.11.05
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<Item> items;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<Item>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        if (items.size() > 0){
            String output = "You are " + description + ".\n" + getExitString() +"\n";
            output.concat("Here you find: " + seeItems() + "\n");
            return output;  
        }
        return "You are " + description + ".\n" + getExitString() +"\n";
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    // add items 
    public void addItem(Item item)
    {
        items.add(item);
    }
    //@return string of all items 
    public String seeItems()
    {
        String output = "";
        for (Item item : items) {
            output = output.concat(item.getDescription() + " ");
        }
        return output;
    }
    // @return arraylist of all items 
    public ArrayList<Item> takeItems()
    {
        ArrayList<Item> output = new ArrayList<Item>();
        for (Item item : items) {
            output.add(item);
        }
        items.clear();
        return output;
    }

}

