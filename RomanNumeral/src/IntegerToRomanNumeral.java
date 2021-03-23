/**
 * This class converts integers to roman numerals using a simple replacement
 * grammar
 * 
 * @author Joe Smith and Kyle Guarco
 */
public class IntegerToRomanNumeral
{
    /** The values of roman numerals {M, D, C, L, X, V, I} */
    private static final int[] VALUES = {1000, 500, 100, 50, 10, 5, 1};
    /** All the possible roman numeral characters. */
    private static final char[] CHARS = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

    /** The original number */
    private int number;
    /** The numeral before any rules were applied */
    private String rawNumeral;
    /** The roman numeral string */
    private String numeralString;

    public IntegerToRomanNumeral(int number)
    {
        this.number = number;
        this.rawNumeral = createRawRomanNumeral();
        this.numeralString = applyGrammarRules(rawNumeral);
    }

    private String applyGrammarRules(String numeral)
    {
        // Grammar Rules:
        // AAAA -> AB
        // BAB -> AC

        // Apply grammar rules to replace invalid roman numeral sequences.

        // This should iterate the list of valid characters three times.
        for (int j = CHARS.length - 1; j > 1; j -= 2)
        {
            char a = CHARS[j];
            char b = CHARS[j - 1];
            char c = CHARS[j - 2];

            // These are regex rules that replace a sequence of characters.
            
            // This rule follows the 'AAAA' pattern above
            String abRule = String.format("%s{4}+", a);
            String abReplacement = "" + a + b;

            // This rule follows the 'BAB' pattern above
            String acRule = String.format("%s%s%s", b, a, b);
            String acReplacement = "" + a + c;

            // Apply the rules.
            numeral = numeral.replaceFirst(abRule, abReplacement);
            numeral = numeral.replaceFirst(acRule, acReplacement);
        }

        return numeral;
    }

    /** @return A raw roman numeral. */
    private String createRawRomanNumeral()
    {
        // Invoke fillNumeralCounter() so we know how much of 
        // each character we need.
        int[] counter = fillNumeralCounter();

        // This will be the raw roman numeral.
        StringBuilder rawNumeral = new StringBuilder();

        // Begin writing the raw roman numeral representation.
        // counter.length == VALUES.length
        for (int i = 0; i < counter.length; i++)
        {
            char character = CHARS[i];
            int charCount = counter[i];

            while (charCount > 0)
            {
                rawNumeral.append(character);
                charCount--;
            }
        }

        return rawNumeral.toString();
    }

    /** @return A counter for all possible numeral values (how many M's, D's, etc...) */
    private int[] fillNumeralCounter()
    {
        // Create a counter that contains raw roman numerals.
        int[] counter = new int[VALUES.length];
        
        // Copy the original number so we can use it without changing its value.
        int number = this.number;

        // Start subtracting the values in descending order.
        int counterIndex = 0;
        for (int val : VALUES)
        {
            // Subtract the current value until you can't no more.
            while (number >= val)
            {
                number -= val;
                counter[counterIndex]++;
            }
            counterIndex++;
        }

        return counter;
    }

    public int getInteger()
    {
        return number;
    }

    public String getRawRomanNumeral()
    {
        return rawNumeral;
    }

    public String getRomanNumeral()
    {
        return numeralString;
    }
}
