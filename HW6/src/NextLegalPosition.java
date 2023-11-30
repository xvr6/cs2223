import java.util.Arrays;
public class NextLegalPosition {
    
    public static void main(String[] args) {
        // int[] t1 = {1,6,8,3,5,0,0,0};
        // System.out.println(Arrays.toString(nextLegalPosition(t1))); // (1 6 8 3 7 0 0 0)
        // int[] t2 = {1,6,8,3,7,0,0,0};
        // System.out.println(Arrays.toString(nextLegalPosition(t2))); // (1 6 8 3 7 4 0 0)
        // int[] t3 = {1,6,8,3,7,4,2,5};
        // System.out.println(Arrays.toString(nextLegalPosition(t3))); // (1 6 8 5 0 0 0 0)

        int[] recurse = {0,0,0,0};
        int ctr = 0;

        while (true) {
            ctr++;
            recurse = nextLegalPosition(recurse);
            System.out.println(Arrays.toString(recurse));
            if(recurse[0] == 0) {
                System.out.println(ctr + " legal positions found.");
                break;
            }
        }
    }

    public static int[] nextLegalPosition(int[] queens) {
        int[] nextPos = queens.clone();
        for (int i = nextPos.length - 1; i >= 0; i--) {
            // if this entry AND the previous entry are 0, skip
            if (nextPos[i] == 0 && i != 0 && nextPos[i - 1] == 0) continue;

            while (nextPos[i] <= nextPos.length - 1) {
                nextPos[i] += 1;
                if (PositionChecker.isLegalPosition(nextPos, queens.length)) {
                    return nextPos;
                }
            }
            nextPos[i] = 0;
        }
        return nextPos; 
    }
}