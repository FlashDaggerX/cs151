
/**
 * Functions that play with numbers.
 * 
 * @author Kyle Guarco
 */
public class NumberUtils
{
    private int number;

    public NumberUtils(int number)
    {
        this.number = number;
    }

    public NumberUtils()
    {
        this(0);
    }

    public boolean isOdd()
    {
        return number % 2 == 1;
    }

    public boolean isEven()
    {
        return !isOdd();
    }

    public void testAll()
    {
        // Perform the digit sum calculation beforehand.
        int digitSum = getDigitSum();
        
        String oddEven = isOdd() ? "Odd" : "Even";

        String result = String.format(
                "Number (%s): %d\n\tLast Digit: %d\n\tLast Digit, Stripped: %d\n\tDigit Sum: %d",
                oddEven, number, getLastDigit(number), stripLastDigit(number), digitSum);
        
        System.out.println(result);
    }

    private int getLastDigit(int n)
    {
        // Lecture: If 100s, (n % 10) or (n - int(n / 10) * 10)
        // a%b = a-b*floor(a/b)
        return n % 10;
    }

    private int stripLastDigit(int n)
    {
        // Lecture: If 100s, int(n / 10)
        return n / 10;
    }

    private int getDigitSum()
    {
        // Save a copy of the number instance for the calculation.
        int number = this.number;
        int sum = 0;

        // Strips the numbers off one by one, and adds up their sum.
        while (number > 0)
        {
            sum += getLastDigit(number);
            number = stripLastDigit(number);
        }

        return sum;
    }

    public void setNumber(int n)
    {
        this.number = n;
    }

    public int getNumber()
    {
        return number;
    }
}
