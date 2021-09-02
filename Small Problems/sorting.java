public class sorting {

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

    public static double[] mergeSort(double[] array, int start, int end) {
    	if (start == end) {
    		return array;
    	} else {
            mergeSort(array, start, (start+end)/2);
    		mergeSort(array, ((start+end)/2)+1, end);
    		merge(array, start, (start+end)/2, end);
    	}

    	return array;
    }

    public static void merge(double[] array, int start, int middle, int end) {

    	int Lindex = start;
    	int Rindex = middle + 1;
        int mid = middle;

    	for(int i = start; i <= end; i++) {

    		if(Lindex > mid) {
    			Rindex++;
    		} else if (Rindex == end + 1) {
    			Lindex++;
    		} else if(array[Lindex] <= array[Rindex]) {
    			Lindex++;
    		} else if (array[Lindex] > array[Rindex]) {
    			double temp = array[Rindex];

    			for (int j = Rindex; j > i; j--) {
    				array[j] = array[j-1];
    			}
    			array[i] = temp;
                Rindex++;
    			Lindex++;
                mid++;

    		}
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

        int largerCounter = 0;
        double pivot = array[end];

        for (int i = end-1; i >= start; i--) {
            if (array[i] > pivot) {

                largerCounter++;

                double temp = array[i];

                for (int j = i; j < end; j++) {
                    array[j] = array[j+1];
                }
                array[end] = temp;
            }
        }

        return end-largerCounter;
    }

}