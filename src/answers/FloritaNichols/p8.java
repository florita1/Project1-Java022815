import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;


public class p8 {

	public static void main(String[] args) throws ParseException {
		//get current date time with Date()
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date1 = new Date();
		String date = dateFormat.format(date1);
		
		Scanner user_input = new Scanner( System.in );
		System.out.print("Enter time (hh:mm am/pm):");
		String end = date + " " + user_input.next();
		
		System.out.println(end);

		long start = System.currentTimeMillis( );

		DateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm", Locale.US);
		
		Date time1 = new Date(start);
		format.setLenient(false);
		Date time2 = format.parse(end, new ParsePosition(0));

		System.out.println(time2);
		System.out.println(format.format(time1));
		//long end = System.currentTimeMillis( );

		long diff = time2.getTime() - time1.getTime();
		System.out.println(diff);
		long diffMinutes = diff / (60 * 1000);
		System.out.println("Difference is : " + diffMinutes + " minutes");
		user_input.close();
	      
	}

}
