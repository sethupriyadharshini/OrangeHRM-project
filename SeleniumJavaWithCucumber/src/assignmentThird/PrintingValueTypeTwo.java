package assignmentThird;

/*
 * Write a program which can store List of Integer values and print all the values using for for loop.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingValueTypeTwo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		System.out.println("Enter Size of the List : ");
		int n,m;
		n=sc.nextInt();
		System.out.println("Enter Integer values for list : ");
		for(int i=0;i<n;i++)
		{
			m=sc.nextInt();
			list.add(m);
		}
		System.out.println(list);
		
		for(Integer l:list)
		{
			System.out.println(l);
		}
		
		sc.close();
		

	}

}
