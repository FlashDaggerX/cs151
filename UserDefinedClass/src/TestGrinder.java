
/**
 * Makes a bunch of grinders. iT MAKES ME SO HUNGRY THAT I BROKE
 * MY CAPS LOCK :(
 * 
 * @author Kyle Guarco
 */
public class TestGrinder
{
    public static void main(String[] args) 
    {
        Grinder plainHam = new Grinder("Plain Ham", 270, 2.75);
        Grinder muchHam = new Grinder("Lot$ o' H@m", 270*2, 2.75*2);
        Grinder pepperBread = new Grinder("Plain Ham", "Pepper Bread", 110, 1.50);

        System.out.println(plainHam);
        System.out.println(muchHam);
        System.out.println(pepperBread);
    }
}
