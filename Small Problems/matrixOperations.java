import java.util.*;
import java.lang.*;

public class matrixOperations {

	public static double determinant(double[][] matrix) {
	    	int n = matrix.length;
	    	int n2 = matrix[0].length; 
	    	double[][] subArray;
	    	double answer = 0;

	    	if (n != n2) {
	    		throw new IllegalArgumentException("Non-square matrix cannot be parsed.");
	    	}

	    	if(n == 2) {
	    		return (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]);
	    	} else {
	    		for(int i = 0; i < n; i++) {
	    			subArray = generateSubArray(matrix, i);
	    			answer += determinant(subArray) * Math.pow(-1,i) * matrix[0][i];
	    		}
	    	}
	    	return answer;
	    }

	    public static double[][] generateSubArray(double[][] matrix, int i) {
	    	int N = matrix.length;
	    	double[][] subArray = new double[N-1][];

	    	for (int m = 0; m < N-1; m++) {
	    		subArray[m] = new double[N-1];
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


	    public static double[] Cramer(double[][] matrix, double[] values) {

            int n = matrix.length;
            double[] solutions = new double[n];

            double[][] numerator = new double[n][n];
            copyArray(matrix, numerator);

            double denominator = determinant(matrix);

            if (matrix.length != matrix[0].length) {
                System.out.println("Non-square matrix cannot be solved.");
                return solutions;
            } if (denominator == 0) {
                System.out.println("Determinant of 0 in denominator cannot be solved.");
                return solutions;
            } else {
                for (int i = 0; i < matrix.length; i++) {
                    replaceColumn(numerator, values, i);
                    solutions[i] = determinant(numerator)/denominator;
                    copyArray(matrix, numerator);

                }

                return solutions;
            }

        }

        public static void copyArray(double[][] array1, double[][] array2) {
            for (int i = 0; i < array1.length; i++) {
                for (int j = 0; j< array1[0].length; j++) {
                    array2[i][j] = array1[i][j];
                }
            }
        }

        public static void replaceColumn(double[][] array, double[] values, int n) {
            for (int i = 0; i < array.length; i++) {

                array[i][n] = values[i];
            }
        }

        public static double[][] matrixInverse (double[][] matrix) {
            int n = matrix.length;

            if (determinant(matrix) == 0) {
                System.out.println("Determinant is 0, matrix does not exist.");
                return matrix;
            }

            double[][] inverse = new double[n][n];
            double[][] singleDeterminant = new double[n-1][n-1];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    singleDeterminant = removeRowColumn(matrix,i,j);
                    inverse[i][j] = determinant(singleDeterminant)*Math.pow(-1,i+j);
                }
            }

             for (int i = 0; i < n; i++) {

                for (int j = 0; j <= i; j++) {

                    double temp = inverse[i][j];
                    inverse[i][j] = inverse[j][i];
                    inverse[j][i] = temp;
                }
            } 

            scalarMatrixMultiply(inverse, 1/determinant(matrix));

            return inverse;
        }


        public static double[][] removeRowColumn(double[][] matrix, int i, int j) {
            int n = matrix.length;
            double[][] returnVal = new double[n-1][n-1];

            int row = -1;
            int column = -1;

            for (int k = 0; k < n; k++) {
                if (k == i) {
                    continue;
                } else {
                    row++;
                }

                for (int l = 0; l < n; l++) {
                    if (l == j) {
                        continue;
                    } else {
                        column++;
                        returnVal[row][column] = matrix[k][l];
                    }
                }

                column = -1;

            }

            return returnVal;

        }

        public static void scalarMatrixMultiply(double[][] matrix, double m) {
            int n = matrix.length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = matrix[i][j]*m;
                }
            }
        }
}