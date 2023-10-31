import java.util.HashMap;

public class GameData {
    private HashMap<String, Integer> colors = new HashMap<>();
    private int turn = 1;

    /**
     * Constructor for GameData with the default values of 3 green, 7 yellow, and 5 orange.
     */
    public GameData(){
        this.colors.put("G", 3);
        this.colors.put("Y", 7);
        this.colors.put("O", 5);
    }

    /**
      * Constructor for GameData with custom values.
      * @param g the number of green markers
      * @param y the number of yellow markers
      * @param o the number of orange markers
      */
    public GameData(int g, int y, int o){
        this.colors.put("G", g);
        this.colors.put("Y", y);
        this.colors.put("O", o);
    }

    /**
     * Gets the turn number
     * @return the turn number
     */
    public int turnNumber(){
        return this.turn;
    }

   /**
    * Creates a string for displaying in the console.
    * @return a string of the current state of the game.
    */
    public String stringify(){
        return String.format("There are currently %d Green, %d Yellow, and %d Orange markers.", this.colors.get("G"), this.colors.get("Y"), this.colors.get("O"));
    }

    /**
     * Gets the number of markers of the specified color.
     * @param c the color of the markers you wish to get the quantity of.
     * @return the ammount of markers in that specific color.
     */
    public int getMarkers(String c){
        return this.colors.get(c);
    }

    /**
     * Gets the name of the color based off of its abbreviation.
     * @param s the color you wish to get the name of.
     * @return the name of the color.
     */
    public String getName(String s){
        switch(s){
            case "G":
                return "Green";
            case "Y":
                return "Yellow";
            case "O":
                return "Orange";
            default:
                return "Invalid color";
        }
    }

    /**
     * Removes from the specified color, the specified ammount of markers.
     * @param color the color of the markers you wish to remove.
     * @param ammount the number of markers you wish to remove from that color.
     */
    public void removeValue(Boolean isPlayer, String color, Integer ammount) {
        this.turn++;
        this.colors.put(color, this.colors.get(color) - ammount);
        String player = isPlayer ? "You have" : "The computer has";
        System.out.println(String.format("%s removed %d %s markers. \n", player, ammount, this.getName(color)));

    }
}