## Java v16

This project uses Java v16. If there are any issues in launch, please make sure you are running v16.

## Specifications

- Upon running main in `src/Game.java`, a game of Nim with 3 green, 7 yellow and 5 orange will be played.
- The user will be prompted to select if they wish to go first, or to let the computer go first.
- When the computer is in a loosing position/its first turn, it will make a random, non-zero move.
- When the computer is in a winning positiion/not in a zero position (its calculated nimsum of g^y^o != 0), it will make a caltulated best move.
- When it is the players turn, they will be prompted for a color, then the ammount of that color they wish to remove via the console.
- Once each of the markers are gone, the player who removed the last marker is considered the winner. 
- They are then prompted to restart the game, or to quit.
