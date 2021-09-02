import java.util.*;

public class cointoss {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of tosses: ");
		int Ntoss = s.nextInt();

		int tailsCount = 0;
		int headsCount = 0;

		for (int i = 0; i < Ntoss; i++) {
			if (Math.random() > 0.5) {
				tailsCount++;
			} else {
				headsCount++;
			}
		}

		double tailsP = (double) tailsCount/Ntoss;
		double headsP = (double) headsCount/Ntoss;

		System.out.println("The probability of getting a tails is "+ tailsP + " and getting heads is " + headsP);

	}
}