public class TooSmallException extends Exception {

    public TooSmallException(int attemptedToRemove) {
        super(String.format("You cannot remove %d markers.", attemptedToRemove));
    }
    
}
