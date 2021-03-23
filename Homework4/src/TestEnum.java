public class TestEnum
{
    enum Fruit
    {
        APPLE, PEACH, BANNANA
    }

    public static void main(String[] args) 
    {
        printFruitEnum(Fruit.APPLE);
        printFruitEnum(Fruit.PEACH);
        printFruitEnum(Fruit.BANNANA);
    }

    public static void printFruitEnum(Fruit fruit)
    {
        String name = fruit.name();

        System.out.println(name);
        System.out.println(name + "'s ordinal(): " + fruit.ordinal());
        System.out.println(name + "'s toString(): " + fruit);
        System.out.println();
    }
}