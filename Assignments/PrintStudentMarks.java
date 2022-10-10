package Assignment1;
public class PrintStudentMarks {
    /*
    Task 8- Write a program to print below students marks who have scored above 80
	Example- 78,12,89,55,35
	Output-  78,89
     */
    public static void main(String[] args)
    {
        int a[] = {78,12,89,55,35};
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>80)
                System.out.println(a[i]);
        }
    }
}
