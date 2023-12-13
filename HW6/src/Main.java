import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		for(int i = 4; i <= 32; i++){
			System.out.printf("First legal position for %d-Queens: %s\n", i, Arrays.toString(nextSol(new int[i])));
		}
		for(int i = 4; i <= 17; i++){
			solCtr(i);
		}
	}

	private static int[] nextSol(int[] queens){
		while (true) {
			queens = PositionChecker.nextLegalPosition(queens);
			if(PositionChecker.isSolution(queens, queens.length)) {
				return queens;
			}
		}
	}

	private static void solCtr(int n){
		int[] queens = new int[n];
		int ctr = 0;
		while (true) {
			queens = nextSol(queens);
			if(queens[0] == 0) break;
			ctr++;
		}
		System.out.printf("%d legal %d-Queen positions found.\n", ctr, n);
	}
}