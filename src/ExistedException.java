public class ExistedException extends Exception{

    private String comment;

    public ExistedException(String comment) {
        super(comment);
        this.comment = comment;
    }
}
