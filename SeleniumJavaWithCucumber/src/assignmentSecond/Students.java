package assignmentSecond;

import java.util.Scanner;

/*Task 3 – Create a program which will store students information and print the output.
Program should ask how many students information you want to store. 
For each students it should ask name, email, phone, address, status
Once all entries are done, program should ask which user information you want to fetch and should print the same.
Note- Use scanner class for dynamic students
*/

public class Students {

	public static void main(String[] args) {
		int m,n,o;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter number of students : ");
		m = sc.nextInt();
		System.out.println("Please enter number of rows : ");
		n = sc.nextInt();
		System.out.println("Please enter number of columns : ");
		o = sc.nextInt();
		Object t[][][]=new Object[m][n][o];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				int k = 0;
				while(k <o)
				{
					System.out.println("Please enter name : ");
					t[i][j][k]=sc.next();
					k++;
					System.out.println("Please enter email : ");
					t[i][j][k] = sc.next();
					k++;
					System.out.println("Please enter address : ");
					t[i][j][k] = sc.next();
					k++;
					System.out.println("Please enter status : ");
					t[i][j][k] = sc.next();
					k++;
					System.out.println("Please enter phone number : ");
					t[i][j][k] = sc.nextInt();
					k++;
				}
			}
		}
		
		System.out.println("Please enter which student details are you looking for : ");
		int s;
		s=sc.nextInt();
		for(int i=s;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				for(int k=0;k<o;k++)
				{
					System.out.print(t[i][j][k]+ " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

}
