import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class ReadFile {
    public static ArrayList<String> parseWords(String filename, String regexFilter) throws Exception {
        ArrayList<String> words = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {

                if(!line.isEmpty()){

                    String[] raw = line.split("\\s");

                    for(String s : raw){
                        String potentialWord = s.replaceAll(regexFilter, " ");
                        for(String word : potentialWord.split(" ")){
                            word = word.trim();
                            if(word.isEmpty()) continue;
                            if(words.contains(word)) continue;

                            words.add(word);
                        }
                    }
                }
            }
        return words;
    }
}