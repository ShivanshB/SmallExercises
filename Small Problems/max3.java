import java.util.*;

public class max3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number 1: ");
		double num1 = s.nextDouble();

		System.out.println("Enter number 2: ");
		double num2 = s.nextDouble();

		System.out.println("Enter number 3: ");
		double num3 = s.nextDouble();

		if (num1 > num2) {

			if (num1 > num3) {
				 System.out.println("greatest: " + num1);
			} else {
				System.out.println("greatest: " + num3);
			}

		} else {

			if (num2 > num3) {
				 System.out.println("greatest: " + num2);
			} else {
				System.out.println("greatest: " + num3);
			}

		}
	}
}