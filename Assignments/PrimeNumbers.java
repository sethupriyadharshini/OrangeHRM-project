package Assignment1;
public class PrimeNumbers {
    /*
     *Task 6- Write a program to print all prime numbers from 1-1000
     * */
    public static void main(String[] args)
    {
        for(int i=1;i<=1000;i++)
        {
            int counter = 0;
            for(int j=i;j>=1;j--)
            {
                if(i%j==0)
                {
                    counter+=1;
                }
            }
            if(counter==2)
            {
                System.out.println("PrimeNumbers : "+ i);
            }
        }
    }
}
