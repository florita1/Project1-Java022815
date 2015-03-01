
public class p2 {

	public static void main(String[] args) {
		//Assign variables
		int fibO = 0;
		int fibN = 1;
		int fibSum = 0;
		int evenValueSum = 0;
		
		//WHILE loop that will execute until sequence values exceed 4 million (test is 20)
		while(fibSum <= 20){
			//Calculates the next value in the seguence and also keeps track of the sum (Fn)
			fibSum = fibN + fibO;
			//Moves the lower value of the sequence up to Fn-2
			fibO = fibN;
			//Moves upper value to Fn-1
			fibN = fibSum;
			//If statement to find sum of even-valued terms
			if(fibSum % 2 == 0)
				evenValueSum += fibSum;
		}
		System.out.println(fibSum);
		System.out.println(evenValueSum);
	}

}
