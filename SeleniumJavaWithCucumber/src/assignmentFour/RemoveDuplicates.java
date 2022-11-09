package assignmentFour;

/*
 * Write a program that will remove duplicate values from List
Input – Java, TestNG, Maven, Java, 
Output – Java, TestNG, Maven

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {

	private static List<String> list;

	public static void main(String[] args) {
		list = Arrays.asList("Java","TestNG","Maven","Java");
		List<String> m = new ArrayList<String>();
		for(String l:list)
		{
			if(!m.contains(l))
			{
				m.add(l);
			}
		}
		System.out.println(m);

	}

}
