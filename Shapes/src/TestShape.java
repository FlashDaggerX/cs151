import java.util.Scanner;

public class TestShape
{
    public static void main(String[] args) 
    {
        Scanner stdin = new Scanner(System.in);

        // Ask the user to enter the size of all the buffers.
        System.out.print("Enter the size of the shapes: ");
        int size = stdin.nextInt();
        
        // We'll just use one buffer object for the sake of memory, OK?
        Buffer buffer;
        
        // Make an hourglass appear!
        buffer = new Buffer('^', size, size);
        buffer.render(new Hourglass());
        System.out.println(buffer);

        /*
        // Make a square appear!
        buffer = new Buffer('*', size, size);
        buffer.render(new Square());
        System.out.println(buffer);

        // Make a slightly slanted square appear!
        buffer = new Buffer('?', size * 2, size);
        buffer.render(new SlantRight());
        System.out.println(buffer);

        buffer = new Buffer('^', size * 2, size);
        buffer.render(new Triangle());
        System.out.println(buffer);
        */
        
        stdin.close();
    }
}

class Hourglass implements Drawable
{
    @Override
    public Vector2[] draw(Buffer buffer) 
    {
        int width = buffer.getWidth(), height = buffer.getHeight();
        
        VectorBuilder line_1 = new VectorBuilder()
            .plot(Vector2.ZERO)
            .plot(width, height);
        VectorBuilder line_2 = new VectorBuilder()
            .plot(0, height)
            .plot(width, 0);

        return connect(line_1.merge(line_2).points());
    }
}

class Square implements Drawable
{
    @Override
    public Vector2[] draw(Buffer buffer) 
    {
        int width = buffer.getWidth(), height = buffer.getHeight();

        return connect(new VectorBuilder()
            .plot(Vector2.ZERO)
            .plot(width, 0)
            .plot(width, height)
            .plot(0, height)
            .points());
    }
}

class SlantRight implements Drawable
{
    @Override
    public Vector2[] draw(Buffer buffer) 
    {
        int width = buffer.getWidth(), height = buffer.getHeight();
        int middle = width / 2;

        return connect(new VectorBuilder()
            .plot(middle, 0)
            .plot(width, 0)
            .plot(middle, height)
            .plot(0, height)
            .points());
    }
}

class Triangle implements Drawable
{
    @Override
    public Vector2[] draw(Buffer buffer) 
    {
        int width = buffer.getWidth(), height = buffer.getHeight();
        int middle = width / 2;

        return connect(new VectorBuilder()
            .plot(middle, 0)
            .plot(0, height)
            .plot(width, height)
            .points());
    }
}
