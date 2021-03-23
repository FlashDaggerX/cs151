public class DoTest
{
    public static void main(String[] args)
    {
        Test tp1 = new Test();
        Test tp2 = new Test();

        String s = "+++";
        int x = 22;

        System.out.println( tp1.add(x, s, tp2) );

        System.out.println(s);
    }   
}

class Test								
{
    public int a = 10;
    public String add(int n, String s, Test tp)
    {
        tp.a = --n;
        s = n + 3 + s + tp.a;
        return s;
    }
}
