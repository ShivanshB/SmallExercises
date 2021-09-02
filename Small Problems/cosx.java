import java.util.*;

public class cosx {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Find the cos of: ");
		double x = s.nextDouble();
		System.out.println("Approximate with this many terms: ");
		int approxTerms = s.nextInt();	

		double runningTotal = 0.0;
		double currentNum = 1;
		double currentDenom = 1;
		double currentTerm;

		int count = 0;
		while (count <= approxTerms) {
			currentTerm = currentNum/currentDenom;
			runningTotal += currentTerm;
			System.out.println(runningTotal);

			count++;	

			currentNum = currentNum * x * x * -1;
			currentDenom *= (2*count-1)*(2*count);

		}
		System.out.println("cos(" + x + ") = " + runningTotal);

	}
}