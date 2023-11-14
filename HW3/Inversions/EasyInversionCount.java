public class EasyInversionCount {

    private static int[] example = {1, 2, 3, 4, 5, 6, 7, 8}; // should be 0
    private static int[] example2 = {8, 7, 6, 5, 4, 3, 2, 1}; // should be 28
    private static int[] example3 = {1, 3, 5, 2, 4, 6}; // should be 3
 
    
    public static void main(String[] args) {
        System.out.println(countInversions(example));
        System.out.println(countInversions(example2));
        System.out.println(countInversions(example3));
    }

    /**
     * Counts the number of inversions in an array. Time complexity is O(n^2).
     * @param arr the array to count inversions in
     * @return the number of inversions in the array
     */
    
    public static int countInversions(int[] arr) {
        int inversions = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) inversions++;
            }
        }
        return inversions;
    }
}