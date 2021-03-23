
/**
 * This class lists out the characteristics of some of my favorite sandwiches.
 * 
 * @author Kyle Guarco
 */
public class Grinder
{
    private String name;
    private String bread;

    private int calories;

    private double price;

    /**
     * Creates a simple grinder. Just imagine how it tastes.
     * @param name
     * @param bread The type of bread used for the grinder.
     * @param calories
     * @param price
     */
    public Grinder(String name, String bread, int calories, double price)
    {
        this.name = name;
        this.bread = bread;

        this.calories = calories;

        this.price = price;
    }

    /**
     * Creates a sandwich with italian bread, because it's my favorite bread.
     * @param name
     * @param calories
     * @param price
     */
    public Grinder(String name, int calories, double price)
    {
        this(name, "Italian Herbs and Cheese", calories, price);
    }

    @Override
    public String toString() 
    {
        // The first string will print "Normal" or "Light"
        String weight = isLight() ? "Light" : "Normal";
        // The second string will print the name of the bread

        return String.format("%s %s Grinder \"%s\": \n\tCalories: %d\n\tPrice: $%.2f",
                weight, getBread(), getName(), getCalories(), getPrice());
    }

    /**
     * @return Is the grinder light on the calorie scale?
     */
    public boolean isLight()
    {
        return getCalories() < 120;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setBread(String bread) 
    {
        this.bread = bread;
    }

    public void setCalories(int calories) 
    {
        this.calories = calories;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    public String getName() 
    {
        return name;
    }

    public String getBread() 
    {
        return bread;
    }

    public int getCalories() 
    {
        return calories;
    }

    public double getPrice() 
    {
        return price;
    }
}
