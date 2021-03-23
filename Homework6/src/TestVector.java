public class TestVector
{
    public static void main(String[] args) 
    {
        // Create a Vector3 out of random numbers.
        Vector3 rvec = new Vector3(Math.random(), Math.random(), Math.random());

        Vector3 vec1 = new Vector3(1d, 1d, 1d);
        Vector3 vec2 = new Vector3(2d, 2d, 2d);
        Vector3 vec3 = new Vector3(3d, 3d, 3d);

        System.out.println("\nvec1: " + vec1);
        System.out.println("vec2: " + vec2);
        System.out.println("vec3: " + vec3);

        System.out.println("\nvec1 + vec3 = " + vec1.add(vec3));
        System.out.println("vec2 * vec3 = " + vec2.mul(vec3));
        System.out.println("vec2 - vec1 = " + vec2.sub(vec1));

        // Interestingly enough, any double divided by a zero "as double" (0d or 0.0)
        // ends up being infinite, instead of throwing an exception.

        // Result should be Vector3(Infinity, Infinity, Infinity)
        System.out.println("\nDividing by zero: " + rvec.div(Vector3.ZERO));
    }
}