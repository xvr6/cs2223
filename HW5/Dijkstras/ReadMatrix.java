import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadMatrix {

    /**
     * Parses a square matrix from a file.
     * @param filename the file to parse
     * @param regexFilter the regex to filter out seperators
     * @return a 2d array of the matrix
\     */
    public static int[][] parseSquareMatrix(String filename, String regexFilter) {
        ArrayList<Integer> values = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(!line.isEmpty()){
                    // remove seperators and replace with whitepsace for parsing
                    line = line.replaceAll(regexFilter, " "); 

                    String[] raw = line.split("\\s");
                    for(String s : raw){
                        if(s.isEmpty()) continue;
                        values.add(Integer.parseInt(s));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Invalid file");
        }

        // Convert into a 2d array
        int size = (int) Math.sqrt(values.size()); // since its a sqaure matrix, will always be n^2 entries.
        int[][] matrix = new int[size][size];
        for (int i = 0; i < values.size(); i++) {
            int row = i / size;
            int col = i % size;
            matrix[row][col] = values.get(i);
        }

        return matrix;
    }
}