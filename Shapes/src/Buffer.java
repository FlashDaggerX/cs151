/**
 * This is, what I will call, a text buffer. This class holds an array of empty
 * characters in memory. <p>
 * 
 * This class will have points passed to it, points that exist in the text
 * buffer. It will print those points into the text buffer using a specified
 * character to draw with. <p>
 * 
 * In addition, buffers can be drawn on top of other buffers! Just pass
 * a buffer to another buffer and all the points on it will be printed into
 * the other buffer instance. For example: {@code buffer.render(otherbuffer)}
 * will render {@code otherbuffer} onto {@code buffer}.
 * 
 * @author Kyle Guarco
 */
public final class Buffer implements Drawable
{
    /* The width and height of the buffer */
    private int width, height;
    /** The character that will be used to draw lines */
    private char draw;
    /** The buffer itself. This is where the characters will render. */
    private char[][] buffer;
    /** Used for the buffer drawing feature. */
    private Vector2[] points;

    public Buffer(char draw, int width, int height)
    {
        this.draw = draw;
        this.width = width;
        this.height = height;

        this.buffer = new char[height][width];

        // The buffer musn't be empty. This is so shapes can render properly.
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                buffer[y][x] = ' ';
    }

    public Buffer(char draw, Vector2 dimensions)
    {
        this(draw, dimensions.x, dimensions.y);
    }

    @Override
    public String toString()
    {
        // We need to properly convert each line of the 
        // buffer into a string for some reason.
        StringBuilder display = new StringBuilder();

        // Append each line of the text buffer to the final string
        for (int i = 0; i < height; i++)
            display.append(new String(buffer[i]) + '\n');

        return display.toString();
    }

    @Override
    public Vector2[] draw(Buffer buffer)
    {
        // Avoid a NullPointerException by just creating an empty array.
        if (points == null)
            return new Vector2[0];
        
        // If the width or height of the buffer are larger, don't draw
        if (width < buffer.getWidth() || height < buffer.getHeight())
            return new Vector2[0];

        return points;
    }

    /**
     * This function draws characters at all the specified points.
     * 
     * This doesn't return anything, but instead accesses the buffer directly.
     * 
     * @param drawable Any drawable element
     * @param x_ofs
     * @param y_ofs
     */
    public void render(Drawable drawable, int x_ofs, int y_ofs) 
    {
        this.points = drawable.draw(this);

        for (Vector2 point : points)
            try {
                buffer[point.y + y_ofs][point.x + x_ofs] = draw;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR: Can't Draw " + point);
            }
    }

    /**
     * This function draws characters at all the specified points.
     * This doesn't return anything, but instead accesses the buffer directly.
     * 
     * @param drawable Any drawable element
     */
    public void render(Drawable drawable)
    {
        render(drawable, 0, 0);
    }

    /** @return The width, not accounting for the newline at the end */
    public int getWidth()
    {
        return width - 1;
    }

    /** @return The height of the buffer */
    public int getHeight()
    {
        return height - 1;
    }
}
