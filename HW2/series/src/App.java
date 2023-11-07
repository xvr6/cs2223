import java.util.Scanner;

public class App {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    private static void start(){
        double[] lucas = {2d, 1d};
        double[] fibonacci = {1d, 1d};
        NumberSeries series;
        int n;

        System.out.println("Please select a series to calculate:\n1. Lucas Series\n2. Fibonacci Series\n3. Custom Series");

        while(true){
            switch(in.nextLine()){
                case "1":
                    series = new NumberSeries(lucas);
                    break;
                case "2":
                    series = new NumberSeries(fibonacci);
                    break;
                case "3":
                    series = customSeriesInput();
                    break;
                default:
                    System.out.println("Please enter a valid selection!");
                    continue;
                } 
                break;
            }

        System.out.println("Please enter the number you would like to calcualte in the series: (must be positive)");
        while(true){
            try {
                n = Integer.parseInt(in.nextLine());
                if(n < 0){
                    System.out.println("Please enter a positive number!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }
            break;
        }

        System.out.println("Would you like to [T]ime the calculation, or [C]ompare the time of successive calculations?");
        while(true){
            switch(in.nextLine().toUpperCase()){
                case "T":
                    Timed nCalculation = timed(series, n);
                    System.out.println("It took: " + nCalculation.time + "ms");
                    break;
                case "C":
                    timedSuccessive(series, n);
                    break;
                default:
                    System.out.println("Please enter a valid selection!");
                    continue;
                } 
                break;
            }

    }
   
    /**
     * Prompts the user for a custom series and its n0 and n1 values.
     * @return the customized NumberSeries object.
     */
    private static NumberSeries customSeriesInput(){
        double[] custom;
        double n0;
        double n1;

        System.out.println("Please enter the first number in the series:");
        while(true){ // wait until input is valid.
            try {
                n0 = Double.parseDouble(in.nextLine());
                break;
            } catch (NumberFormatException e) { //means this is not a double input.
                System.out.println("Please enter a valid number!");
            }
        }

        System.out.println("Please enter the second number in the series:");
        while(true){ // wait until input is valid.
            try {
                n1 = Double.parseDouble(in.nextLine());
                break;
            } catch (NumberFormatException e) { //means this is not a double input.
                System.out.println("Please enter a valid number!");
            }
        }

        custom = new double[]{n0, n1};
        return new NumberSeries(custom);
    }

    /**
     * Times the calculation of the nth number in the series.
     * @param series The series to calculate.
     * @param n The number to calculate until.
     * @return A Timed object containing time, and num-value.
     */
    private static Timed timed(final NumberSeries series, final int n){
        long startTime = System.currentTimeMillis();
        int calculated = (int) series.calculate(n);
        long endTime = System.currentTimeMillis();

        return new Timed((endTime - startTime), calculated);
    }

    private static void timedSuccessive(final NumberSeries series, final int n){
        double n1Time = timed(series, n + 1).time;
        System.out.println(n1Time);

        double nTime = timed(series, n).time;
        System.out.println(nTime);

        double timeRatio = n1Time / nTime;

        System.out.println(String.format("The ratio of %d (%.2f) to %d (%.2f) is %.4f", (n + 1), n1Time, n, nTime, timeRatio));

    }
}
