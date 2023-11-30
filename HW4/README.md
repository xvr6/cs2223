# HW4 - Gauss-Jordan Elimination & Dynamic Programming

## Part 1) Questions from HW doccument
- The repaired ForwardAlgorithm is not able to do row swaps, therefor is unable to solve the matrix provided. The BetterFowardAlgorithm is able to do this.
- The BetterForwardAlgorithm doesn't work because as  matrix is linearly dependant. Upon doing math on this row it gets a 0/0.
- To fix this, we munst check weither the pivot is a 0. If it is, move over a column.

## Part 2) `./src/GaussJordanElimination.java`
- Performs Gauss Jordan Elimination on a given matrix. 
- Will print out the solutions for each column once complete.

## Part 3) `./src/PathFinder.java`
- This file will perform a greedy backtrack algoithm to find the optimal path (path with the most 'Gems')
### Criteria:
- Begins by collecting the gems on a square in Row 1, and then advances to the next Row.
- The space directly ahead of the current chosen, or diagnally to the left or right is a viable choice (assuming it exists).
- Collects the gems from the newly-visited square, and repeats the process until collecting gems from row 8

