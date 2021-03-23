
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

    /**
     * Compares the value of this number with the passed number.
     * @param n The other number
     * @return {@code -1 || 0 || 1}, indicating the inequality result
     */
    public int compare(int n) 
    {
        if (number < n) 
            return -1;
        else if (number > n)
            return 1;

        return 0;
    }

    public boolean isOdd()
    {
        return number % 2 == 1;
    }

    public boolean isEven()
    {
        return !isOdd();
    }

    public int getLastDigit()
    {
        // Lecture: If 100s, (n % 10) or (n - int(n / 10) * 10)
        // a%b = a-b*floor(a/b)
        return number % 10;
    }

    public int getNumber()
    {
        return number;
    }
}
