public class NumberSeries {
    private double n0; // The first Lucas number
    private double n1; // The second Lucas number

    /**
     * Initalizes the class.
     * @param n0 The first number in the series.
     * @param n1 The second number in the series. 
     */
    public NumberSeries(double[] ns) {
        //should be 2 and 1 for lucas numbers.
        this.n0 = ns[0];
        this.n1 = ns[1];
    }

    /**
     * Calculates the nth number in the series.
     * @param n The number to calculate.
     * @return The nth number in the series.
     */
    public double calculate(double n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater than or equal to 0");
        } else {
            return calculateHelper(n);
        }

    }

    /**
     * Helper function for calculate.
     * @param n The number to calculate.
     * @return The nth number in the series.
     */
    private double calculateHelper(double n) {
        if (n == 0) {
            return n0;
        } else if (n == 1) {
            return n1;
        } else {
            return calculateHelper(n - 1) + calculateHelper(n - 2);
        }
    }
}
