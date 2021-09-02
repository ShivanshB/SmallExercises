public class meansd {
	public static void main(String[] args) {
		int arraySize = 10000;
		double[] doubleArray = new double[arraySize];
		double sum = 0;
		double squaresum = 0;

		for (int i=0; i<arraySize; i++) {
			doubleArray[i] = Math.random();
			sum += doubleArray[i];
			squaresum += (doubleArray[i] * doubleArray[i]);
		}

		double mean = sum/arraySize;
		double squareMean = squaresum/arraySize;

		System.out.println("The mean is: " + mean);
		System.out.println("The std dev is: " + (squareMean-(mean * mean)));
	}
}