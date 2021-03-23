public class TestGrinder
{
    public static void main(String[] args) 
    {
        Grinder g1 = new Grinder("Lotta Ham", 260, 5d);
        Grinder g2 = new Grinder("No Ham", 120, 3.65);
        Grinder g3 = new Grinder("Turkey", 380, 5.58);

        compare(g1, g2);
        compare(g2, g3);
        compare(g1, g3);
    }

    /** Compares the prices and calories of two grinders. */
    public static void compare(Grinder c1, Grinder c2)
    {
        String pResult = "", cResult = "";

        switch (c1.comparePrice(c2))
        {
            case -1: pResult = "is less expensive than";
                break;
            case 0: pResult = "is just as expensive than";
                break;
            case 1: pResult = "is more expensive than";
                break;
        }

        switch (c1.compareCalories(c2))
        {
            case -1: cResult = "isn't as heavy as";
                break;
            case 0: cResult = "is just as heavy as";
                break;
            case 1: cResult = "is heavier than";
                break;
        }

        System.out.printf("%s %s %s\n", c1.getName(), pResult, c2.getName());
        System.out.printf("%s %s %s\n", c1.getName(), cResult, c2.getName());
    }
}
