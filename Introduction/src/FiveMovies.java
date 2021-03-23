
/**
 * Prints out the movies that I like, but not love.
 * 
 * @author Kyle Guarco
 */
public class FiveMovies 
{
    public static void main(String[] args) 
    {
        String[] movies = { 
            "Zombieland", "Night of The Living Dead", 
            "NGNL:Zero", "Zombieland 2", "Shaun of The Dead"
        };

        // Print every string in the 'movies' array
        for (String m : movies) System.out.println("> " + m);
    }
}
