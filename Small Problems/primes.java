import java.util.*;

public class primes {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("nth prime number: ");
		int n = s.nextInt();	

		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		int counter = 1;
		int currentInt = 3;

		while (counter < n) {
			if (isPrime(currentInt, primes)) {
				counter++;
				primes.add(currentInt);
			}
			currentInt++;
		}

		System.out.println(primes.get(n-1));

	}

	public static boolean isPrime(int currentInt, ArrayList<Integer> primes) {
		for (int prime: primes) {
			if (currentInt % prime == 0) {
				return false;
			}
		}

		return true;
	}
}