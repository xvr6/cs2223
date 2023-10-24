import java.util.HashMap;

public class GameData {
    private HashMap<String, Integer> colors = new HashMap<>();

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
    * Creates a string for displaying in the console.
    * @return a string of the current state of the game.
    */
    public String stringify(){
        return String.format("Green: %d, Yellow: %d, Orange: %d", this.colors.get("G"), this.colors.get("Y"), this.colors.get("O"));
    }

    /**
     * Gets the number of markers of the specified color.
     * @param c the color of the markers you wish to get the quantity of.
     * @return the ammount of markers in that specific color.
     */
    public int getColor(String c){
        return this.colors.get(c);
    }

    /**
     * Gets the number of green markers.
     * @return the number of green markers.
     */
    public Integer g(){
        return this.colors.get("G");
    }
    
    /**
     * Gets the number of yellow markers.
     * @return the number of yellow markers.
     */
    public Integer y(){
        return this.colors.get("Y");
    }

    /**
     * Gets the number of orange markers.
     * @return the number of orange markers.
     */
    public Integer o(){
        return this.colors.get("O");
    }

    /**
     * Removes from the specified color, the specified ammount of markers.
     * @param color the color of the markers you wish to remove.
     * @param ammount the number of markers you wish to remove from that color.
     * @throws TooBigException when you try to remove more markers than there are.
     * @throws TooSmallException when you try to remove non-positive ammount of number of markers.
     * @throws ZeroTokensException when you try to remove from a color that has no markers.
     */

    public void changeValue(String color, Integer ammount) {
        if(this.colors.get(color) == 0){
            throw new ZeroTokensException(color);
        } else if (ammount <= 0) {
            throw new TooSmallException(ammount);
        } else if(this.colors.get(color) < ammount){
            throw new TooBigException(this.colors.get(color), ammount, color);
        } else {
            this.colors.put(color, this.colors.get(color) - ammount);
        }
    }

}