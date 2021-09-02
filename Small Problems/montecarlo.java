public class montecarlo {
	public static void main(String[] args) {
		double x;
		double y;
		int counter = 0;
		int totalTests = 1000000;
		for (int i = 0; i < totalTests; i++) {
			x = Math.random() * 2 + 1;
			y = Math.random() * 9;

			if (y  <= (x * x)) {
				counter++;
			}
		}
		double area = 2 * 9 * (double) counter/totalTests;
		System.out.println(area);
	}
}