import java.util.*;

public class matMult {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Columns in 1/Rows in 2: ");
		int C1R2 = s.nextInt();
		System.out.println("Rows in 1: ");
		int R1 = s.nextInt();
		System.out.println("Columns in 2: ");
		int C2 = s.nextInt();
		int multSum = 0;

		int[][] matrix1 = new int[R1][C1R2];
		int[][] matrix2 = new int[C1R2][C2];
		int[][] multMatrix = new int[R1][C2];


		for (int i = 0; i < R1; i++) {
			for (int j = 0; j< C1R2; j++){
				matrix1[i][j] = (int) (Math.random()*10 + 1);
			}
		}

		for (int i = 0; i < C1R2; i++) {
			for (int j = 0; j< C2; j++){
				matrix2[i][j] = (int) (Math.random()*10 + 1);
			}
		}


		for (int i = 0; i < R1; i++) {
			for (int j = 0; j< C2; j++){
				multSum = 0;
				int[] rowMatrix = new int[C1R2];
				int[] columnMatrix = new int[C1R2];

				for (int k = 0; k < C1R2; k++) {
					rowMatrix[k] = matrix1[i][k];
					columnMatrix[k] = matrix2[k][j];
					multSum += (rowMatrix[k] * columnMatrix[k]);
				}

				multMatrix[i][j] = multSum;
			}
		}

		System.out.println("Matrix 1: ");

		for (int i = 0; i < R1; i++) {
			for (int j = 0; j<C1R2; j++){
				System.out.print(matrix1[i][j]+ " ");
			}
			System.out.print('\n');
		}

		System.out.println("Matrix 2 ");

		for (int i = 0; i < C1R2; i++) {
			for (int j = 0; j<C2; j++){
				System.out.print(matrix2[i][j]+ " ");
			}
			System.out.print('\n');
		}

		System.out.println("Product Matrix ");

		for (int i = 0; i < R1; i++) {
			for (int j = 0; j< C2; j++){
				System.out.print(multMatrix[i][j]+ " ");
			}
			System.out.print('\n');
		}
	
	
		
	}
	
}