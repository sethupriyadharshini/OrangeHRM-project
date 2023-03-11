
package assignmentFour;

/*
 * Create a list of String and print the values in reverse order
Input – Java, Selenium, TestNG, Git, Github
	Output- Github, Git, TestNG, Selenium, Java

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintReverse {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Java","Selenium","TestNG","Git","Github");
		List<String> outcome = new ArrayList<String>();
		for(int i=list.size()-1;i>=0;i--)
		{
			outcome.add(list.get(i));
		}
		System.out.println("Reverse order : "+outcome);
	}

}
