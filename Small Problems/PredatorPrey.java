import java.util.*;


public class PredatorPrey {

	public int boardSize;
	public int numPrey;
	public int numPred;
	public int preyReproduce;
	public int predSurive;
	public int predReproduce;

	public ArrayList<Integer> preyx = new ArrayList<Integer>();
	public ArrayList<Integer> preyy = new ArrayList<Integer>();

	public ArrayList<Integer> predx = new ArrayList<Integer>();
	public ArrayList<Integer> predy = new ArrayList<Integer>();

	public ArrayList<Integer> preyDays = new ArrayList<Integer>();
	public ArrayList<Integer> predDays = new ArrayList<Integer>();

	public ArrayList<Integer> predEaten = new ArrayList<Integer>();


	public PredatorPrey(int boardSize, int numPrey, int numPred, int preyReproduce, int predSurive, int predReproduce) {

		this.boardSize = boardSize;
		this.numPrey = numPrey;
		this.numPred = numPred;
		this.preyReproduce = preyReproduce;
		this.predReproduce = predReproduce;
		this.predSurive = predSurive;

		populateBoard();

		predKill();

	}

	public void populateBoard() {
		for (int i = 0; i < numPred; i++) {
			predx.add((int) (Math.random()*boardSize));
			predy.add((int) (Math.random()*boardSize));
			predDays.add(0);
			predEaten.add(0);
		}

		for (int i = 0; i < numPrey; i++) {
			preyx.add((int) (Math.random()*boardSize));
			preyy.add((int) (Math.random()*boardSize));
			preyDays.add(0);
		}
	}

	public void predKill() {
		for (int i = 0; i < predDays.size(); i++) {
			if (predDays.get(i) > predSurive) {
				predx.remove(i);
				predy.remove(i);
				predDays.remove(i);
				predEaten.remove(i);
			}

		}

		shuffleAll();
	}

	public void shuffleAll() {

		int val;
		int tempX;
		int tempY;

		for (int i = 0; i < preyDays.size(); i++) {

			val = preyDays.get(i);
			preyDays.set(i, val + 1);
		}

		for (int i = 0; i < preyx.size(); i++) {

			tempX = preyx.get(i);
			tempY = preyy.get(i);

			val = (int) (Math.random() * 4);

			if (val == 0) {

				if (tempX + 1 == boardSize) {
					preyx.set(i, 0);
				} else {
					preyx.set(i, tempX + 1);
				}

			} else if (val == 1) {

				if (tempX - 1 < 0) {
					preyx.set(i, boardSize-1);
				} else {
					preyx.set(i, tempX - 1);
				}

			} else if (val == 2) {

				if (tempY - 1 < 0) {
					preyy.set(i, boardSize-1);
				} else {
					preyy.set(i, tempY - 1);
				}

			} else if (val == 3) {

				if (tempY + 1 == boardSize) {
					preyy.set(i, 0);
				} else {
					preyy.set(i, tempY + 1);
				}

			}

			if (preyDays.get(i) == preyReproduce) {
				preyx.add((int) (Math.random()*boardSize));
				preyy.add((int) (Math.random()*boardSize));
				preyDays.add(0);
				preyDays.set(i,0); 
			}

		}



		for (int i = 0; i < predx.size(); i++) {

			tempX = predx.get(i);
			tempY = predy.get(i);

			val = (int) (Math.random() * 4);

			if (val == 0) {

				if (tempX + 1 == boardSize) {
					predx.set(i, 0);
				} else {
					predx.set(i, tempX + 1);
				}

			} else if (val == 1) {

				if (tempX - 1 < 0) {
					predx.set(i, boardSize-1);
				} else {
					predx.set(i, tempX - 1);
				}

			} else if (val == 2) {

				if (tempY - 1 < 0) {
					predy.set(i, boardSize-1);
				} else {
					predy.set(i, tempY - 1);
				}

			} else if (val == 3) {

				if (tempY + 1 == boardSize) {
					predy.set(i, 0);
				} else {
					predy.set(i, tempY + 1);
				}

			}

			if (predEaten.get(i) == predReproduce) {

				predx.add((int) (Math.random()*boardSize));
				predy.add((int) (Math.random()*boardSize));
				predDays.add(0);
				predEaten.add(0);
				predEaten.set(i,0);
			}

		}

		calculateEaten();

	}

	public void calculateEaten() {

		boolean flag;
		int xVal;
		int yVal;

		for (int i = 0 ; i < predx.size() ; i++) {

			flag = false;

			xVal = predx.get(i);
			yVal = predy.get(i);

			for (int j = 0; j < preyx.size(); j++) {

				if ((preyx.get(j) == xVal) && (preyy.get(j) == yVal)) {

					flag = true;

					preyx.remove(j);
					preyy.remove(j);
					preyDays.remove(j);

					predEaten.set(i, predEaten.get(i) + 1);
					predDays.set(i,0);
				} 

			}

			if (flag == false) {
				predDays.set(i, predDays.get(i) + 1);
			}
			
		}

		System.out.println("Prey: " + preyx.size());
		System.out.println("Predators: " + predx.size());

		predKill();

	}

}