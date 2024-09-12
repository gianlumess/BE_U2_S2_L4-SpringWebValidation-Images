package gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "blog_posts")
public class BlogPost {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Author author;
    @Column(name = "tempo_lettura")
    private int tempoLettura;

    public BlogPost(String categoria, String titolo, String cover, String contenuto, Author author, int tempoLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = cover;
        this.contenuto = contenuto;
        this.author = author;
        this.tempoLettura = tempoLettura;
    }
}
