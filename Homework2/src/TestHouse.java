public class TestHouse
{
    public static void main(String[] args) 
    {
        // Should print out zero.
        System.out.printf("House count before instancing: %d\n", House.getCount());

        // Instance the house class five times
        for (int i = 0; i < 5; i++)
            // This class has members that we won't put to use for
            // some reason. Just create the instances and discard them.
            new House("", "", 0, 0);

        // Should print out five.
        System.out.printf("House count after instancing: %d\n", House.getCount());
    }
}
