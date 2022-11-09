package assignmentThird;

/*
 * Write a program which will display true if list contains Mobile else prints false
	List  - Web Automation, API Automation, Mobile Automation.
	Output – True 

 */

import java.util.Arrays;
import java.util.List;

public class UsingContainsMethod {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Web Automation", "API Automation", "Mobile Automation");
		for(String i:list)
		{
			if(i.contains("Mobile"))
			{
				System.out.println("True");
			}
			else
			{
				System.out.println("False");
			}
				
		}				
	}

}
