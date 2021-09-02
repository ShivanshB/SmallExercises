import java.util.*;

public class reverseint {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your number: ");
		int x = s.nextInt();

		int y = 0;
		int digit;

		while (x > 0) {
			digit = x % 10;
			y = y*10 + digit;
			x=x/10;
		}

		System.out.println(y);
	}
}