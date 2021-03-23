/**
 * 
 */
public interface Comparable
{
    /**
     * Compares prices with the specified grinder.
     * @param grinder The sandwich to check prices against
     * @return
     *  {@code -1} if the price of {@code grinder} is more than this one <p>
     *  {@code 0} if the prices are equal <p>
     *  {@code 1} if the price of {@code grinder} is less than this one
     */
    int comparePrice(Grinder grinder);
    
    /**
     * Compares the amount of calories with the specified grinder.
     * @param grinder The sandwich to check calories against
     * @return
     *  {@code -1} if the calories in {@code grinder} is more than this one <p>
     *  {@code 0} if the calorie count is equal <p>
     *  {@code 1} if the calories in {@code grinder} is less than this one
     */
    int compareCalories(Grinder grinder);
}
