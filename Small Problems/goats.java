import java.util.*;

public class goats {

	public static double radius = 1;

	public static void main(String[] args) {
		double upper = 2.0 * radius;
		double lower = radius; 
		double current;
		int flag = 2;

		while(true) {
			current = (upper + lower)/2.0;
			flag = testRadius(current);
			if (flag == 0) {
				System.out.println(current);
				break;
			}
			else if (flag == -1) {
				lower = current;
			} else if (flag == 1) {
				upper = current;
			}
		}
			

	}

	public static int testRadius(double guess) {
		int testPoints = 100000;
		double x;
		double y;
		double radiusRandom;
		double angle;
		double counter = 0;

		for (int i = 0; i < testPoints; i++) {
			radiusRandom = Math.random();
			angle = Math.random() * Math.PI * 2;
			x = radiusRandom * Math.cos(angle);
			y = radiusRandom * Math.sin(angle);

			if (((radius-y)*(radius-y) + (x*x)) < (guess * guess)) {
				counter++;
			}
		}

		System.out.println(guess+ ", " +counter);
		if (Math.abs((counter - (testPoints/2))/testPoints) <= 0.00001) {
			return 0;
		} else if (counter < testPoints/2) {
			return -1;
		} 

		return 1;
	}
}