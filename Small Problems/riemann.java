public class riemann {
	public static void main(String[] args) {
		double increment = 0.001;
		double lowerBound = 1;
		double upperBound = 3;
		double area = 0;

		for (double i = lowerBound; i < upperBound; i+= increment) {
			area = area + (increment * Math.exp(-1*i*i));
		}

		System.out.println(area);
	}

	public static double square(double n) {
		return (n * n);
	}


}