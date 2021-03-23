/**
 * This program uses a replacement grammar technique to build
 * valid roman numerals.
 * 
 * @author Joe Smith and Kyle Guarco
 */
public class RNTest
{
    public static void main(String[] args) 
    {
        int number = 1;

        if (args.length == 1)
        {  
            try {
                // If there's an argument, use that as the number.
                number = Integer.parseInt(args[0]);

                if (number < 1 || number > 3999)
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Either that's not a number, or it isn't between 1 and 3999.");
                System.exit(-1);
            }
        } else 
            // If there's no arguments, choose a random number between 1 and 3999
            number = (int)(Math.random() * 4000d);

        IntegerToRomanNumeral numeral = new IntegerToRomanNumeral(number);

        // Print out the roman numeral
        String result = String.format("Number: %d\n\tRaw Roman Numeral: %s\n\tReal Roman Numeral: %s",
                number, numeral.getRawRomanNumeral(), numeral.getRomanNumeral());

        System.out.println(result);

        // To test out these solutions, look up "roman numeral converter"
        // To learn more about regex, look up "regex tester" and use the PHP flavor
    }
}
