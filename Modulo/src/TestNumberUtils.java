import java.util.Random;

/**
 * Plays with numbers, and program arguments.
 * 
 * @author Kyle Guarco
 */
public class TestNumberUtils
{
    public static void main(String[] args) 
    {
        // If there aren't two arguments, exit! They're important!
        if (args.length != 2) 
            errorOut();

        // Gets the second argument, and hope that it's a number. This is passed 
        // onto the later functions, and serves as either an exit condition or
        // a constant number.
        int number = Integer.parseInt(args[1]);

        // Try out a few arguments.
        switch (args[0])
        {
            case "--static":
                testStatic(number);
                break;
            case "--random":
                testRandomizer(number);
                break;
            default: 
                errorOut();
                break;
        }
    }

    /** This function is run when the '--static' case is provided */
    private static void testStatic(int number)
    {
        new NumberUtils(number).testAll();
    }

    /** This function is run when the '--random' case is provided */
    private static void testRandomizer(int repeats)
    {
        NumberUtils utils = new NumberUtils();
        Random generator = new Random();

        while (repeats != 0)
        {
            // Range: 1 - 199
            utils.setNumber(generator.nextInt(199) + 1);
            utils.testAll();

            // Decrement 'repeats' until it reaches zero.
            repeats--;
        }
    }

    /** Exits the program, obnoxiously. */
    private static void errorOut()
    {
        System.out.println("WRONG! ERROR! BAD! AWFUL!");
        System.exit(-1);
    }
}
