import java.util.Arrays;

public class FastInversionCount {
    
    private static int[] example = {1, 2, 3, 4, 5, 6, 7, 8}; // should be 0
    private static int[] example2 = {8, 7, 6, 5, 4, 3, 2, 1}; // should be 28
    private static int[] example3 = {1, 3, 5, 2, 4, 6}; // should be 3
 
    
    public static void main(String[] args) {
        System.out.println(mergeSort(example, 0, example.length - 1));
        System.out.println(mergeSort(example2, 0, example2.length - 1));
        System.out.println(mergeSort(example3, 0, example3.length - 1));
    }
    
    /**
     * Counts the number of inversions in an array. Time complexity is O(nlogn).
     * @param arr the array to count inversions in
     * @param left the left index of the array
     * @param right the right index of the array
     * @return the number of inversions in the array
     */
    public static int mergeSort(int[] arr, int left, int right) {
        int countInv = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            countInv += mergeSort(arr, left, mid);
            countInv += mergeSort(arr, mid + 1, right);
            countInv += mergeCounterHelper(arr, left, mid, right);
        }

        return countInv;
    }

    // counting the inversion when merging arrays
    private static int mergeCounterHelper(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0;
        int j = 0;
        int k = left;
        int swaps = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                swaps += (mid + 1) - (left + i);
            }
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

        return swaps;
    }
}