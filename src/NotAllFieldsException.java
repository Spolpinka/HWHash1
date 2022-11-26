public class NotAllFieldsException extends Exception{

    private String comment;

    public NotAllFieldsException(String comment) {
        super(comment);
    }
}
