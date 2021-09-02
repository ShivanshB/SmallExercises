public class twotails {
	public static void main(String[] args) {
		
		char lastToss;
		char currentToss;
		boolean flag = true;
		int totalFlips = 0;


		for(int i = 0; i<=10000000; i++) {
			totalFlips++;
			currentToss = coinFlip();
			flag = true;

			while(flag) {
				lastToss = currentToss;
				currentToss = coinFlip();
				totalFlips++;

				if ((Character.compare(lastToss,'T') == 0) && (Character.compare(currentToss,'T') == 0)) {
					flag = false;
				}
			}
		}

		
		System.out.println((double)totalFlips/10000000);

	}

	public static char coinFlip() {
		char c;
		if(Math.random() < 0.50) {
			c = 'H';
		} else {
			c = 'T';
		}
		return c;
	}
}