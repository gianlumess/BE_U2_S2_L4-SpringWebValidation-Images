package gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) //400
    public ErrorsPayload handleBadRequest(BadRequestException e){
        return new ErrorsPayload(e.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) //404
    public ErrorsPayload handleNotFound(NotFoundException e){
        return new ErrorsPayload(e.getMessage(),LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //500
    public ErrorsPayload handleGenericErrors(Exception e){
        e.printStackTrace(); //estremamente utile per risalire all'errore!!!!
        return new ErrorsPayload("c'è stato un problema lato server!",LocalDateTime.now());
    }
}
