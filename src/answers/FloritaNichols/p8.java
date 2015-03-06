import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class p8 {

	public static void main(String[] args) throws ParseException {
		
		Scanner user_input = new Scanner( System.in );
		System.out.print("Enter time (hh:mm am/pm):");
		String end = user_input.next();

		long start = System.currentTimeMillis( );

		SimpleDateFormat format = new SimpleDateFormat("hh:mm a", Locale.US);
		
		Date time1 = new Date(start);
		format.setLenient(false);
		Date time2 = format.parse(end);

		System.out.println(time2);
		System.out.println(format.format(time1));
		//long end = System.currentTimeMillis( );

		long diff = time2.getTime() - time1.getTime();
		long diffMinutes = diff / (60 * 1000) % 60;
		System.out.println("Difference is : " + diffMinutes + "minutes");
	      
	}

}
