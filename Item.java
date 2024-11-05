
/**
 * Item information 
 *
 * @author Leslie Acevedo
 * @version 2024.11.05
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String description;
    private int weight;
    private boolean edible;

    /**
     * Constructor for objects of class item
     */
    public Item(String description, int weight, boolean edible)
    {
        // initialise instance variables
        this.description = description; 
        this.weight = weight;
        this.edible = edible;
    }

    //@return 
    public String getDescription()
    {
        return description;
    }
    
    //@return
    public int getWeight()
    {
        return weight;
    }
    
    //@return 
    public boolean isEdible()
    {
        return edible;
    }
}
