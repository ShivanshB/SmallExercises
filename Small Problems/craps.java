public class craps {
	public static void main(String[] args) {
		int counter = 0;

		for (int i = 0; i < 1000000; i++) {
			if (simulate() == true) {

				counter++;
			}

		}
		System.out.println(((double)counter)/1000000);

		
	}

	public static boolean simulate() {
		int rand1 = (int) ((Math.random()*6) + 1);
		int rand2 = (int) ((Math.random()*6) + 1);
		int sum = rand1 + rand2;

		int oldSum = sum;
		boolean flag = false;
		int bit = 0;

		switch (sum) {
			
			case 7: 
				flag = true;
				bit = 1;
				break;
			case 11: 
				flag = true;
				bit = 1;
				break;
			case 2:
				flag =  false;
				bit = 1;
				break;
			case 3:
				flag = false;
				bit = 1;
				break;
			case 12:
				flag = false;
				bit = 1;
				break;
			default:
				break;
		}

		if (bit == 1) {
			return flag;
		}

		while (true) {
			rand1 = (int) ((Math.random()*6) + 1);
			rand2 = (int) ((Math.random()*6) + 1);
			sum = rand1 + rand2;

			if (sum == oldSum) {
				return true;
			} if (sum == 7) {
				return false;
			}
		}

	}
}