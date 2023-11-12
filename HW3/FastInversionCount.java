import java.util.Scanner;
import java.util.Arrays;

public class FastInversionCount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        while(true){
            System.out.println("Enter Size of Array:");
            try {
                n = Integer.parseInt(in.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }

        }

        int[] arr = new int[n];

        System.out.println("\nEnter Array:");
        for (int x = 0; x < n; x++){
            while(true){
                try {
                    arr[x] = Integer.parseInt(in.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                }
            }
        }

        System.out.println("\nInversion Count:" + mergeSort(arr, 0, arr.length - 1));
    }

    private static int mergeSort(int[] arr, int left, int right) {
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

        int i = 0, j = 0, k = left, swaps = 0;

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