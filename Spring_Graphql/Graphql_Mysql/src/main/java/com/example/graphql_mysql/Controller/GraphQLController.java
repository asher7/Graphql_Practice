package com.example.graphql_mysql.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.graphql_mysql.DTO.Author;
import com.example.graphql_mysql.DTO.Tutorial;
import com.example.graphql_mysql.Service.AuthorService;
import com.example.graphql_mysql.Service.TutorialService;



@Controller
public class GraphQLController {

    private final TutorialService tutorialService;
    private final AuthorService authorService;

    @Autowired
    public GraphQLController(TutorialService tutorialService, AuthorService authorService) {
        this.tutorialService = tutorialService;
        this.authorService = authorService;
    }

    // Queries
@QueryMapping
    public List<Tutorial> findAllTutorials() {
        return tutorialService.findAllTutorials();
    }

    @QueryMapping
    public List<Author> findAllAuthors() {
        return authorService.findAllAuthors();
    }

    // Mutations
@MutationMapping
    public Tutorial createTutorial(@Argument(name = "title") String title,
                                   @Argument(name = "description") String description,
                                   @Argument(name = "authorId") Long authorId) {
        Optional<Author> authorOptional = authorService.findAuthorById(authorId);
        if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            Tutorial tutorial = new Tutorial();
            tutorial.setTitle(title);
            tutorial.setDescription(description);
            tutorial.setAuthor(author);
            return tutorialService.createOrUpdateTutorial(tutorial);
        } else {
            throw new RuntimeException("Author with ID " + authorId + " not found!");
        }
    }
@MutationMapping
    public Author createAuthor(@Argument(name = "name") String name,
                               @Argument(name = "age") Integer age) {
        Author author = new Author();
        author.setName(name);
        author.setAge(age);
        return authorService.createOrUpdateAuthor(author);
    }
@MutationMapping
    public boolean deleteTutorial(@Argument(name = "id") Long id) {
        return tutorialService.deleteTutorial(id);
    }
@MutationMapping
    public Tutorial updateTutorial(@Argument(name = "id") Long id,
                                   @Argument(name = "title") String title,
                                   @Argument(name = "description") String description) {
        Optional<Tutorial> tutorialOptional = tutorialService.findTutorialById(id);
        if (tutorialOptional.isPresent()) {
            Tutorial tutorial = tutorialOptional.get();
            if (title != null) {
                tutorial.setTitle(title);
            }
            if (description != null) {
                tutorial.setDescription(description);
            }
            return tutorialService.createOrUpdateTutorial(tutorial);
        } else {
            throw new RuntimeException("Tutorial with ID " + id + " not found!");
        }
    }
}
