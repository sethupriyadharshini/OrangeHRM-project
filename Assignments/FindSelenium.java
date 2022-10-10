package Assignment1;
public class FindSelenium {
    /*
   Task 10- Write a program which will break the current execution if it find “Selenium”
	Input – [“Java”,”JavaScript”,”Selenium”,”Python”,”Mukesh”]

     */
    public static void main(String[] args)
    {
        String name[] ={"java", "javascript", "selenium", "python", "mukesh"};
        for(int i=0;i< name.length;i++)
        {
            if(name[i]=="selenium")
                break;
            System.out.println(name[i]);
        }
    }
}

