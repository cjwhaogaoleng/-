package exam_xier.e02;

public class AnimalNotFoundException extends RuntimeException{
    public AnimalNotFoundException(){}

    public AnimalNotFoundException(String message){
        super(message);
    }
}
