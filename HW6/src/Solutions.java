import java.util.Arrays;

public class Solutions {
	public static void main(String[] args){
		//nextSol(new int[8]);
		for(int i = 4; i <= 14; i++){
			allSol(i, false);
		}
	}

	private static int[] nextSol(int[] queens){
		while (true) {
			queens = NextLegalPosition.nextLegalPosition(queens);
			if(PositionChecker.isSolution(queens, queens.length)) {
				return queens;
			}
		}
	}

	private static void allSol(int n, boolean logging){
		int[] queens = new int[n];
		int ctr = 0;
		while (true) {
			queens = nextSol(queens);
			if(queens[0] == 0) break;
			ctr++;
			if(logging) System.out.println(Arrays.toString(queens));
		}
		System.out.printf("%d legal %d-Queen positions found.\n", ctr, n);
	}
}