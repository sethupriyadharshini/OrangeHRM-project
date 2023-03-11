package assignment11;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

	public static void main(String[] args) {
		
		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat dt = new SimpleDateFormat("HH:mm:ss_dd_MMM_yyyy");
		Object myString = DateFormat.getDateInstance().format(d);
		System.out.println(myString);
		System.out.println(dt.format(d));
	}

}
