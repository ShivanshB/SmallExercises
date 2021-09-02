public class solveSoduko {

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

        public static boolean isThere(int[] array, int value) {
            for (int i: array) {
                if(i == value) {
                    return true;
                }
            }
            return false;
        }

}