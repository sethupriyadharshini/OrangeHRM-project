package assignmentFour;

/*
 * Write a program which will accept List of String and produce another List of string of which will have only values which starts with git
Input – Git, Github, GitLab,GitBash, Selenium, Java, Maven
Output- Git, Github, Gitlab, GitBash

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GitOutput {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Git","Github","Gitlab","GitBash","Selenium","Java","Maven");
		List<String> git_list = new ArrayList<String>();
		for(String l:list)
		{
			if(l.contains("Git"))
			{
				git_list.add(l);
			}
		}
		System.out.println("Output of git values : "+git_list);
	}

}
