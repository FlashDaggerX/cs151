public final class Vector2
{
    public static final Vector2 ZERO = new Vector2(0, 0);

    /* The constant values of the vector. */
    public final int x, y;

    public Vector2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
        return String.format("Vector2(%d, %d)", x, y);
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Vector2))
            return false;
        
        Vector2 vec = (Vector2) o;

        return x == vec.x && y == vec.y;
    }

    /**
     * Compares the current vector with the passed vector's X value
     * @param p2
     * @return 
     *  {@code 1} if the passed vector is greater <p>
     *  {@code 0} if both vectors are equal <p>
     *  {@code -1} if the passed vector is lesser
     */
    public int compareX(Vector2 p2)
    {
        if (p2.x > x)
            return 1;
        else if (p2.x < x)
            return -1;
        
        return 0;
    }

    /**
     * Compares the current vector with the passed vector's Y value
     * @param p2
     * @return 
     *  {@code 1} if the passed vector is greater <p>
     *  {@code 0} if both vectors are equal <p>
     *  {@code -1} if the passed vector is lesser
     */
    public int compareY(Vector2 p2)
    {
        if (p2.y > y)
            return 1;
        else if (p2.y < y)
            return -1;
        
        return 0;
    }

    public int distance(Vector2 p2)
    {
        return (p2.y - y) / (p2.x - x);
    }

    public Vector2 add(Vector2 vec)
    {
        return new Vector2(vec.x + x, vec.y + x);
    }

    public Vector2 sub(Vector2 vec)
    {
        return new Vector2(vec.x - x, vec.y - x);
    }

    public Vector2 mul(Vector2 vec)
    {
        return new Vector2(vec.x * x, vec.y * y);
    }

    public Vector2 div(Vector2 vec)
    {
        return new Vector2(vec.x / x, vec.y / y);
    }
}
