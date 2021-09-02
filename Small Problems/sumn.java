import java.util.*;

public class sumn {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int endValue = s.nextInt();
		int currentValue = 0;
		int runningTotal = 0;

		while (currentValue <= endValue) {
			runningTotal += currentValue;
			currentValue++;
		}

		System.out.println("Total of the first " + endValue + " natural numbers is " + runningTotal);
	}
}