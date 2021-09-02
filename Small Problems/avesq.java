import java.util.*;

public class avesq {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of randomly generated numbers: ");
		int n = s.nextInt();

		double sum = 0;

		for (int i = 0; i < n; i++) {
			double random = Math.random();
			sum += random * random;
		}

		double averagesq = sum/n;

		System.out.println("The average square value from 0-1 is" + averagesq);

	}
}