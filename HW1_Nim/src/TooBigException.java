public class TooBigException extends Exception {

    public TooBigException(int total, int attemptedToRemove, char color) {
        super(String.format("You cannot remove %d %ss there are only %d left.", attemptedToRemove, color, total));
    }
}
