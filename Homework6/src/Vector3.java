public class Vector3 {
    public static final Vector3 ZERO = new Vector3(0d, 0d, 0d);

    public final double x, y, z;
    
    public Vector3(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString()
    {
        return String.format("Vector3(%.3f, %.3f, %.3f)", x, y, z);
    }

    public Vector3 add(Vector3 vec)
    {  
        return new Vector3(x + vec.x, y + vec.y, z + vec.z);
    }

    public Vector3 sub(Vector3 vec)
    {
        return new Vector3(x - vec.x, y - vec.y, z - vec.z);
    }

    public Vector3 mul(Vector3 vec)
    {
        return new Vector3(x * vec.x, y * vec.y, z * vec.z);
    }

    public Vector3 div(Vector3 vec)
    {
        return new Vector3(x / vec.x, y / vec.y, z / vec.z);
    }
}