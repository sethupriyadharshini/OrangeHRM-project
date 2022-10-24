package assignmentSecond;

/*
 * Task 1- Create a class name as “Trainer” which will have 4 fields name, department ,  email, id. 
 * Trainer can teach Selenium, DevOps, Web Development.
	Note- use method, constructor 

Trainer details are 
Trainer 1 – “Mukesh” ,”Testing”,mukesh@gmail.com, 1
Trainer 2 – “Hitesh” ,”Dev”,mukesh@gmail.com, 2
Trainer 1 – “Mukesh” ,”DevOps”,mukesh@gmail.com, 3

Trainer 1 can teach Selenium, Trainer 2 can teach Web Development, Trainer 3 can teach DevOps.

 */


public class Trainer {
	
	String name, department, email;
	int id;
	
	Trainer(String tname, String tdept, String temail, int tid)
	{
		name = tname;
		department = tdept;
		email = temail;
		id = tid;
	}
	
	public void selenium()
	{
		System.out.println("Name : "+ name+ " Department : "+department+ " email : "+email+ " ID : "+id);
	}
	
	public void devOps()
	{
		System.out.println("Name : "+ name+ " Department : "+department+ " email : "+email+ " ID : "+id);
	}
	
	public void webDevelopment()
	{
		System.out.println("Name : "+ name+ " Department : "+department+ " email : "+email+ " ID : "+id);
	}

	public String toString()
	{
		return "Name : "+ name+ " Department : "+department+ " email : "+email+ " ID : "+id;
	}
	
	public static void main(String[] args) {
		Trainer trainer1 = new Trainer("Mukesh","Testing","mukesh@gmail.com", 1);
		trainer1.selenium();
		Trainer trainer2 = new Trainer("Hitesh","Dev","mukesh@gmail.com", 2);
		trainer2.webDevelopment();
		Trainer trainer3 = new Trainer("Mukesh","DevOps","mukesh@gmail.com", 3);
		trainer3.devOps();
		
		
		}
	}

