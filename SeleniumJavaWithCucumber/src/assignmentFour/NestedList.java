package assignmentFour;

/*
 * Create a list which can accept another list as an element.
           List 1- 11,22,33
	    List 2-  9,19,29	
	    List 3-  7,17,27
  	Hint - ArrayList<ArrayList<Integer>> l1=new ArrayList<>(); 	
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestedList {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(11,22,33);
		List<Integer> list2 = Arrays.asList(9,19,29);
		List<Integer> list3 = Arrays.asList(7,17,27);
		ArrayList<Integer> l1=new ArrayList<Integer>();
		l1.addAll(list1);
		l1.addAll(list2);
		l1.addAll(list3);
		System.out.println(l1);
	}

}
