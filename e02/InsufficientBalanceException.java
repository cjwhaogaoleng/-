package exam_xier.e02;

public class InsufficientBalanceException extends RuntimeException{

    public InsufficientBalanceException(){}


    public InsufficientBalanceException(String message){
        super(message);
    }
}
