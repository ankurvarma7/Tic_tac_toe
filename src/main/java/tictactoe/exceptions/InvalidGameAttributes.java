package tictactoe.exceptions;

public class InvalidGameAttributes extends IllegalArgumentException{
    public InvalidGameAttributes(String message){
        super(message);
    }
    public InvalidGameAttributes(String message,Throwable cause){
        super(message,cause);
    }
}
