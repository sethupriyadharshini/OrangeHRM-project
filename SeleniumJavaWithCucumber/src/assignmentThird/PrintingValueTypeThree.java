package assignmentThird;

/*
 * Write a program which can store List of Integer values and print all the values using for iterator
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrintingValueTypeThree {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list);
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
	}

}
