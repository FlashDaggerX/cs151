/**
 * Represents a house with its address and year it was built.
 * 
 * @author Kyle Guarco and Lazar Pevac
 */
public class House
{
    /** Gives a count of hown many times this class has been instanced. */
    private static int count = 0;

    /** @return The number of times this class has been instanced */
    public static int getCount()
    {
        return House.count;
    }

    private String street, town;
    private int number, year;

    public House(String street, String town, int number, int year)
    {
        this.street = street;
        this.town = town;
        this.number = number;
        this.year = year;

        House.count++;
    }

    @Override
    public String toString()
    {
        //number + " " + street + ", " + town + " built in " + year;
        return String.format("%d %s, %s built in %d", number, street, town, year);
    }

    public void setStreet(String str)
    {
        street = str;
    }

    public void setTown(String tn)
    {
        town = tn;
    }

    public void setNumber(int num)
    {
        number = num;
    }

    public void setYear(int y)
    {
        year = y;
    }

    public String getStreet()
    {
        return street;
    }

    public String getTown()
    {
        return town;
    }

    public int getNumber()
    {
        return number;
    }

    public int getYear()
    {
        return year;
    }

    public boolean isHistoric()
    {
        return 2020 - year > 50;
    }
}
