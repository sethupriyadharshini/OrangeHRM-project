package assignmentThird;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Create a list of numbers 33,44,55,66,77,88 and perform below operation
	Remove second element from list using index
	Remove second element from list using value
	Add 90 at index 3
	Get the length of list
	Print all values from list using any values
	Convert List into array.
 */

public class OperationsInList {

	public static void main(String[] args) {
		//List<Integer> list = Arrays.asList(33,44,55,66,77,88);
		List<Integer> list = new ArrayList<Integer>();
		list.add(33);
		list.add(44);
		list.add(55);
		list.add(66);
		list.add(77);
		list.add(88);
		
		System.out.println(list);
		list.remove(2);
		//list.remove(55);
		list.add(3,90);
		System.out.println(list.size());
		System.out.println(list);
		for(Integer i:list)
		{
			System.out.println(i);
		}
		

	}

}
