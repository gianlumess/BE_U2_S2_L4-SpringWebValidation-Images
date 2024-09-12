package gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.entities.Author;
import gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.exceptions.BadRequestException;
import gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.exceptions.NotFoundException;
import gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.repositories.AuhtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorsService {
    @Autowired
    private AuhtorRepository auhtorRepository;
    @Autowired
    private Cloudinary cloudinary;



    public List<Author>findAll(){
        return this.auhtorRepository.findAll();
    }

    public Author findById(UUID authorId){
        return this.auhtorRepository.findById(authorId).orElseThrow(()->new NotFoundException(authorId));
    }

    public Author saveAuthor(Author body){
        //Controllo se l'email che si vuole utilizzare per creare l'autore non sia già utilizzata
        this.auhtorRepository.findByEmail(body.getEmail()).ifPresent(author -> {
            throw new BadRequestException("Impossibile creare autore in quanto l'email: "+body.getEmail()+" è già in uso!");
        });
        body.setAvatar("https://ui-avatars.com/api/?name="+body.getNome()+"+"+body.getCognome());
        this.auhtorRepository.save(body);
        return body;
    }

    public Author findByIdAndUpdate(UUID authorId,Author updatedAuthor){
        Author found=this.findById(authorId);

        //Controllo se l'email che si vuole utilizzare per creare l'autore non sia già utilizzata
        this.auhtorRepository.findByEmail(updatedAuthor.getEmail()).ifPresent(author -> {
            throw new BadRequestException("Impossibile creare autore in quanto l'email: "+updatedAuthor.getEmail()+" è già in uso!");
        });

        found.setNome(updatedAuthor.getNome());
        found.setCognome(updatedAuthor.getCognome());
        found.setEmail(updatedAuthor.getEmail());
        found.setDataNascita(updatedAuthor.getDataNascita());
        found.setAvatar("https://ui-avatars.com/api/?name="+found.getNome()+"+"+found.getCognome());

        return this.auhtorRepository.save(found);
    }

    public void findByIdAndDelete(UUID authorId){
        Author found=this.findById(authorId);

        this.auhtorRepository.delete(found);
    }

    public void uploadImage(UUID authorId,MultipartFile image) throws IOException {
        Author found=this.findById(authorId);

        String url= (String) cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap()).get("url");
        System.out.println("URL: "+url);

        found.setAvatar(url);

        this.auhtorRepository.save(found);

    }
}
