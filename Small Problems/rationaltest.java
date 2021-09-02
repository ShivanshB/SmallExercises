public class rationaltest {
	public static void main(String[] args) {
// Changes made in below determinant method: 
		// Changes addition, subtraction, and multiplication into using the 
		// sub, subtract, and multiply methods. Also used custom rational
		// power method. Arrays were changed into rational arrays with rational values.

		
		rational[][] matrix = new rational[4][4];

		
		matrix[0][0] = new rational(2,3);
		matrix[0][1] = new rational(3,4);
		matrix[0][2] = new rational(1,5);
		matrix[0][3] = new rational(5,7);

		

		matrix[1][0] = new rational(4,11);
		matrix[1][1] = new rational(1,2);
		matrix[1][2] = new rational(2,5);
		matrix[1][3] = new rational(8,9);

		

		matrix[2][0] = new rational(3,5);
		matrix[2][1] = new rational(3,11);
		matrix[2][2] = new rational(11,13);
		matrix[2][3] = new rational(2,1);

		matrix[3][0] = new rational(6,7);
		matrix[3][1] = new rational(2,19);
		matrix[3][2] = new rational(1,4);
		matrix[3][3] = new rational(4,17);





	

		System.out.println(determinant(matrix));
	}


	 public static rational determinant(rational[][] matrix) {
	    	int n = matrix.length;
	    	int n2 = matrix[0].length; 
	    	rational[][] subArray;
	    	rational answer = new rational(0);
	    	rational NEG_ONE = new rational(-1);

	    	if (n != n2) {
	    		throw new IllegalArgumentException("Non-square matrix cannot be parsed.");
	    	}

	    	if(n == 2) {
	    		return ((matrix[0][0].multiply(matrix[1][1])).subtract((matrix[0][1].multiply(matrix[1][0]))));
	    	} else {
	    		for(int i = 0; i < n; i++) {
	    			subArray = generateSubArray(matrix, i);
	    			answer = answer.add(determinant(subArray).multiply(NEG_ONE.power(i)).multiply(matrix[0][i]));
	    		}
	    	}
	    	return answer;
	    }

	    public static rational[][] generateSubArray(rational[][] matrix, int i) {
	    	int N = matrix.length;
	    	rational[][] subArray = new rational[N-1][];

	    	for (int m = 0; m < N-1; m++) {
	    		subArray[m] = new rational[N-1];
	    	}

	    	for (int j = 1; j < N; j++) {
	    		int l = 0;
	    		for (int k = 0; k < N; k++) {
	    			if (k == i) {
	    				continue;
	    			}
	    			subArray[j-1][l] = matrix[j][k];
	    			l++;
	    		}
	    	}
	    	return subArray;

	    }

}