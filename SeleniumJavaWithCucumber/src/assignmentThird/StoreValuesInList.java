package assignmentThird;

/*
 * Write a program which will pick the values from Array and Store them List.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StoreValuesInList {

	public static void main(String[] args) {
		String a[] = {"Red","Blue","Green"};
		//List<String> list = Arrays.asList(a);
		List<String> list = new ArrayList<String>();
		for(int i=0;i<a.length;i++)
		{
			list.add(a[i]);
		}
		//Collections.addAll(list,a);
		System.out.println(list);

	}

}
