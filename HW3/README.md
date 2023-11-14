# HW3 - Palindromes, Inversions (Sorting Algorithms), and BRGC
## Part 1) `./PalindromeCheck`
- Checks if a string of any length is a palindrome
- Filters any non-alphabetical character out of the string with regex
- Reccursively substrings(1, length - 1) until reaches 0 or a non equivilent 0 and length - 1 position

## Part 2) `./Inversions/App.java`
- Checks how many inversions are in a least-to-greatest list
> [!Note]
> Ex) (3, 2, 1) => (3, 2), (3, 1), (2, 1) = 3 inversions
- Prompts for input of an integer which coresponds to the length of the array
- Then, prompts for the user to enter all the elements of their array as seperate lines.
- Finally, prompts for the user to choose which algorithm they would like to use, then prints out the inversion count the chosen algorithm chooses.
### Type E: `./Inversions/EasyInversionCount`
- Algorithm that itterates over the loop and compares every entry using two for loops.
- Time-Complexity of this algorithm is near O(n^2)
- Counts and reurns the number of inversions.
### Type F: `./Inversions/FastInversionCount`
- MergeSort Algorithm that splits the unsorted list into n subsets containing one element and repeaditly merges them back into a new list in sorted order.
- Each swap is calculated mathmatically by detecting how 'incorrect' the positioning the entry in the unsorted array was.
- Sums this all up, then returns the number of inversions. 

## Part 3) `./AlgoRhythmics`
- This is a BRGC algorithm that makes every possible subset of a fictitious music group of 7 members.
- Makes an ArrayList<String> of binary numbers up to 2^n - where n is size of the group.
- Uses these numbers to determine which members of the band are currently on stage.
- Uses checks current binary number and previous to determine which member is entering the stage or which one is leaving.