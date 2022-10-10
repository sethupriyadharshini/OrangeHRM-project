package Assignment1;
public class SumofNumbers {
    /*
    Task 2-  Write a program to print the sum of below 5 numbers.
	10,90.78,111,8989,7876
    * */
    public static void main(String[] args)
    {
        double b = 0.0;
        double a[] = {10, 90.78, 111, 8989, 7876};
        for(int i=0;i<a.length;i++)
        {
            b+=a[i];
        }
        System.out.println("Sum of given values : "+b);
    }
}
