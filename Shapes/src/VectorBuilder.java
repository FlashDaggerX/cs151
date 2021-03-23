import java.util.ArrayList;

/**
 * This class uses the builder pattern to construct an array of points.
 * 
 * @author Kyle Guarco
 */
public class VectorBuilder
{
    private ArrayList<Vector2> points;

    public VectorBuilder()
    {
        this.points = new ArrayList<>();
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();

        for (Vector2 point : points)
            result.append(point.toString() + '\n');
        
        return result.toString();
    }

    public VectorBuilder plot(Vector2 vec)
    {
        points.add(vec);

        return this;
    }

    public VectorBuilder plot(int x, int y)
    {
        points.add(new Vector2(x, y));

        return this;
    }

    public VectorBuilder merge(VectorBuilder... builders)
    {
        for (VectorBuilder builder : builders)
            for (Vector2 vec : builder.points())
                plot(vec);

        return this;
    }

    public Vector2[] points()
    {
        return points.toArray(new Vector2[points.size()]);
    }
}
