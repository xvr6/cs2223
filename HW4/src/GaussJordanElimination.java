public class GaussJordanElimination {
    private static double[][] matrix = {
      //x1, x2, x3, x4, x5, x6, x7, x8, x9, solution of row
        {1,  1,  1,  1,  1,  1,  1,  1,  1, 122},  // row 1
        {1,  1,  1,  1,  1, -1, -1, -1, -1, -88},  // row 2
        {1, -1,  1, -1,  1, -1,  1, -1,  1,  32},  // row 3
        {1,  1,  0,  0,  0,  0,  0,  0,  0,   3},  // row 4
        {0,  0,  1,  1,  0,  0,  0,  0,  0,   7},  // row 5
        {0,  0,  0,  0,  1,  1,  0,  0,  0,  18},  // row 6
        {0,  0,  0,  0,  0,  0,  0,  1,  1,  76},  // row 7
        {9, -8,  7, -6,  5, -4,  3, -2,  1,  41},  // row 8
        {1,  1, -1,  1,  1, -1,  1,  1, -1,   0}   // row 9
    };

    public static void main(String[] args) {
        Elimination();

        System.out.println("Solution: ");
        for (double[] row : matrix) { //print solution
            double elem = row[row.length - 1];
            System.out.print((int) Math.round(elem) + " ");

        }
    }  
    
    /**
     * Performs Gauss-Jordan Elimination on the matrix
     */
    private static void Elimination() {
        int len = matrix.length;
        for (int cRow = 0; cRow < len; cRow++) { //for every row
            int pRow = cRow; //set the pivot row to current row
            for (int i = cRow + 1; i < len; i++) { //next row until last row, check max col val
                if (Math.abs(matrix[pRow][cRow]) < Math.abs(matrix[i][cRow])) { //if higher col val is found, set pivot row to that row
                    pRow = i;
                }
            }

            if (pRow != cRow) { //if pivot row is not current row, swap
                double[] temp = matrix[cRow];
                matrix[cRow] = matrix[pRow];
                matrix[pRow] = temp;
            }

            double pivot = matrix[cRow][cRow];
            for (int i = cRow; i <= len; i++) { 
                if (pivot == 1) { //if pivot is 1, skip
                    break;
                } else {  //divide row by pivot
                    matrix[cRow][i] /= pivot;
                }
            }

            for (int row = 0; row < len; row++) {
                if (row == cRow || matrix[row][cRow] == 0) { //skip if row is cRow or val is 0
                    continue;
                }

                double zeroScaler = matrix[row][cRow];
                for (int element = cRow; element <= len; element++) { 
                    matrix[row][element] -= matrix[cRow][element] * zeroScaler;
                }
            }
        }
    }
}