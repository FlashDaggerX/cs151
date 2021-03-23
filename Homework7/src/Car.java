public class Car 
{
    private String plate, make, model;
    private int year, price;

    public Car(String plate, String make, String model, int year, int price)
    {
        this.plate = plate;
        this.make = make;
        this.model = model;

        this.year = year;
        this.price = price;
    }

    @Override
    public String toString()
    {
        return String.format("PLATE %s\n\tMake & Model: %s %s\n\tYear: %d\n\tPrice: %d\n",
                plate, make, model, year, price);
    }

    public String getPlate()
    {
        return plate;
    }

    public String getMake()
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }

    public int getYear() 
    {
        return year;
    }

    public int getPrice() 
    {
        return price;
    }
}