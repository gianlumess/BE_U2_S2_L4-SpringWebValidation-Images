package gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.services;

import gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.entities.Author;
import gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.entities.BlogPost;
import gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.exceptions.NotFoundException;
import gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.payloads.BlogPostPayload;
import gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.repositories.BlogPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogPostsService {
    @Autowired
    private BlogPostsRepository blogPostsRepository;
    @Autowired
    private AuthorsService authorsService;


    public List<BlogPost>findAll(){
        return this.blogPostsRepository.findAll();
    }

    public BlogPost findById(UUID blogPostId){
        return this.blogPostsRepository.findById(blogPostId).orElseThrow(()->new NotFoundException(blogPostId));

    }

    public BlogPost saveBlogPost(BlogPostPayload body){
        Author author=authorsService.findById(body.getAuthorId());
        BlogPost blogPost=new BlogPost(body.getCategoria(), body.getTitolo(), body.getCover(), body.getContenuto(), author, body.getTempoLettura());

        return blogPostsRepository.save(blogPost);
    }

    public BlogPost findByIdAndUpdate(UUID blogPostId, BlogPostPayload updatedBlogPost){
        BlogPost found=this.findById(blogPostId);


        found.setCategoria(updatedBlogPost.getCategoria());
        found.setTitolo(updatedBlogPost.getTitolo());
        found.setCover(updatedBlogPost.getCover());
        found.setContenuto(updatedBlogPost.getContenuto());
        found.setTempoLettura(updatedBlogPost.getTempoLettura());

        return this.blogPostsRepository.save(found);
    }

    public void findByIdAndDelete(UUID blogPostId){
        BlogPost found=this.findById(blogPostId);
        this.blogPostsRepository.delete(found);
    }
}
