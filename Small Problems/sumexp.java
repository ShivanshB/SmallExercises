import java.util.*;

public class sumexp {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Number of Terms in the Approximation: ");
		int approxTerms = s.nextInt();
		System.out.print("Exponent for e: ");
		double exponent = s.nextDouble();

		double approx = 0;
		int counter = 0;
		double runningSum = 0;

		while (counter <= approxTerms) {
			runningSum += (Math.pow(exponent, counter)/factorial(counter));
			counter++;
		}

		System.out.println("e to the power " + exponent + " approximated by " + approxTerms + " terms is " + runningSum);


	}

	public static double factorial(int n) {
		int counter = 1;
		int factorial = 1;

		while (counter < n) {
			factorial *= (counter +1);
			counter++;
		}


		return factorial;

	}
}