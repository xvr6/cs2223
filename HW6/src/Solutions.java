import java.util.Arrays;

public class Solutions {

    public static void main(String[] args){
        //nextSol(new int[8]);
        allSol(10);
    }
    
    private static int[] nextSol(int[] queens){
        while (true) {
            queens = NextLegalPosition.nextLegalPosition(queens);
            if(PositionChecker.isSolution(queens, queens.length)) {
                return queens;
            }
        }
    }

    private static void allSol(int n){
        int[] queens = new int[n];
        while (true) {
            queens = nextSol(queens);
            if(queens[0] == 0) break;
            System.out.println(Arrays.toString(queens));
        }
    }
}
