public class ZeroTokensException extends Exception {
    
    public ZeroTokensException(char color) {
        super(String.format("There are currently 0 %s", color));
    }
}
