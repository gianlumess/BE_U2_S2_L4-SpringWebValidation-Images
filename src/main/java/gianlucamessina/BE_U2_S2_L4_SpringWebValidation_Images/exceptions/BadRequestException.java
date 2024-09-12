package gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
