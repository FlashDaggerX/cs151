import java.util.Random;

public class CarList 
{
    /** The capacity of the car list */
    private static final int CAPACITY = 100;

    private Car[] cars;
    /** The amount of cars that have been added in this instance. */
    private int addedCount;

    public CarList(Car[] cars)
    {
        this.cars = cars;
        this.addedCount = 0;
    }

    public void printList()
    {
        for (Car car : cars)
            System.out.println(car);
    }

    public void printListReversed()
    {
        for (int i = cars.length - 1; i >= 0; i--)
            System.out.println(cars[i]);
    }

    public boolean addCar(Car car)
    {
        if (isFull()) 
            return false;

        // Create a new array, equal to the current size plus one
        Car[] moreCars = new Car[cars.length + 1];
        int arrSize = moreCars.length - 1;
        
        // Copy all the elements of the current array, then set the last element.
        for (int i = 0; i < arrSize - 1 ; i++)
            moreCars[i] = cars[i];
        moreCars[arrSize] = car;

        // Use the new array.
        cars = moreCars;

        addedCount++;

        return true;
    }

    public Car getMostExpensiveCar()
    {
        Car curr = cars[0];

        for (Car car : cars)
            if (car.getPrice() > curr.getPrice())
                curr = car;
        
        return curr;
    }

    public int selectRandomYear()
    {
        // Select a random index using 'Random'
        int idx = new Random().nextInt(cars.length);
        
        return cars[idx].getYear();
    }

    public int countYear(int year)
    {
        int count = 0;

        for (Car car : cars)
            if (car.getYear() == year)
                count++;
        
        return count;
    }

    public boolean isFull()
    {
        return cars.length <= CAPACITY;
    }

    public boolean isEmpty()
    {
        return cars.length == 0;
    }

    public int getAddedCount()
    {
        return addedCount;
    }
}