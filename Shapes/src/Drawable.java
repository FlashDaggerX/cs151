/**
 * This interface allows for the implementation of drawable elements
 * onto a {@code Buffer}. Anything that implements this interface can
 * be drawn, as long as it has points to draw.
 * 
 * @author Kyle Guarco
 */
public interface Drawable
{
    /**
     * Called by the buffer, and passes itself to the shape, so that
     * it may properly draw itself.
     * 
     * @param buffer The buffer instance
     * @return The points that are to be printed into the buffer
     */
    Vector2[] draw(Buffer buffer);

    /**
     * A helper function for drawables. Allows for the connection
     * of verticies, creating shapes that have sides!
     * 
     * @param verticies The verticies for the shape
     * @return All the points required for drawing
     */
    default Vector2[] connect(Vector2[] verticies)
    {
        VectorBuilder points = new VectorBuilder();

        for (int i = 0; i < verticies.length; i++)
        {
            boolean looping = i + 1 == verticies.length;

            Vector2 p1 = verticies[i];
            // If 'i' is already maxed, use the first point
            // to finish the connection
            Vector2 p2 = looping ? 
                verticies[0] :
                verticies[i + 1];

            // Usually, when you're drawing lines on a graph, you'd calculate 
            // the slope and find all the points that way. However, this isn't 
            // a real graph. We need to find both the X and Y distance from 
            // the second vector.

            // Also, negatives shouldn't exist!

            points.plot(p1);

            while (true)
            {
                // Since this isn't a real graph, we need to plot the
                // points on it a different way. Compare X and Y and take
                // the comparison's integer representation (-1, 0, 1) and keep
                // adding that on to the vector until it is equal with p2. 
                int dX = p1.compareX(p2);
                int dY = p1.compareY(p2);

                // Add dX (difference in X) and dY to the current vector
                p1 = new Vector2(p1.x + dX, p1.y + dY);
                points.plot(p1);

                // When dX and dY are 0, it means that both points are
                // even with each other. This line has finished drawing!
                if (dX == 0 && dY == 0)
                    break;
            }

            points.plot(p2);
        }

        return points.points();
    }
}
