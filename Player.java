import java.util.ArrayList;
/**
 * Player class.
 *
 * @author Leslie Acevedo
 * @version 2024.11.05
 */
public class Player
{
    // instance variables - replace the example below with your own
    private ArrayList<Item> inventory;
    private int totalWeight;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
        inventory = new ArrayList<Item>();
        totalWeight = 0;
    }
    
    //player inventory 
    public void showInventory()
    {
        System.out.println("You are carrying:");
        if (inventory.size() == 0) {
            System.out.println("nothing");
            return;
        }
        for (Item item : inventory) {
            System.out.println(item.getDescription() + " ");
        }
        System.out.println("\nTotal weight: " + totalWeight);
    }
    // @param items to eat 
    // @return 
    public boolean eat(String thingToEat) {
        if (thingToEat.equals("")) {
            System.out.println("Eat what?");
            return false;
        }
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getDescription().equals(thingToEat)) {
                System.out.println("You eat the" + thingToEat +".");
                if (inventory.get(i).isEdible()) {
                    totalWeight -= inventory.get(i).getWeight();
                    inventory.remove(i);
                    return false;
                }
                else {
                    System.out.println("This is not edible");
                    return true;
                }
            }
        }
        System.out.println("You do not have a" + thingToEat + ".");
        return false;
    }
    //@param roomitems arraylist 
    public void take(ArrayList<Item> roomItems)
    {
        if (roomItems.size() == 0) {
            System.out.println("There is nothing to take");
            return;
        }
        for (Item item : roomItems) {
            inventory.add(item);
            totalWeight += item.getWeight();
            System.out.println("You take the" + item.getDescription() + ".");
        }
    }
    //@param name of items 
    //@return name of items dropped 
    public Item drop(String name)
    {
        if (name == "" || name == null) {
            System.out.println("Drop what?");
            return null;
        }
        for (int i = 0; i <inventory.size(); i++) {
            if (inventory.get(i).getDescription().equals(name)) {
                totalWeight -= inventory.get(i).getWeight();
                System.out.println("You drop the" + name + ".");
                return inventory.remove(i);
            }
        }
        System.out.println("You do not have that!");
        return null;
    }
    //look for a item in inventory 
    public boolean find(String name)
    {
        if (name == "" || name == null) {
            return false;
        }
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getDescription().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
