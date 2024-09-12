package gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class ErrorsPayload {
    private String message;
    private LocalDateTime time;
}
