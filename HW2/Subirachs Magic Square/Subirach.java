import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Subirach {
    private static final int[][] MagicSquare = {
            {1, 14, 14, 4},
            {11, 7, 6, 9},
            {8, 10, 10, 5},
            {13, 2, 3, 15}
    };
    private static final int[] flat = Arrays.stream(MagicSquare).flatMapToInt(Arrays::stream).toArray();
    private static final int len = 1 << flat.length;

    private static final int maxValue = IntStream.of(flat).sum();


    public static void main(String[] args) {
        int[][] combinations = powerSet();
        int[] fourSums = countSums(combinations, 4);
        int[] allSums = countSums(combinations);

        int maxSum = 0;
        int maxCount = 0;
        for (int i = 0; i < allSums.length; i++) {
            if (allSums[i] > 0) {
                if (allSums[i] > maxCount) {
                    maxCount = allSums[i];
                    maxSum = i;
                }
            //System.out.printf("%d combinations sum to %d\n", allSums[i], i);
            }
        }
        
        System.out.printf("There were %d sums of four numbers equivilent to 33.\n", fourSums[33]);
        System.out.printf("There were %d total sums equivilent to 33.\n", allSums[33]);
        System.out.printf("The total ammount of combinations is %d\n", len);
        System.out.printf("The sum with the greatest number of combinations is %d with %d combinations\n", maxSum, maxCount);

    }

    private static int[] countSums(int[][] powerSet) {
        int[] sums = new int[maxValue + 1]; // array list of sums
        for (int[] combo : powerSet) {
            int sum  = IntStream.of(combo).sum();
            sums[sum]++;    
        }

        return sums;
    }

    private static int[] countSums(int[][] powerSet, int NumCount) {
        int[] sums = new int[maxValue + 1]; // array list of sums
        for (int[] combo : powerSet) {
            combo = cleanZeros(combo);
            if(combo.length != NumCount) continue;

            int sum  = IntStream.of(combo).sum();
            sums[sum]++;    
        }

        return sums;
    }

    private static int[] cleanZeros(int[] source){
        int targetIndex = 0;

        for(int i = 0;  i < source.length; i++){
            if(source[i] != 0){
                source[targetIndex++] = source[i];
            }
        }

        int[] newArray = new int[targetIndex];
        System.arraycopy(source, 0, newArray, 0, targetIndex);

        if(source.length == 0) return new int[]{0};

        return newArray;

    }

    // https://stackoverflow.com/a/51653562/10483389
    /*
     * Returns the power set from the given set.
     */
    private static int[][] powerSet() {
        List<int[]> subsetsList = new ArrayList<>();
        subsetsList.add(new int[]{});
    
        for (int elem : flat) {
            int len = subsetsList.size();
            for (int j = 0; j < len; j++) {
                int[] subset = Arrays.copyOf(subsetsList.get(j), subsetsList.get(j).length + 1);
                subset[subset.length - 1] = elem;
                subsetsList.add(subset);
            }
        }
    
        int[][] subsets = new int[subsetsList.size()][];
        for (int i = 0; i < subsetsList.size(); i++) {
            subsets[i] = subsetsList.get(i);
        }
    
        return subsets;
    }

}