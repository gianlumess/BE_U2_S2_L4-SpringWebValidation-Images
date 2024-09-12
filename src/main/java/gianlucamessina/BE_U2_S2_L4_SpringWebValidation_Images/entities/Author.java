package gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String nome;
    private String cognome;
    private String email;
    @Column(name = "data_nascita")
    private LocalDate dataNascita;
    private String avatar;

    public Author(String nome, String cognome, String email, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
    }
}
