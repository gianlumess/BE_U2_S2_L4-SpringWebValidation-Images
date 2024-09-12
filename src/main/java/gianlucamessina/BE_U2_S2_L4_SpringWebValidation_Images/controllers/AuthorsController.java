package gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.controllers;



import gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.entities.Author;
import gianlucamessina.BE_U2_S2_L4_SpringWebValidation_Images.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    AuthorsService authorsService;
    //GET LIST
    @GetMapping
    private List<Author> getAllAuthors(){
        return authorsService.findAll();
    }

    //POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Author createAuthor(@RequestBody Author body){
        return authorsService.saveAuthor(body);
    }

    //GET AUTHOR BY ID
    @GetMapping("/{authorId}")
    private Author getAuthorById(@PathVariable UUID authorId){
        return authorsService.findById(authorId);
    }

    //PUT
    @PutMapping("/{authorId}")
    private Author findAuthorByIdAndDelete(@PathVariable UUID authorId,@RequestBody Author body){
        return authorsService.findByIdAndUpdate(authorId,body);
    }

    //DELETE
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findAuthorByIdAndDelete(@PathVariable UUID authorId){
        authorsService.findByIdAndDelete(authorId);
    }

    //PATCH PER LE IMMAGINI AVATAR
    @PatchMapping("/{authorId}/avatar")
    public void uploadAvatar(@PathVariable UUID authorId,@RequestParam("avatar") MultipartFile image) throws IOException {
        this.authorsService.uploadImage(authorId,image);
    }
}
