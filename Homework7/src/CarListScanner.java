import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Parses a file that contains a list of car makes and models. Supports comments!
 * 
 * @author Kyle Guarco 
 */
public class CarListScanner implements Closeable
{
    /** The comment delimiter for the file */
    private static final String COMMENT_CHAR = "#";
    /** Prints this comment to the top of the file if it doesn't exist. */
    private static final String COMMENT_INIT = "# Syntax: PLATE MAKE MODEL PRICE YEAR";

    private Scanner scanner;

    public CarListScanner(String fileName)
    {
        File file = new File(".", fileName);

        try {
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            // If the file isn't found, create the file and exit.
            createNewFile(file);
        }
    }

    @Override
    public void close()
    {
        scanner.close(); // May throw IOException
    }

    public Car[] parse()
    {
        ArrayList<Car> cars = new ArrayList<>();

        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();

            if (isComment(line)) continue;

            String[] args = line.split(" ");

            String  plate = args[0],
                    make = args[1],
                    model = args[2];
            int     price = Integer.parseInt(args[3]),
                    year = Integer.parseInt(args[4]);

            cars.add(new Car(plate, make, model, year, price));
        }

        return cars.toArray(new Car[cars.size()]);
    }

    private void createNewFile(File file)
    {
        try {
            file.createNewFile();

            // Write COMMENT_INIT to the file if it does not exist.
            PrintWriter write = new PrintWriter(file);
            write.println(COMMENT_INIT);
            write.close();

            // Close the program.
            System.err.println("The file \"" + file.getName() + "\" didn't exist, but was just created. Exiting...");
            System.exit(-1);
        } catch (IOException e) {
            System.err.println("Some weird error occurec here: \n" + e.getStackTrace());
            System.exit(-2);
        }
    }

    private boolean isComment(String line)
    {
        return line.startsWith(COMMENT_CHAR);
    }
}