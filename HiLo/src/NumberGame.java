import java.util.Random;

/**
 * Functions that assist the user in determining the right number.
 * 
 * @author Kyle Guarco
 */
public class NumberGame
{
    /** The guessing range limit (nextInt limit) */
    public static final int GAME_MAX = 100;
    /** A special number that allows the program to skip over different prints. */
    public static final int SKIP_INT = -1;

    private Random rand;
    private NumberUtils utils;

    public NumberGame()
    {
        this.rand = new Random();
        
        // This will be the number that the user must guess.
        int number = rand.nextInt(NumberGame.GAME_MAX) + 1;

        // Contains the functions for retrieving information on the number.
        // Refer to Project 4 for the template.
        this.utils = new NumberUtils(number);
    }

    /** Prints out some information about the number. */
    public void printHint()
    {
        // It's like flipping a coin. Do we want to tell the user
        // the oddity of the number, or it's last digit?
        boolean chanceHint = rand.nextBoolean();

        String hint = "Last Digit: " + utils.getLastDigit();

        if (!chanceHint) {
            String oddEven = utils.isOdd() ? "Odd" : "Even";
            hint = "Oddity: " + oddEven;
        }
        
        System.out.println("Some information about the number:\n\t" + hint);
    }

    /** Tells the user whether they're closer to the answer or not. */
    public void printOrder(int guess)
    {
        // Don't print if the guess is -1
        if (guess == NumberGame.SKIP_INT) return;
        
        // Since we're checking to see if the guess is the right one
        // before calling this function, we only need to check two cases.
        int order = utils.compare(guess);

        // Is it higher (1), or lower (-1)?
        String height = order == 1 ? "higher" : "lower";

        System.out.println("Your guess should be " + height + ".");
    }

    /** Checks to see if the guess is correct (compare(guess) == 0) */
    public boolean isCorrect(int guess)
    {
        return utils.compare(guess) == 0;
    }
}
