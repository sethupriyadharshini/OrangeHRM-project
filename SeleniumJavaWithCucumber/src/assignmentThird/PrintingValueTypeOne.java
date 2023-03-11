package assignmentThird;

import java.util.ArrayList;
import java.util.List;

/* Write a program which can store List of Integer values and print all the values using for loop.*/

public class PrintingValueTypeOne {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list);
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
		
	}

}
