import java.util.*;

public class mymethodstest{

 public static void main(String[] args) {
 // 	Scanner s = new Scanner(System.in);
 // 	System.out.println("Number to square: ");
 // 	double z = s.nextInt();
 // 	System.out.println(z + " squared is " + mymethods.mySquare(z));



 // 	System.out.println("Find the nth root of: ");
	// double x = s.nextDouble();
	// System.out.println("The nth root you're finding is n = ");
	// double n  = s.nextDouble();
	// System.out.println("The maximum error-epsilon-is = ");
	// double epsilon = s.nextDouble();
	// System.out.println("The root is: " + mymethods.kroot(x,n,epsilon));



	// double[][] matrix1 = new double[][]{{1,3,4},{2,4,5},{3,2.3,4.2}};
	// double[][] matrix2 = new double[][]{{1.5,3.5,4},{2.4,4,5.2},{5,2.3,4.2}};
	// double[][] multMatrix = mymethods.matMult(matrix1, matrix2);

 	// double[] values = new double[]{3.2,43,24.2,2.3,34,2,4,56,34,2,4,2,4,2,3};
 	// double[] results = mymethods.meansd(values, 10);

 	// System.out.println(mymethods.nthPrime(100));

 	// int[] intArray = new int[]{12,34,5,23,2,4,3,4,3,2,5,2};
 	// mymethods.shuffle(intArray);
 	// for (int element: intArray) {
 	// 	System.out.print(element + ", ");
 	// }

 	// mymethods x = new mymethods();
 	// System.out.println(x.kroot(4,2,0.001));

 	// int[] intArray = new int[3];
 	// intArray[0] = 0;
 	// intArray[1] = 1;
 	// intArray[2] = 2;

 	// mymethods.shuffle(intArray);

 	// for (int i = 0; i < 100; i++) {
 	// 	intArray[0] = 0;
 	// 	intArray[1] = 1;
 	// 	intArray[2] = 2;

 	// 	mymethods.shuffle(intArray);
 	// 	mymethods.printArray(intArray);
 	// }


 	// int n = 10;

 	//  double[] sortIntArray = new double[n];
 	//  for (int i = 0; i < n; i++) {
 	//  	sortIntArray[i] = Math.random() * 500;
 	//  }

 	//  mymethods.insertionSort(sortIntArray);

 	//  for (double i: sortIntArray) {
 	//  	System.out.print(i + ", ");
 	//  }
 	// System.out.println(mymethods.isPalindrome("abcdcba"));

 	// System.out.println(mymethods.sumDigits(1234));


 	// int[] intArray = new int[]{1, 3,4, 6,7, 12, 23,56, 242, 2324};
 	// System.out.println(mymethods.binarySearch(intArray, 57, 0, 9));

 	// String test = "abc";
 	// System.out.println(mymethods.reverseString(test));

 	// System.out.println(mymethods.gcd(60,72));

 	// mymethods.Hanoi(3, 1,2);

 	// double[][] values = {{1.5,2,3,6.7},{2,3.2,4,6.7},{3,4,9,2.3},{1,2,3,4}};
 	// System.out.println(mymethods.determinant(values));

 	// System.out.println(mymethods.fibonacci(20));

 	// double[] intArray = new double[]{8,2,5,2,1,3,4,35908 ,12,41, 42.2,4,4,78,1,6,1,76,3,2,6,12};	
 	// for (double i: mymethods.mergeSort(intArray,0,intArray.length-1)) {
 	// 	System.out.print(i + ", ");
 	// }

 	// double[] intArray = new double[]{5,2,4,1,12,5,61,6,1,67,1,6,1,6,1,74,34,1,3,3,7,2,8,23};	
 	// for (double i: mymethods.quicksort(intArray,0,intArray.length-1)) {
 	// 	System.out.print(i + ", ");
 	// }

 	// System.out.println(mymethods.nestedRadical(10, 2));

 	// System.out.println(mymethods.nQueens(16));

 	// mymethods.timeComplexityTester(1, 1050000);

 	// double[] array = new double[]{5,2,7,1,4,3,6,2,5};
 	// for(double i: mymethods.quicksort(array,0,array.length-1)) {
 	// 	System.out.print(i + ", ");
 	// }

 	// int[][] sodukoBoard = new int[][]{{0,6,5,0,0,7,0,1,0},{0,0,0,9,1,0,6,0,0},{0,0,0,0,0,0,0,5,0},{0,0,0,0,4,0,7,2,0},{3,0,0,0,0,0,0,0,0},{6,0,9,0,7,0,0,0,0},{9,0,0,0,0,0,5,0,0},{0,8,0,1,3,0,0,7,0},{0,0,7,0,0,0,0,0,2}};
 	// mymethods.soduko(sodukoBoard);

 	// ArrayList<String> permutations = new ArrayList<>();
 	// mymethods.nPermute(permutations, "abcde", 2, "");
 	// System.out.println(permutations.size());

 	// for(String s: permutations) {
 	// 	System.out.println(s + ", ");
 	// }

 	// System.out.println(mymethods.combinations(15,7));

 	// System.out.println(NQueens.nQueens(8));

 	// solveSoduko.soduko(sodukoBoard);

 	// double[] constants = new double[]{1,2,3,4};
 	// double[] solutions = mymethods.Cramer(values, constants);

 	// for(double d: solutions) {
 	// 	System.out.println(d + ", ");
 	// }

 	// double[] array = new double[1000000];
 	// for (int j=0; j <1000000; j++) {
  //       array[j] = (100.0 * Math.random());
  //   }

  //   mymethods.mergeSort(array,0,999999);


  //   for (int i = 0; i < 100; i ++) {
  //   	System.out.print(array[i] + ", ");
  //   }

 	// double[][] matrix = {{1,2,3,6},{5,6,8,8},{9,10,13,12},{13,14,15,16}};
 	// mymethods.printGrid(mymethods.matrixInverse(matrix));

 }

}