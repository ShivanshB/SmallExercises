import java.util.*;

public class quad {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number 1: ");
		double a = s.nextDouble();

		System.out.println("Enter number 2: ");
		double b = s.nextDouble();

		System.out.println("Enter number 3: ");
		double c = s.nextDouble();

		double firstHalf = (-1*b/(2*a));
		String solution1;
		String solution2;
		String answer;

		if ((b*b - 4 * a * c) < 0) {
			double imaginary = (Math.sqrt(4*a*c-b*b))/(2*a);
			solution1 = firstHalf + " + " + imaginary + "i";
			solution2 = firstHalf + " - "  + imaginary + "i";


			answer = "The complex solutions to: " + a + "x^2 " + " + " + b + "x " + " + " + c + " =0 are: \n " + solution1 + "\n" + solution2; 


		} else {
			double discriminant = (Math.sqrt(b*b-4*a*c))/(2*a);

			Double final1 = firstHalf + discriminant;
			Double final2 = firstHalf - discriminant;

			solution1 = final1.toString();
			solution2 = final2.toString();

			answer = "The solutions to: " + a + "x^2 " + " + " + b + "x " + " + " + c + " =0 are: \n " + solution1 + "\n" + solution2; 

		}

		System.out.println(answer);
	}
}