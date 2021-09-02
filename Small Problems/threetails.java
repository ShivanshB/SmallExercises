public class threetails {
	public static void main(String[] args) {
		
		char lastToss;
		char middleToss;
		char currentToss;
		boolean flag = true;
		int totalFlips = 0;


		for(int i = 0; i<=10000000; i++) {
			totalFlips++;
			totalFlips++;
			middleToss = coinFlip();
			currentToss = coinFlip();
			flag = true;

			while(flag) {
				lastToss = middleToss;
				middleToss = currentToss;
				currentToss = coinFlip();
				totalFlips++;

				if ((Character.compare(lastToss,'T') == 0) && (Character.compare(currentToss,'T') == 0) && (Character.compare(middleToss,'T') == 0)) {
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