import java.util.*;

public class gcd {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int int1 = s.nextInt();
		int int2 = s.nextInt();

		int dividend = int1/int2;
		int remainder = int1 % int2;

		while (remainder != 0) {
			int1 = int2;
			int2 = remainder;

			dividend = int1/int2;
			remainder = int1 % int2;
		}

		System.out.println("gcd is " + int2);

	}
}