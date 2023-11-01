import java.util.Scanner;
import java.util.LinkedList;
import java.util.Random;

public class Game {
    private static GameData gameData;
    private static Scanner in = new Scanner(System.in);
    static Random ran = new Random();

    public static void main(String[] args) {
        newGame();
    }
    
    private static void newGame(){ // creates a new game.
        gameData = new GameData(); // initalize the GameData object.
        System.out.println("Do you wish to go first, or do you want the computer to do a random turn? [P/C]");
        while(true){ //wait until input is valid.
            switch (in.nextLine().toUpperCase()){
                case "P":
                    playerTurn();
                    break;
                case "C":
                    computerTurn();
                    break;
                    //possibly add new imput D for debugging, and a 4th input for computer v computer.
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private static void playerTurn(){ // prompts for player input and then calls computerTurn().
        int g = gameData.getMarkers("G");
        int y = gameData.getMarkers("Y");
        int o = gameData.getMarkers("O");

        if(g == 0 && y == 0 && o == 0){ // all markers are 0, player has won.
            System.out.println(String.format("The computer has removed the last marker and won after %d turns!", gameData.turnNumber()));
            playAgain();
        } else {
            String removeColor = "";
            int ammount = 0;
            System.out.println(gameData.stringify()); //display the current state of the game.
            while(true){ //wait until input is valid.
                System.out.println("What marker set would you like to take from ([G]reen, [Y]ellow or [O]range)");
                removeColor = in.nextLine().toUpperCase();
                if(removeColor.equals("G") || removeColor.equals("Y") || removeColor.equals("O")){
                    if(gameData.getMarkers(removeColor) != 0){ 
                        break;
                    } 
                    System.out.println("There are no markers of that color left!");
                } else {
                    System.out.println("Invalid input!");
                }
            }
        
            while(true){ //wait until input is valid.
                System.out.println(String.format("How many of the colors marker would you like to remove? (up to %d)", gameData.getMarkers(removeColor)));
                try { //try to parse the input as an integer.
                    ammount = Integer.parseInt(in.nextLine());
                } catch (NumberFormatException e) { //means this is not an integer input.
                    System.out.println("Please enter a valid integer!");
                    continue;
                }

                if (ammount <= 0) {
                    System.out.println("You must remove at least one marker!");
                } else if(gameData.getMarkers(removeColor) < ammount){
                    System.out.println("There are not enough markers left for that deduction!");
                } else {
                    break;
                }
            }

            //all input tests have passed, now to remove the markers and continue to the computers turn.
            gameData.removeValue(true, removeColor, ammount);
            computerTurn();

        }
    }


    private static void computerTurn(){ // automatically determines the best possible removal, then calls playerTurn().
        int g = gameData.getMarkers("G");
        int y = gameData.getMarkers("Y");
        int o = gameData.getMarkers("O");

        if(g == 0 && y == 0 && o == 0){ // all markers are 0, player has won.
            System.out.println(String.format("You have removed the last marker and won after %d turns!", gameData.turnNumber()));
            playAgain();
        } else {
            int nimSum = g ^ y ^ o;

            if(gameData.turnNumber() == 1) { 
                // if it is the computers first turn, it will remove a random ammount from a random color.
                // 
                randomComputerTurn();
            } else {
                if(nimSum != 0){
                    while(true){
                        if(g != 0 && (g ^ nimSum) < g){
                            gameData.removeValue(false, "G", g - (g ^ nimSum));
                            break;
                        } else if(y != 0 && (y ^ nimSum) < y){
                            gameData.removeValue(false, "Y", y - (y ^ nimSum));
                            break;
                        } else if(o != 0 && (o ^ nimSum) < o){
                            gameData.removeValue(false, "O", o - (o ^ nimSum));
                            break;
                        } else { // decreases ammount to be removed if it is too high.
                            nimSum = nimSum >> 1;
                        }
                    }
                    
                    playerTurn();
                } else {
                    randomComputerTurn();
                }
            }
        }  
    }

    private static void randomComputerTurn(){
        LinkedList<String> validColors = new LinkedList<>();
        //Add all colors with non-zero marke count into the list.
        if(gameData.getMarkers("G") != 0) validColors.add("G");
        if(gameData.getMarkers("Y") != 0) validColors.add("Y");
        if(gameData.getMarkers("O") != 0) validColors.add("O"); 

        String removeColor = validColors.get(ran.nextInt(validColors.size()));
        // + 1 to ensure it cant reomve 0, and can remove total.
        Integer ammount = ran.nextInt(gameData.getMarkers(removeColor)) + 1;
        gameData.removeValue(false, removeColor, ammount);

        playerTurn();
    }

    private static void playAgain(){
        System.out.println("Would you like to play again? [Y/<any>]");
        String input = in.nextLine().toUpperCase();
        if(input.equals("Y")){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nStarting the new game...");
            newGame();
        } else {
            System.exit(0);
        }
    }
}