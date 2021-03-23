import java.util.Scanner;

/**
 * This program converts different lengths into meters.
 * 
 * @author Kyle Guarco
 */
public class Metric 
{
    public static void main(String[] args) 
    {
        // These constants are used in conversions to meters.
        // ex: INCH = 0.0254 meters
        final double INCH = 0.0254;
        final double FOOT = 0.3048;
        final double YARD = 0.9144;
        final double MILE = 1609.3;

        // Query miles, yards, feet and inches from the user using standard input.
        Scanner stdin = new Scanner(System.in);
        double inches, feet, yards, miles;

        System.out.print("Inches? ");
        inches = stdin.nextDouble();

        System.out.print("Feet? ");
        feet = stdin.nextDouble();

        System.out.print("Yards? ");
        yards = stdin.nextDouble();

        System.out.print("Miles? ");
        miles = stdin.nextDouble();

        double totalMeters = (INCH * inches) + (FOOT * feet) + (YARD * yards) + (MILE * miles);

        // Format output string for legibility. "%f" is the format string for a floating point number.
        String outputTotal = String.format("%f inches + %f feet + %f yards + %f miles = %f meters",
                inches, feet, yards, miles, totalMeters);
        System.out.println(outputTotal);

        // Close 'stdin' to free up system resources.
        stdin.close();
    }
}
