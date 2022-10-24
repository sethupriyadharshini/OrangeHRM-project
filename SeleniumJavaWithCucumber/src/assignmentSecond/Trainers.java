package assignmentSecond;

/*
 Task 2- Extension of task 1 – Store all trainer information in Array.
 */


public class Trainers {

	public static void main(String[] args) {
		Trainer trainer1 = new Trainer("Mukesh","Testing","mukesh@gmail.com", 1);
		Trainer trainer2 = new Trainer("Hitesh","Dev","mukesh@gmail.com", 2);
		Trainer trainer3 = new Trainer("Mukesh","DevOps","mukesh@gmail.com", 3);
		
		Trainer[] t= {trainer1,trainer2,trainer3};
		
		/*Trainer[] t= new Trainer[3];
		t[0]=trainer1;
		t[1]=trainer2;
		t[2]=trainer3;
		*/
		
		for(Trainer tt : t)
		{
			System.out.println(tt);
		}
		
	}
}
	


