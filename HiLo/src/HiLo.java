import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * HiLo: The number-randomizer guessing game!
 * 
 * @author Kyle Guarco
 */
public class HiLo
{
    public static void main(String[] args) 
    {
        // Declare the guess prompt here, it's read much nicer.
        final String GUESS_PROMPT = "\nEnter a number between 1 and " + NumberGame.GAME_MAX + ": ";
        // The prompt for playing again
        final String AGAIN_PROMPT = "Would you like to play again (y/n)? ";
        // The error that's printed when something other than a number is entered.
        final String ERROR_STATEM = "That's not a valid integer!";
        // Prints when the user gets the number right!
        final String CONGR_STATEM = "Congratulations! You got it right! The answer was ";
        
        // Read from standard input
        Scanner stdin = new Scanner(System.in);

        while (true)
        {
            // Create a new number randomizer instance.
            NumberGame game = new NumberGame();

            // Give the initial guess a value
            int guess = NumberGame.SKIP_INT;

            // Play the game!
            game.printHint();
            do {
                // Tells the user whether their guess should be higher or lower.
                game.printOrder(guess);

                System.out.print(GUESS_PROMPT);

                try {
                    guess = stdin.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_STATEM);
                    // nextInt() doesn't skip over invalid input, so invoke next()
                    stdin.next();
                    continue;
                }

                // Quit the program silently if the guess is -1
                if (guess == NumberGame.SKIP_INT) System.exit(0);
            } while (!game.isCorrect(guess));

            // Congratulate the user
            System.out.println(CONGR_STATEM + guess);

            // Ask the user to play again?
            System.out.print(AGAIN_PROMPT);
            // If 'n' is typed, quit the game.
            if (stdin.next().equalsIgnoreCase("n")) 
                break;
        }

        // Free system resources
        stdin.close();
    }
}
