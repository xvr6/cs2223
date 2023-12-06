# HW5 - Closed Hashing and Dijkstra's Algorithm

## `./Hashing`
- Using a Closed Hashing/Open Addressing algorithm, hashes `./txts/Moby-Dick-Chapter-1-groomed.txt` into a 997 length table.
- Once the file is hashed, calculates and prints out information about the HashTable:
    - Distinct entry count and the count of which land and in their correct spot
    - Open cells count and the load factor (alpha) associated with this
    - The longest run of open cells, and the positions that that run starts and ends with.
    - The longest cluster of filled entries long, and the positions that cluster starts and ends.
    - The hash value that occurs the most times and the count.
    - What word drifts the farthest in the table and the distance of said drift.

## `./Dijkstras`
- Prompts the user to enter the beginning and end location they wish to travel between on a weighted graph
- This graph is represented `./txts/DijkstrasAlgorithmDataB23.txt` as a square matrix, though an image version can be found [here](https://imgur.com/a/x91fwL0)
- Using Dijkstras algorithm, finds the shortest path between the two given locations and prints out the path, and its length.
