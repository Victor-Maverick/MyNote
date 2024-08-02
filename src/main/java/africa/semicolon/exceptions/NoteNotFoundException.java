package africa.semicolon.exceptions;



public class NoteNotFoundException extends RuntimeException{
    public NoteNotFoundException(String message){
        super(message);
    }
}
