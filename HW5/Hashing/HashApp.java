import java.util.ArrayList;
import java.util.Map;

public class HashApp {
	private static final String regexFilter = "[^'\\-A-Za-z]";

	public static void main(String[] args) {
		ArrayList<String> words = ReadFile.parseWords("./HW5/txts/Moby-Dick-Chapter-1-groomed.txt", regexFilter);
		hashTable(words);
	}
	
	/**
	 * Generates the Hashtable object
	 * @param words the parsed words from the file
	 */
	private static void hashTable(ArrayList<String> words){
		HashTable ht = new HashTable(997);
		for (String word : words) {
			ht.put(word);
			if(ht.getLoadFactor() == 1) break;
		}
		System.out.printf("%-12s|%-20s|%10s\n--------------------------------------------\n", "Hash Address", "Hashed Word", "Hash Value");
		for (int i = 0; i < ht.getSize(); i++) {
			System.out.printf("%-12d|%-20s|%10d\n", i, ht.get(i), ht.get(i).equals("") ? -1 : Hash.hashString(ht.get(i)));
		}

		System.out.printf("There are %d distinct entries in the hash table\n", ht.getOccupied());
		System.out.printf("    Of these, %d land in their appropriate spots, i.e. without drifting.\n", ht.getCorrectPositionCount());
		System.out.printf("There are %d open cells in the hash table.\n", ht.getSize() - ht.getOccupied());
		System.out.printf("The load factor (alpha) is thus %f for our hash table.\n\n", ht.getLoadFactor());

		final int[] lor = ht.getLongestOpenRun();
		System.out.printf("The longest run of open cells is %d entries long:\n    Position %d to position %d (inclusive)\n\n", lor[0], lor[1], lor[2]);

		final int[] lc = ht.getLongestCluster();
		System.out.printf("The longest cluster is %d entries long:\n    Position %d to position %d (inclusive).\n\n", lc[0], lc[1], lc[2]);

		final int[] mo = ht.getMaxOccurence();
		System.out.printf("Hash value %d occurs %d times.\n\n", mo[0], mo[1]);

		final Map.Entry<String, Integer> md = ht.getMaxDrift();
		System.out.printf("The word '%s' drifts more than any other word,\n    %d places from the correct hash address %d at position %d.", md.getKey(), md.getValue(), Hash.hashString(md.getKey()), md.getValue());
	}
}
