package assignmentThird;

import java.util.ArrayList;
import java.util.List;

/*
 * Write a program which will print sum of all numbers which is stored in list.
 */

public class SumAllNumbersList {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		int sum=0;
		
		for(Integer i :list)
		{
			sum +=i;
		}
		System.out.println("Total = " +sum);
	}

}
