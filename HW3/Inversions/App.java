import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        while(true){ // prompt for array length.
            System.out.println("How long would you like your array to be?");
            try {
                n = Integer.parseInt(in.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }

        }

        int[] arr = new int[n];
        System.out.println("\nEnter your array:\nPlease note that the array will sort from least to greatest.");
        for (int x = 0; x < n; x++){ // prompt for each element of the array.
            while(true){
                try {
                    arr[x] = Integer.parseInt(in.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                }
            }
        }

        System.out.println("\nYour array is: ");
        for (int x = 0; x < n; x++){ // print the array.
            System.out.print(arr[x] + " ");
        }
        System.out.println("\nPlease enter algorithm you would like to use: [E]asyInversionCount, or [F]astInversionCount:");
        
        while(true){
            String input = in.nextLine().toUpperCase();
            if(input.equals("E")){
                System.out.println("There were " + EasyInversionCount.countInversions(arr) + " inversions in this array.");
                break;
            } else if(input.equals("F")){
                System.out.println("There were " + FastInversionCount.mergeSort(arr, 0, arr.length - 1) + " inversions in this array.");
                break;
            } else {
                System.out.println("Invalid input. Please enter either E or F.");
            }
            
        }
        in.close();
    }    
}
