import java.util.*;

public class game57 {
	public static void main(String[] args) {
		int diceSides;
		double prob;
		int simul = 1000000;
		int wins = 0;
		int losses;
		int counter = 0;
		

		Scanner s = new Scanner(System.in);

		System.out.println("Dice has this many sides: ");
		diceSides = s.nextInt();

		while (counter < simul) {
			if (playGame(diceSides) == 0) {
				wins++;

			}	
			counter++;	
		}

		System.out.println("Probability of winning is: " + (double)wins/simul);
	}

	public static int playGame(int diceSides) {
		int roll1;
		int roll2;
		int sum = 0;
		while ((sum != 5) && (sum != 7)) {
			roll1 = (int) (Math.random() * diceSides) + 1;
			roll2 = (int) (Math.random() * diceSides) + 1;
			sum = roll1 + roll2;
		}


		if (sum == 5) {
			return 0;
		} else {
			return 1;
		}
	}
}