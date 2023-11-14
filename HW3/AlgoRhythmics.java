import java.util.ArrayList; 
import java.util.Collections;


public class AlgoRhythmics {

    public static void main (String[] args) {
        String[] names = {"Alfie", "Berty", "Crizz", "Dietz", "Elmer", "Fleek", "Gomer"};

        ArrayList<String> L = BRGC(names.length);
        String seperator = "------------------------------------------------------------------------------------%n";
        
        //create the table
        System.out.printf("" + seperator);
        System.out.printf("| %-5s | %-9s | %-45s | %-12s |%n", "Index", "Gray Code", "Players Playing", "Action");
        System.out.printf("" + seperator);
        for (int i = 0; i < L.size(); i++) {
            System.out.printf("| %-5s | %-9s | %-45s | %-12s |%n", i, L.get(i), getPlayersPlaying(L.get(i), names), getAction(L, i, names));
        }   
        System.out.printf("" + seperator);
    } 

    /**
     * Returns the gray code.
     * @param n the number of players
     * @return the gray code
     */
    public static ArrayList<String> BRGC(int n) {
        if (n == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        } else {
            ArrayList<String> list = BRGC(n - 1);
            ArrayList<String> newList = new ArrayList<>(list);
            Collections.reverse(newList);
            for (int i = 0; i < list.size(); i++) {
                list.set(i, "0" + list.get(i));
                newList.set(i, "1" + newList.get(i));
            }
            list.addAll(newList);
            return list;
        }
    }

    /**
     * Returns the players playing based on the gray code.
     * @param grayCode the gray code
     * @param names the names of the players
     * @return the players playing
     */
    public static String getPlayersPlaying(String grayCode, String[] names){
        String playersPlaying = "";
        for (int i = 0; i < grayCode.length(); i++) {
            if (grayCode.charAt(i) == '1') {
                playersPlaying += names[names.length - 1 - i] + " ";
            }
        }
        if(playersPlaying.equals("")) playersPlaying = "SILENT STAGE";
        return playersPlaying;
    }

    /**
     * Returns the players playing based on the gray code.
     * @param grayCodes the gray code list
     * @param codeNumber the index of the gray code
     * @param names the name of the player and their action
     * @return the players playing
     */
    public static String getAction(ArrayList<String> grayCodes, int codeNumber,  String[] names){
        if(codeNumber == 0){
            return "SILENCE";
        }
        String grayCode = grayCodes.get(codeNumber);
        String compareCode = grayCodes.get(codeNumber - 1);

        for (int i = 0; i < grayCode.length(); i++) {
            if (grayCode.charAt(i) == '1' && compareCode.charAt(i) == '0') {
                return String.format("%s Joins", names[names.length - 1 - i]);
            } else if (grayCode.charAt(i) == '0' && compareCode.charAt(i) == '1'){
                return String.format("%s Leaves", names[names.length - 1 - i]);
            }
        }
        return " ";
    }

}