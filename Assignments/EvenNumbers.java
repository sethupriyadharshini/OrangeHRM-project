package Assignment1;
public class EvenNumbers {
    /*
     * Task 4- Write a program to print all even numbers from 1-200
     * */
    public static void main(String[] args)
    {
        System.out.println("Even numbers");
        for(int i=1;i<=200;i++)
        {
            if(i%2==0)
                System.out.println(i);
        }
    }
}

