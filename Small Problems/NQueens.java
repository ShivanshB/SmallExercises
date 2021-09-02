public class NQueens {

    public static int nQueensCounter = 0;
    
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
}