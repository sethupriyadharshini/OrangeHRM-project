package Assignment1;
public class OddNumbers {
    /*
     * Task 5- Write a program to print all odd numbers from 1-50
     * */
    public static void main(String[] args)
    {
        System.out.println("Odd numbers");
        for(int i=1;i<=50;i++)
        {
            if(i%2!=0)
                System.out.println(i);
        }
    }
}
