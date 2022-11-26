public class ExistedRecipeException extends Exception {
    String message;

    public ExistedRecipeException(String message) {
        super(message);
    }
}
