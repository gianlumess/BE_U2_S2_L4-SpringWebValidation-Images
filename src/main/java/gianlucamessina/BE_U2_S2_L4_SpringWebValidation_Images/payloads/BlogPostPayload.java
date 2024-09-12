package gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;
@Getter
@AllArgsConstructor
public class BlogPostPayload {
    @NotEmpty(message = "L'ID dell'utente è obbligatorio!")
    private UUID authorId;
    @NotEmpty(message = "La categoria è obbligatoria!")
    private String categoria;
    @NotEmpty(message = "Il titolo è obbligatorio!")
    @Size(min = 3,max = 60,message = "Il titolo deve essere compreso tra i 3 e i 60 caratteri!")
    private String titolo;
    private String cover;
    @NotEmpty(message = "Il contenuto è obbligatorio!")
    @Size(min = 5,max = 250,message = "Il contenuto deve essere compreso tra i 5 e i 250 caratteri!")
    private String contenuto;
    @NotEmpty(message = "Il tempo di lettura è obbligatorio!")
    private int tempoLettura;


}
