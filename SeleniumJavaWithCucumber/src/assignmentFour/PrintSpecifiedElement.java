package assignmentFour;

/*
 * Create a list of values and print the second element, second last element.
Input – 10,45, 90,45, 23, 90, 44
Output – 45,90
 */

import java.util.Arrays;
import java.util.List;

public class PrintSpecifiedElement {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10,45,90,45,23,90,44);
		int n = list.size();
		System.out.println("size "+n);
		System.out.println(list.get(1));
		System.out.println(list.get(n-2));
		
	}

}
