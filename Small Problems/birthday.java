import java.util.*;


public class birthday {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Number of Students: ");
		int n = s.nextInt();
		int iterations = 100000;
		int count = 0;
		int[] bdays = new int[n];
		int winCounter = 0;

		while (count < iterations) {
			for (int i = 0; i < n; i++) {
				bdays[i] = (int) (Math.random() * 365 + 1);
			}

			boolean flag = false;

			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					if ((i != j) && (bdays[i] == bdays[j])) {
						flag = true;
					}
				}
			}


			if (flag == true) {
				winCounter++;
			}


			count++;


		}

		System.out.println((double) winCounter/iterations);
	}
}