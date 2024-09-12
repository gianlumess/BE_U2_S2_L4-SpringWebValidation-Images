package gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.exceptions;

import java.util.UUID;

public class NotFoundException extends  RuntimeException{
    public NotFoundException(UUID id){
        super("record con ID: "+id+" non trovato!");
    }
}
