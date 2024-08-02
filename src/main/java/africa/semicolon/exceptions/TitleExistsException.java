package africa.semicolon.exceptions;

public class TitleExistsException extends RuntimeException {
    public TitleExistsException(String message) {
        super(message);
    }
}
