import java.util.*;

public class nthroot {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Find the nth root of: ");
		double x = s.nextDouble();
		System.out.println("The nth root you're finding is n = ");
		double n  = s.nextDouble();
		System.out.println("The maximum error-epsilon-is = ");
		double epsilon = s.nextDouble();

		double currentEstimate = 1;
		double previousEstimate = 1;


		while (Math.abs(x-Math.pow(currentEstimate,n)) > epsilon) {

			previousEstimate = currentEstimate;

			currentEstimate -= (Math.pow(previousEstimate, n)-x)/(n*Math.pow(previousEstimate, n-1));


		}

		System.out.println(currentEstimate);


	}
}