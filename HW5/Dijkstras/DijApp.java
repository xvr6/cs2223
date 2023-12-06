import java.util.Scanner;
import java.util.Arrays;

public class DijApp {

    public static void main(String[] args) {
        try {
            final int[][] matrix = ReadMatrix.parseSquareMatrix("./HW5/txts/DijkstrasAlgorithmDataB23.txt", "[^0-9]");
            
            // Prompt for starting and ending position
            Scanner input = new Scanner(System.in);

            System.out.println("Enter a starting and ending location (0-9)");
            int start = input.nextInt();
            int end = input.nextInt();
            input.close();

            System.out.printf("The shortest path from '%s' (index: %d) to '%s' (index: %d) is:\n",  indexToEntry(start), start, indexToEntry(end), end);
            int[] path = dijkstra(matrix, start, end);
            
            for(int i = path.length - 1; i >= 0; i--){
                int cur = path[i];
                if(cur != -1) System.out.printf("%s (%d), ", indexToEntry(cur), cur);
            }
            System.out.print("| Length of: " + getPathLength(matrix, path));
            

        } catch (Exception e) {// invalid file
            System.err.println(e.getMessage());
        }
    }
    /**
     * Calculates the sortest path between 2 entries in a square matrix representation of a weighted graph
     * @param matrix The square matrix
     * @param start The starting location of the algorithm
     * @param end The location you want to get to 
     * @return The shortest path to get to that location
     */
    public static int[] dijkstra(int[][] matrix, int start, int end){
        int[] path = new int[matrix.length];
        int[] dist = new int[matrix.length];
        boolean[] visited = new boolean[matrix.length];

        // Initialize
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[start] = 0;
        path[start] = -1;

        // Find shortest path
        for (int i = 0; i < dist.length; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < dist.length; v++) {
                if(!visited[v] && matrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + matrix[u][v] < dist[v]){
                    dist[v] = dist[u] + matrix[u][v];
                    path[v] = u;
                }
            }
        }

        //make the values more easily manipulateable by other programs
        int[] cleanedPath = new int[matrix.length];
        Arrays.fill(cleanedPath, -1);
        
        int current = end;
        int ctr = 0;
        while(current != -1){
            cleanedPath[ctr] = current;
            ctr++;
            current = path[current];
        }

        return cleanedPath;
    }

    /**
     * Gets the length of the given path.
     * @param path the path 
     * @return the length of that path
     */
    public static int getPathLength(int[][] matrix, int[] path){
        int pathCtr = 0;
        for(int i = 0; i < path.length - 1; i++){ // goes from 0, to ending of list - 2 so i wont overflow index.
            if(path[i] == -1 || path[i + 1] == -1) continue;
            pathCtr += matrix[path[i]][path[i + 1]];
        }
        return pathCtr;

    }

    /**
     * Finds the index of the minimum distance in the array.
     * @param dist the array to search
     * @param visited the array of visited nodes
     * @return the index of the minimum distance
     */
    public static int minDistance(int[] dist, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < dist.length; i++) {
            if(!visited[i] && dist[i] <= min){
                min = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    /**
     * Converts an index number to the letter representation
     * @param index the index number
     * @return the string value
     */
    public static String indexToEntry(int index){
        String[] values = {"A", "J", "M", "R", "K", "S", "I", "N", "T", "D"};
        return values[index];
    }
}