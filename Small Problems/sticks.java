import java.util.*;

public class sticks{

	static double length1;
	static double length2;
	static double length3;
	static double x1;
	static double x2;
	static double temp;
	static int counter = 0;
	static boolean flag = false;
	public static void main(String[] args) {


		for (int i = 0; i < 100000; i++) {

			flag = false;
			x1 = Math.random();
			x2 = Math.random();

			if(x1 > x2) {
				temp = x2;
				x2 = x1;
				x1 = temp;
			}

			length1 = x1;
			length2 = x2 -x1;
			length3 = 1 - x2;

			if(length1 > 0.5) {
				flag = true;
			}

			if(length2 > 0.5) {
				flag = true;
			}

			if(length3 > 0.5) {
				flag = true;
			}

			if (!flag) {
				counter++;
			}
		}
		System.out.println(counter/100000.0);
		
	}


}