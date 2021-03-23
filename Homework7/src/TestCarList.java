public class TestCarList 
{
    public static void main(String[] args) 
    {
        CarListScanner file = new CarListScanner("carList.txt");
        
        // Parse the car file and close it.
        CarList cars = new CarList(file.parse());
        file.close();

        if (cars.isEmpty()) 
            System.exit(-3);

        cars.printList();
        //System.out.println("Reverse! Reverse!");
        //cars.printListReversed();

        System.out.println("Most expensive car: " + cars.getMostExpensiveCar());

        int randYear = cars.selectRandomYear();
        System.out.println("Cars from the year " + randYear + ": " + cars.countYear(randYear));
    }
}