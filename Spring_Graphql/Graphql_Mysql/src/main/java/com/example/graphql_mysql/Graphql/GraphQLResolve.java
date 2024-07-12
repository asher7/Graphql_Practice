//package com.example.graphql_mysql.Graphql;
//
//import java.util.Collections;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.example.graphql_mysql.DTO.Author;
//import com.example.graphql_mysql.DTO.Tutorial;
//import com.example.graphql_mysql.Repo.AuthorRepository;
//import com.example.graphql_mysql.Repo.TutorialRepository;
//
//import graphql.kickstart.tools.GraphQLMutationResolver;
//import graphql.kickstart.tools.GraphQLQueryResolver;
//
//@Component
//public class GraphQLResolve implements GraphQLQueryResolver, GraphQLMutationResolver {
//
//    private final AuthorRepository authorRepository;
//    private final TutorialRepository tutorialRepository;
//
//    @Autowired
//    private TutorialResolver tutorialResolver; // Inject TutorialResolver
//
//    @Autowired
//    public GraphQLResolve(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
//        this.authorRepository = authorRepository;
//        this.tutorialRepository = tutorialRepository;
//    }
//
//    // Query resolvers
//    public List<Author> findAllAuthors() {
//        List<Author> authors = authorRepository.findAll();
//        return authors != null ? authors : Collections.emptyList();
//    }
//
//    public List<Tutorial> findAllTutorials() {
//        List<Tutorial> tutorials = tutorialRepository.findAll();
//        return tutorials != null ? tutorials : Collections.emptyList();
//    }
//
//    public long countAuthors() {
//        return authorRepository.count();
//    }
//
//    public long countTutorials() {
//        return tutorialRepository.count();
//    }
//
//    // Mutation resolvers
//    public Author createAuthor(String name, Integer age) {
//        if (name == null || age == null) {
//            throw new IllegalArgumentException("Name and age must not be null.");
//        }
//
//        Author author = new Author();
//        author.setName(name);
//        author.setAge(age);
//
//        Author savedAuthor = authorRepository.save(author);
//
//        if (savedAuthor == null) {
//            throw new RuntimeException("Failed to create author.");
//        }
//
//        return savedAuthor;
//    }
//
//    public Tutorial createTutorial(String title, String description, Long authorId) {
//        System.out.println("Creating tutorial with title: " + title);
//        System.out.println("Author ID: " + authorId);
//        if (title == null || description == null || authorId == null) {
//            throw new IllegalArgumentException("Title, description, and authorId must not be null.");
//        }
//
//        Author author = authorRepository.findById(authorId)
//                .orElseThrow(() -> new IllegalArgumentException("Author not found with id: " + authorId));
//
//        Tutorial tutorial = new Tutorial();
//        tutorial.setTitle(title);
//        tutorial.setDescription(description);
//        tutorial.setAuthor(author);
//
//        Tutorial savedTutorial = tutorialRepository.save(tutorial);
//
//        if (savedTutorial == null) {
//            throw new RuntimeException("Failed to create tutorial.");
//        }
//
//        return savedTutorial;
//    }
//
//    public boolean deleteTutorial(Long id) {
//        if (id == null) {
//            throw new IllegalArgumentException("Tutorial ID must not be null.");
//        }
//
//        tutorialRepository.deleteById(id);
//        return true;
//    }
//
//    public Tutorial updateTutorial(Long id, String title, String description) {
//        if (id == null) {
//            throw new IllegalArgumentException("Tutorial ID must not be null.");
//        }
//
//        Tutorial tutorial = tutorialRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Tutorial not found with id: " + id));
//
//        if (title != null) {
//            tutorial.setTitle(title);
//        }
//        if (description != null) {
//            tutorial.setDescription(description);
//        }
//
//        Tutorial updatedTutorial = tutorialRepository.save(tutorial);
//
//        if (updatedTutorial == null) {
//            throw new RuntimeException("Failed to update tutorial.");
//        }
//
//        return updatedTutorial;
//    }
//
//    // Field resolver for Tutorial's author
//    public TutorialResolver tutorialResolver() {
//        return tutorialResolver; // Return TutorialResolver instance
//    }
//}
