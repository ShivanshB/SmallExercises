	import java.util.*;
    import java.lang.*;

public class mymethods{

	public static int HanoiCounter = 0;

    public static int nQueensCounter = 0;

	public static double mySquare(double x) {
		return x * x;
	}

	public static double kroot(double x, double n, double epsilon) {
		double currentEstimate = 1;
		double previousEstimate = 1;


		while (Math.abs(x-Math.pow(currentEstimate,n)) > epsilon) {

			previousEstimate = currentEstimate;

			currentEstimate -= (Math.pow(previousEstimate, n)-x)/(n*Math.pow(previousEstimate, n-1));
		}
		return currentEstimate;
	}


	public static double[][] matMult (double [][] matrix1, double [][] matrix2) {
		int R1 = matrix1.length;
		int C1R2 = matrix1[0].length;
		int C2 = matrix2[0].length;
		double[][] multMatrix = new double[R1][C2];
		double multSum = 0;

		for (int i = 0; i < R1; i++) {
			for (int j = 0; j< C2; j++){
				multSum = 0;
				double[] rowMatrix = n~ew double[C1R2];
				double[] columnMatrix = new double[C1R2];

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

		return multMatrix;
	
	}

	public static double[] meansd(double[] x, int n) {
		int arraySize = n;
		double[] doubleArray = new double[n];
		double sum = 0;
		double squaresum = 0;

		for (int i=0; i<n; i++) {
			doubleArray[i] = x[i];
			sum += doubleArray[i];
			squaresum += (doubleArray[i] * doubleArray[i]);
		}

		double mean = sum/arraySize;
		double squareMean = squaresum/arraySize;

		System.out.println("The mean is: " + mean);
		System.out.println("The std dev is: " + (squareMean-(mean * mean)));

		double[] returnArray = new double[2];
		returnArray[0] = mean;
		returnArray[1] = (squareMean-(mean * mean));
		return returnArray;
	}

	public static int nthPrime(int n) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		int counter = 1;
		int currentInt = 3;

		while (counter < n) {
			if (isPrimeSub(currentInt, primes)) {
				counter++;
				primes.add(currentInt);
			}
			currentInt++;
		}

		return primes.get(n-1);

	}

	public static boolean isPrimeSub(int currentInt, ArrayList<Integer> primes) {
		for (int prime: primes) {
			if (currentInt % prime == 0) {
				return false;
			}
		}

		return true;
	}

	public static double sinx(double x, int approxTerms) {
		
		double runningTotal = 0.0;
		double currentNum = x;
		double currentDenom = 1;
		double currentTerm;

		int count = 0;
		while (count <= approxTerms) {
			currentTerm = currentNum/currentDenom;
			runningTotal += currentTerm;

			count++;	

			currentNum = currentNum * x * x * -1;
			currentDenom *= (2*count)*(2*count +1);

		}
		return runningTotal;

	}

	public static double cosx(double x, int approxTerms) {

		double runningTotal = 0.0;
		double currentNum = 1;
		double currentDenom = 1;
		double currentTerm;

		int count = 0;
		while (count <= approxTerms) {
			currentTerm = currentNum/currentDenom;
			runningTotal += currentTerm;
			System.out.println(runningTotal);

			count++;	

			currentNum = currentNum * x * x * -1;
			currentDenom *= (2*count-1)*(2*count);

		}
		return runningTotal;

	}

	public static double tanx(double x, int approxTerms) {
		return (sinx(x,approxTerms)/cosx(x,approxTerms));
	}

	public static double factorial(int n) {
		int counter = 1;
		int factorial = 1;

		while (counter < n) {
			factorial *= (counter +1);
			counter++;
		}


		return factorial;

	}

	public static double exp(int approxTerms, double exponent) {
		

		double approx = 0;
		int counter = 0;
		double runningSum = 0;

		while (counter <= approxTerms) {
			runningSum += (Math.pow(exponent, counter)/factorial(counter));
			counter++;
		}

		return runningSum;
	}

	public static boolean isPrime(int n) {
		int sqrt = (int) Math.sqrt(n);
		boolean flag = true;
		for (int i = 1; i <= sqrt; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static void shuffle(int[] intArray) {
		Random rand = new Random();

		int length = intArray.length;
		int random;
		int temp;


		for(int i = 0; i < length - 1; i++) {
			random = rand.nextInt(length - i) + i;
			temp = intArray[random];
			intArray[random] = intArray[i];
			intArray[i] = temp;
		}

	}

	public static void printArray(int[] intArray) {
		for (int i: intArray) {
			System.out.print(i +", ");
		}
		System.out.println("");
	}


public static void printArray(double[] intArray) {
		for (double i: intArray) {
			System.out.print(i +", ");
		}
		System.out.println("");
	}

	public static void selectionSort(double[] array) {

         int length = array.length;
         int iter = length -1;
         int minIndex;

         if (length != 1) {
         	 for (int i = 0; i < iter; i++) {

            minIndex = i;

            for (int j = i + 1; j <= iter; j++) {
                if (array[j] <  array[minIndex]) {
                    minIndex = j;
                }

            	}
            swap(array, i, minIndex );
         	}
       
         } 

        
    }

    public static void swap(double[] array, int index1, int index2) {
        double temp = array[index1];

        array[index1] = array[index2];
        array[index2] = temp;
    }


    public static void bubbleSort(double[] intArray) {

        boolean sorted = false;

        for (int i = 0; (i < (intArray.length - 1)) && (!sorted); i++) {

            sorted = true;

            for (int j = 0; j < intArray.length - 1; j++) {

                if (intArray[j] > intArray[j+1]) {
                    double temp = intArray[j];
                    intArray[j] = intArray[j+1];
                    intArray[j+1] = temp;
                    sorted = false;
                }

            }
        }

    }

    public static void insertionSort(double[] intArray) {

        int length = intArray.length;

        for (int i = 1; i < length; i++) {
            double key = intArray[i];
            int j = i - 1;

            while (j >= 0 && intArray[j] > key) {
                intArray[j+1] = intArray[j];
                j = j -1;
            }
            intArray[j+1] = key;
        }
    
    }

    public static int recursiveFactorial(int n) {
    	if (n==1) {
    		return 1;
    	} else {
    		return (n * recursiveFactorial(n-1));
    	}
    }

    public static boolean isPalindrome(String str) {
    	int length = str.length();
    	if (str.length() == 1) {
    		return true;
    	}
    	if (str.length() == 2) {
    		return str.substring(length-1).equals(str.substring(0,1));
    	} else {
    		if (str.substring(length-1).equals(str.substring(0,1))) {

    			return isPalindrome (str.substring(1, length-1));
    		}
    		else {
    			return false;
    		}
    	}
    }

    public static int sumDigits(int n) {
    	if (n < 10) {
    		return n;
    	} else {
    		return (n % 10) + (sumDigits(n/10));
    	}
    }

    public static boolean binarySearch(int[] intArray, int value, int lowerBound, int upperBound) {
    	int guess = intArray[(upperBound + lowerBound)/2];

    	if (upperBound - lowerBound <= 1) {
    		if ((intArray[lowerBound] == value) || (intArray[upperBound] == value)) {
    			return true;
    		} else {
    			return false;
    		}
    	}

    	if (guess == value) {
    		return true;
    	} else {
    		if (guess < value) {
    			return binarySearch(intArray, value, (upperBound + lowerBound)/2, upperBound);	
    		} else {
    			return binarySearch(intArray, value, lowerBound, (upperBound + lowerBound)/2);	
    		}
    	}

    }

    public static String reverseString(String str) {
    	if (str.length() == 1) {
    		return str;
    	} else {
    		String substring = str.substring(0, str.length()-1);
    		String end = str.substring(str.length()-1);
    		return end + reverseString(substring);
    	}
    }

    public static int gcd(int a, int b) {
    	if (a == 0) {
    		return b;
    	} else {
    		if(b > a) {
    			return gcd(a, b%a);
    		} if (b < a) {
    			return gcd(b%a, a);
    		} else {
    			return a;
    		}
    		
    		
    	}
    }


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

    public static void Hanoi(int disks, int source, int dest) {
    
    	if (disks == 1) {
    		System.out.println(source + " to " + dest);
    	}
    	else {
    		int other = 6 - (source + dest);
    		Hanoi(disks-1,source,other);
    		System.out.println(source + " to " + dest);
    		Hanoi(disks-1,other,dest);
    	}

    }

    public static int fibonacci(int n) {
    	if(n == 0) {
    		return 0;
    	} if (n == 1) {
    		return 1;
    	} else {
    		return(fibonacci(n-1) + fibonacci(n-2));
    	}
    }

    

    public static double nestedRadical(int n, int value) {
    	if (n==1) {
    		return Math.sqrt(value);
    	} else {
    		return Math.sqrt(value + nestedRadical(n-1,value));
    	}
    }

    public static double[] mergeSort(double[] array, int start, int end) {
    	if (start < end) {

            int mid = start + (end -start)/2;

            mergeSort(array, start, mid);
    		mergeSort(array, mid+1, end);
    		merge(array, start,mid, end);
    	}

    	return array;
    }

    public static void merge(double[] array, int start, int middle, int end) {

    	int Lindex = middle - start +1 ;
    	int Rindex = end -middle;
        int mid = middle;

        double[] LArray = new double[Lindex];
        double[] RArray = new double[Rindex];

        for (int i = 0; i < Lindex; ++i){
            LArray[i] = array[i+start];
        }

        for (int k = 0; k < Rindex; ++k) {
            RArray[k] = array[middle +  1 + k];
        }

        int i = 0;
        int j = 0;
        int k = start;

    	while((i < Lindex) && (j < Rindex)) {
            if (LArray[i] <= RArray[j]) {
                array[k] = LArray[i];
                i++;
            }
            else {
                array[k] = RArray[j];
                j++;
            }
            k++;
        }

        while (i < Lindex) {
            array[k] = LArray[i];
            i++;
            k++;
        }

         while (j < Rindex) {
            array[k] = RArray[j];
            j++;
            k++;
        }

	}

    public static double[] quicksort(double[] array, int start, int end) {
        while(start < end) {

            int pivot = pivot(array, start, end);

            // Used implementation with tail recursion to avoid StackOverFlow exception
            if(pivot != 0) {
                quicksort(array, start, pivot -1);
            }
            
            start = pivot +1;

        }
            
            

        return array;
    }

    public static int pivot (double[] array, int start, int end) {

        double pivot = array[end];

        int pIndex = start -1;
        double temp;

        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {

                pIndex++;

                temp = array[i];
                array[i] = array[pIndex];
                array[pIndex] = temp;
            }
        }

        temp = array[pIndex+1];
        array[pIndex+1] = array[end];
        array[end] = temp;

        return pIndex + 1;

    }

    public static int nQueens(int n) {

        int[] rowNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            rowNumbers[i] = -1;
        }

        // public global variable
        nQueensCounter = 0;


        // number at index 0 is the row # for the queen in column 0 and etc
        solveQueens(n,0,rowNumbers);
        return nQueensCounter;

    }

    public static void solveQueens(int n, int column, int[] rowNumbers) {

        if (column == n) {
            nQueensCounter++;
        } else {
            for (int row = 0; row < n; row++) {

                rowNumbers[column] = row;

                if (isNotAttack(rowNumbers)) {
                    solveQueens(n, column+1, rowNumbers);

                }

                rowNumbers[column] = -1;
            }
        }

    }

    public static boolean isNotAttack(int[] rowNumbers) {
        int colSize = 0;

        for(int i = 0; i < rowNumbers.length; i++) {
            if (rowNumbers[i] != -1) {
             colSize++;   
            }
        }

        if(colSize == 1) {
            return true;
        }
        

        for (int i = 0; i < colSize-1; i++) {
            int diff = Math.abs(rowNumbers[colSize-1] - rowNumbers[i]);

            if((diff == 0) || (diff == colSize-i-1)) {
                return false;
            }
        }

        return true;
    }

    public static void timeComplexityTester(int lowerBound, int upperBound) {

        int avgRuns = 5;
        long totalTime = 0;

        for (int i = lowerBound; i<= upperBound; i=i*2) {
            for (int k = 0; k < avgRuns; k++) {
                double[] testArray = new double[i];

                for (int j=0; j <i; j++) {
                    testArray[j] = (100.0 * Math.random());
                }

                long initTime = System.nanoTime();
                quicksort(testArray,0,testArray.length-1);
                totalTime += System.nanoTime()-initTime;
            }
        
        System.out.println((i + ", " + (totalTime/avgRuns)));    

        }
    }

    public static int[][] soduko(int[][] grid) {

        int counter = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                if (grid[i][j] != 0) {
                    counter++;
                }
            }
        }
        int[] presetIndices = new int[counter];

        counter = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                if (grid[i][j] != 0) {
                    presetIndices[counter] = 10*i + j;
                    counter++;
                }
            }
        }

        solveSoduko(0,0,grid,0, "forward", presetIndices);
        return grid;
    }

    public static void solveSoduko(int row, int column, int[][] grid, int counter, String direction, int[] presetIndices) {

        if (column == grid.length) {
            solveSoduko(row+1, 0, grid, counter, direction, presetIndices);

        } else if (row == grid.length) {
            printGrid(grid);
            return;
        } else if (row == -1) {
            System.out.println("No solutions");
            printGrid(grid);
            return;
        } else if (column == -1) {
            solveSoduko(row-1, grid.length-1, grid, counter, direction, presetIndices);
        } else if ((grid[row][column] != 0) && (direction.equals("forward"))) {
            solveSoduko(row, column+1, grid, counter, direction, presetIndices);
        } else if ((direction.equals("backwards")) && isThere(presetIndices, 10*row + column)){
            solveSoduko(row, column-1, grid, counter, direction, presetIndices);
        } else {

            int value = findLowestValue(row, column, grid, counter, direction);

            if (value != 0) {

                grid[row][column] = value;
                solveSoduko(row, column+1, grid, 0, "forward", presetIndices);
            } else {

                if (!(isThere(presetIndices, 10*row + column))) {
                    grid[row][column] = 0;
                }
                solveSoduko(row, column-1, grid, counter+1, "backwards", presetIndices);
            }
        }
    }

    public static int findLowestValue(int row, int column, int[][] grid, int counter, String direction) {
        int[] allElements = new int[9];

        for (int i = 1; i < 10; i++) {
            allElements[i-1] = i;
        }

        for(int i: grid[row]) {
            if (i != 0) {
                allElements[i-1] = 0;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][column] != 0) {
                allElements[grid[i][column]-1] = 0;
            }
        }

        int rowVal = 3*((int)(row/3));
        int colVal = 3*((int)(column/3));


        for (int i = rowVal; i < rowVal + 3; i++) {
            for (int j = colVal; j < colVal + 3; j++) {

                if(grid[i][j] != 0) {
                    allElements[grid[i][j]-1] = 0;
                }
            }
        }

        int iter = 0;

        int value = grid[row][column];

        if (value != 0) {
            allElements[value-1] = value;    
        }
        


        if (direction.equals("forward")) {
            for (int i = 0; i < allElements.length; i++) {
                if (allElements[i] != 0) {

                   if (iter == counter) {
                      return allElements[i];    
                    }
                
                    iter++;
                }
            }
        } else {
                int check = 0;
                for(int i: allElements) {

                    if (i!= 0) {
                        if (check == 1) {
                            return i;
                        }
                    }
                    if (i == value) {
                        check++;
                    }
                }
            }

            return 0;
            

        }

        public static void printGrid(int[][] grid) {
            for(int i = 0; i < grid.length; i++) {
                for (int j: grid[i]) {
                    System.out.print(j + ", ");
                }
                System.out.println("");

            }
            System.out.println("");
        }


        public static void printGrid(double[][] grid) {
            for(int i = 0; i < grid.length; i++) {
                for (double j: grid[i]) {
                    System.out.print(j + ", ");
                }
                System.out.println("");

            }
            System.out.println("");
        }

        public static boolean isThere(int[] array, int value) {
            for (int i: array) {
                if(i == value) {
                    return true;
                }
            }
            return false;
        }

        public static ArrayList<String> permute(String str, int start, int end, ArrayList<String> permutations) {

            String swapped;

            if (start == end) {
                permutations.add(str);
            } else {

                permute(str, start+1, end, permutations);

                for (int i = 1; i <= end - start; i++) {
                    swapped = letterSwap(str, start, start + i);
                    permute(swapped, start + 1, end, permutations);
                }
            }

            return permutations;
        }


        public static String letterSwap(String str, int n1, int n2) {
            String substring1 = str.substring(0,n1);
            String substring2 = str.substring(n1+ 1, n2);
            String substring3 = str.substring(n2+1);

            String letter1 = str.substring(n1,n1+1);
            String letter2 = str.substring(n2, n2+1);

            return (substring1 + letter2 + substring2 + letter1 + substring3);


        }

        public static ArrayList<String> nPermute(ArrayList<String> permutations, String str, int length, String current) {

            if(current.length() == length) {
                permutations.add(current);
            } else {
                for (int i = 0; i < str.length(); i++) {
                    if (!current.contains(String.valueOf(str.charAt(i)))) {
                        nPermute(permutations, str, length, current + String.valueOf(str.charAt(i)));
                    }
                }
            }

            return permutations;

        }

        public static int combinations(int n, int r) {
            if (n == 1) {
                return 1;
            } if (r == 1) {
                return n;
            } if (n == r) {
                return 1;
            } else {
                return combinations(n-1, r-1) + combinations(n-1,r);
            }
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