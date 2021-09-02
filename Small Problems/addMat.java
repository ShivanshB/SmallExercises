import java.util.*;

public class addMat {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Rows: ");
		int rows = s.nextInt();
		System.out.println("Columns: ");
		int columns = s.nextInt();

		int[][] matrix1 = new int[rows][columns];
		int[][] matrix2 = new int[rows][columns];
		int[][] sumMatrix = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j<columns; j++){
				matrix1[i][j] = (int) (Math.random()*10 + 1);
				matrix2[i][j] = (int) (Math.random()*10 + 1);
				sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		System.out.println("Matrix 1: ");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j<columns; j++){
				System.out.print(matrix1[i][j]+ " ");
			}
			System.out.print('\n');
		}

		System.out.println("Matrix 2: ");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j<columns; j++){
				System.out.print(matrix2[i][j]+ " ");
			}
			System.out.print('\n');
		}

			System.out.println("Summation Matrix : ");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j<columns; j++){
				System.out.print(sumMatrix[i][j]+ " ");
			}
			System.out.print('\n');
		}

	}
}