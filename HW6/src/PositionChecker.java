public class PositionChecker {
    
    public static void main(String[] args) {
        int[] t1 = {1,6,8,3,7,4,2,5};
        System.out.println(isLegalPosition(t1, 8));

        int[] t2 = {1,6,8,3,7,0,0,0};
        System.out.println(isLegalPosition(t2, 8));

        int[] t3 = {1,6,8,3,5,0,0,0};
        System.out.println(isLegalPosition(t3, 8));

    }

    /**
     * Checks if the given array of queens is a legal position
     * @param queens the array of queens
     * @param n the size of the board
     * @return true if the queens are in a legal position, false otherwise
     */
    public static boolean isLegalPosition(int[] queens, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(queens[i] == 0 || queens[j] == 0) { //skip if queen is not placed
                    continue;
                }
                if (queens[i] == queens[j]) { //check if queens are in same column
                    return false;
                }
                if (Math.abs(queens[i] - queens[j]) == Math.abs(i - j)) { //check if queens are in same diagonal
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if the given array of queens is a legal position
     * @param queens the array of queens
     * @param n the size of the board
     * @return true if the queens are in a legal position, false otherwise
     */
    public static boolean isSolution(int[] queens, int n) {
        int ctr = 0;
        for (int i = 0; i < n; i++) {
            if(queens[i] == 0) ctr++;
        }
        if(ctr > 0 && ctr != n) return false;
        return true;
    }
}
