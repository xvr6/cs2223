import java.util.Scanner;

public class App {
    private static GameData g = new GameData();
    private static Scanner text = new Scanner(System.in);

    public static void main(String[] args) {
        newGame();
    }
    
    private static void newGame(){
        System.out.println("Do you wish to go first? [Y/N]");
        switch (text.nextLine().toUpperCase()){
            case "Y":
                playerTurn();
                break;
            case "N":
                computerTurn();
                break;
            default:
                System.out.println("Invalid input");
                newGame();
        }
    }

    private static void playerTurn(){
        String color = "";
        int ammount = 0;
        System.out.println(g.stringify()); //display the current state of the game.
        while(true){ //wait until input is valid.
            System.out.println("What marker set would you like to take from ([G]reen, [Yellow] or [O]range)");
            color = text.nextLine().toUpperCase();
            if(color != "G" && color != "Y" && color != "O"){
                System.out.println("Invalid input!");
            } else {
                break;
            }
        }
       
        while(true){ //wait until input is valid.
            System.out.println("How many of the color marker would you like to remove?");

            if(g.getColor(color) == 0){
                throw new ZeroTokensException(color);
            } else if (ammount <= 0) {
                throw new TooSmallException(ammount);
            } else if(this.colors.get(color) < ammount){
                throw new TooBigException(this.colors.get(color), ammount, color);
            } else {
                this.colors.put(color, this.colors.get(color) - ammount);
            }
            if(ammount != 'G' && color != 'Y' && color != 'O'){
                System.out.println("Invalid input!");
                playerTurn();
            } else {
                ammount = Integer.parseInt(String.valueOf(input.charAt(1)));
                break;
            }
        }  




    
       





        switch (text.nextLine().toUpperCase().charAt(0)){
            case 'G':
                playerRemove(t, g, y, o);
                break;
            case 'Y':
                y -= text.nextLine().charAt(1);
                computerTurn(t++, g, y, o);
                break;
            case 'O':
                o -= text.nextLine().charAt(1);
                computerTurn(t++, g, y, o);
                break;
            default:
                System.out.println("Invalid input");
                playerTurn(t, g, y, o);
        }

    }

    private static void playerRemove(int t, int g, int y, int o){

    }

    private static void computerTurn(){

    }


}
