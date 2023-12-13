import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class HashTable {
	private final int SIZE;
	private final String[] strings;
	private int occupied;
	private final int[] hashOccurence;
	private final HashMap<String, Integer> wordOffset = new HashMap<>();

	/**
	 * Constructor for the hash table
	 * @param size the size of the hash table
	 */
	public HashTable(int size) {
		this.SIZE = size;
		this.strings = new String[SIZE];
		this.hashOccurence = new int[SIZE];
	}

	/**
	 * Inserts a string into the hashtable
	 * @param s string to be inserted into the hash table
	 */
	public void put(String s){
		int hash = Hash.hashString(s);
		int index = hash;
		int offset = 0;
		hashOccurence[hash]++;

		while(strings[index % SIZE] != null){ // circular indexing
			//System.out.println("Collision at index " + index % SIZE + " for word " + s);
			index++;
			offset++;
		}

		strings[index % SIZE] = s;
		occupied++;
		wordOffset.put(s, offset);
	}

	/**
	 * Gets the percentage of occupied slots in the hash table
	 * @return the percentage of slots that are occupied.
	 */
	public float getLoadFactor(){
		return (float) occupied / SIZE;
	}

	/**
	 * Gets the string at the given hash index
	 * @param index the index of the string to be retrieved
	 * @return the string at the given index
	 */
	public String get(int index){
		return (strings[index] != null) ? strings[index] : "";
	}   

	/**
	 * Gets the size of the hash table
	 * @return the size of the hash table
	 */
	public int getSize(){
		return SIZE;
	}
	
	/**
	 * Gets the number of occupied slots in the hash table
	 * @return the number of occupied slots in the hash table
	 */
	public int getOccupied(){
		return occupied;
	}

	/**
	 * Gets the number of times a hash value has occured
	 * @return the Maximum hash value and the number of times it occured
	 */
	public int[] getMaxOccurence(){
		int max = 0;
		for (int i = 1; i < hashOccurence.length; i++) {
			max = hashOccurence[i] > hashOccurence[max] ? i : max;
		}

		return new int[] {max, hashOccurence[max]};
	}

	/**
	 * Gets the number of strings that are in their correct position
	 * @return the number of strings that are in their correct position
	 */
	public int getCorrectPositionCount(){
		int count = 0;
		for (int i = 0; i < strings.length; i++) {
			if(strings[i] != null && Hash.hashString(strings[i]) == i) count++;
		}
		return count;
	}

	/**
	 * Gets the longest area of open slots in the hash table.
	 * @return the longest open run of empty slots in the hash table as [length, start, end]
	 */
	public int[] getLongestOpenRun(){
		int longestRun = 0;
		int start = 0;
		int end = 0;
		int currentRun = 0;
		for (int i = 0; i < strings.length; i++) {
			if(strings[i] == null){
				currentRun++;
			} else {
				if(currentRun > longestRun){
					longestRun = currentRun;
					start = i - currentRun;
					end = i;
				}
				currentRun = 0;
			}
		}
		return new int[] {end - start, start, end - 1};
	}

	/**
	 * Gets the longest cluster of strings in the hash table
	 * @return the longest cluster of strings in the hash table as [length, start, end] 
	 */
	public int[] getLongestCluster(){
		int startPointer = 0;
        int pointerOffset = 0;

        for (int i = 0; i < SIZE; i++) {
            int tempPointerOffset = 0;
            while (!(strings[(i + tempPointerOffset) % SIZE] == null)) {
                tempPointerOffset++;
            }
            if (tempPointerOffset > pointerOffset) {
                startPointer = i;
                pointerOffset = tempPointerOffset;
            }
        }
		return new int[] {pointerOffset, startPointer, (startPointer + pointerOffset) % SIZE - 1};
	}

	/**
	 * Gets the word that drifts the most from its hash index
	 * @return the word that drifts the most from its hash index
	 */
	public Map.Entry<String, Integer> getMaxDrift(){
		int maxValue = Collections.max(wordOffset.values());
		Map.Entry<String, Integer> maxDrift = Map.entry("-1", -1);

		for (Map.Entry<String, Integer> entry : wordOffset.entrySet()) {
			if (entry.getValue() == maxValue) {
				maxDrift = entry;
			}
		}
		return maxDrift;
	} 
}