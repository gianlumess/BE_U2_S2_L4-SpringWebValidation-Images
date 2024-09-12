package gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.repositories;

import gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BlogPostsRepository extends JpaRepository<BlogPost, UUID> {

}
