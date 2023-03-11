package Assignment1;
public class SwapTwoNumbers {

    /*
    Task 1 – Write a program to swap two number. For example a=10 and b=20 output should be a=20 and b=10
    */
    public static void main(String[] args)
    {
        int a =10 , b= 20, c;
        System.out.println("Before swapping");
        System.out.println("a = " +a + " " +"b = " +b);
        c=a;
        a=b;
        b=c;
        System.out.println("After swapping");
        System.out.println("a = " +a + " " +"b = " +b);
    }
}
