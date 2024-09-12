package gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.repositories;

import gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface AuhtorRepository extends JpaRepository<Author, UUID> {

    Optional<Author>findByEmail(String email);
}
