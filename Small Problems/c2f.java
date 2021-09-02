import java.util.Scanner;

public class c2f {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double c = s.nextDouble();
		
		c2f(c);
	}

	public static void c2f(double c) {
		double f = c* 1.8 +32;
		System.out.println(f);
	}
}