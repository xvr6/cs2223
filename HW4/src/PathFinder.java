import java.util.Arrays;
import java.util.stream.IntStream;

public class PathFinder {
    private static int[][] map = {
//vault   1,  2,  3,  4,  5,  6,  7.  8
        {96, 33, 44, 98, 75, 68, 99, 84}, // row 1
        {10, 41,  1, 86, 46, 24, 53, 93}, // row 2
        {83, 97, 94, 27, 65, 51, 30,  7}, // row 3
        {56, 70, 47, 64, 22, 88, 67, 12}, // row 4
        {91, 11, 77, 48, 13, 71, 92, 15}, // row 5
        {32, 59, 17, 25, 31,  4, 16, 63}, // row 6
        {79,  5, 14, 23, 78, 37, 40, 74}, // row 7
        {35, 89, 52, 66, 82, 20, 95, 21}  // row 8
    };
    // this is kept seperately from the map array so that the original map array is not modified.
    private static int[][] summatedMap = new int[map.length][map[0].length];
    static {
        for (int i = 0; i < map[0].length; i++) {
            summatedMap[i] = map[i].clone();
        }
    }

    
    public static void main(String[] args) {
        findPath();
    }

    /**
     * Finds the optimal path through the map
     */
    private static void findPath(){
        int[] path = new int[summatedMap.length + 1];

        //Modify map to contain optimal sums
        for (int row = summatedMap.length - 2; row >= 0; row--) {
            //For each row, find the max sum for each column
            for (int col = 0; col < summatedMap[0].length; col++) {
                int[] posMaxes = new int[3]; 

                //Find max sum for each column
                for (int offset = 0; offset < 3; offset++) {
                    int i = col + (offset - 1);

                    if (i >= 0 && i < summatedMap[0].length) {
                                         //1 row down, 1 col left/right
                        posMaxes[offset] = summatedMap[row + 1][i];
                    }
                }
                //Add max sum to current value
                summatedMap[row][col] += IntStream.of(posMaxes).max().orElseThrow();
            }
        }
        for (int[] row : summatedMap) {
            System.out.println(Arrays.toString(row));
        }

        //Find max value for row N
        int maxSumI = getMaxIndex(summatedMap[0]);
        path[0] = maxSumI; 
        path[path.length - 1] = summatedMap[0][maxSumI];

        //greedy backtrack
        for (int cRow = 0; cRow < map.length - 1; cRow++) {
            int[] posMaxes = new int[3];

            //Find optimal sum for each valid move
            for (int offset = 0; offset < 3; offset++) {
                int index = maxSumI + (offset - 1);

                //Check if index is valid
                if (index >= 0 && index < summatedMap[0].length) {
                    posMaxes[offset] = summatedMap[cRow + 1][index];
                }
            }

            maxSumI += getMaxIndex(posMaxes) - 1;
            path[cRow + 1] = maxSumI;
        }

        System.out.printf("Starting vault number: %d \n", (path[0] + 1));
        System.out.printf("Total number of gems collected: %d\n", path[path.length - 1]);
        System.out.printf("Final vault number: %d\n", (path[path.length - 2]));
        System.out.println("Path of tiles from start to finish: ");

        for (int i = 0; i <= path.length -2; i++) {
            System.out.printf("(Row %d, Vault %d) - Contains %d Gems\n", i + 1, (path[i] + 1), map[i][path[i]]);
        }
    }

    /**
     * Returns the index of the max value in an array
     * @param arr array to search
     * @return index of max value
     */
    private static int getMaxIndex(int[] arr) {
        int maxSumIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            maxSumIndex = arr[i] > arr[maxSumIndex] ? i : maxSumIndex;
        }
        return maxSumIndex;
    }
}