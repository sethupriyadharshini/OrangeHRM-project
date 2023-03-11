package Assignment1;
public class FindNumber {
    /*
    Task 9- Write a program which will break the current execution if it find number 85
	Input – [12,34,66,85,900]
     */
    public static void main(String[] args)
    {
        int a[] ={12,34,66,85,900};
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==85)
                break;
            System.out.println(a[i]);
        }
    }
}
