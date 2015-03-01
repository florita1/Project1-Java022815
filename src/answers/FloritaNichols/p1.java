
public class p1 {

	public static void main(String[] args) {
		//initiate value for the sum of values
		int sum = 0;
		
		//FOR loop iterating through values less than 1000
		for(int i = 0; i < 1000; i++){
			//Condition that checks if value, i, is a multiple of 3 or 5
			if(i%3 == 0 || i%5 == 0){
				//Accumulating sum of values
				sum += i;
			}
		}
		System.out.println(sum);

	}

}
