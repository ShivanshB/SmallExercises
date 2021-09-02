import java.util.Scanner;

public class f2c {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double c = s.nextDouble();
		
		f2c(c);
	}

	public static void f2c(double c) {
		double f = (c-32) *(5.0/9.0);
		System.out.println(f);
	}
}