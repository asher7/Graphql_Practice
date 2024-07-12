package com.example.demo.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.Dto.Author;
import com.example.demo.Dto.Book;

@Controller
public class BookController {
	
	 // Static data for Authors
    private static List<Author> authors = Arrays.asList(
            new Author("author-1", "Joshua", "Bloch"),
            new Author("author-2", "Douglas", "Adams"),
            new Author("author-3", "Bill", "Bryson")
    );

    // Static data for Books
    private static List<Book> books = Arrays.asList(
            new Book("book-1", "Effective Java", 416, "author-1"),
            new Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2"),
            new Book("book-3", "Down Under", 436, "author-3")
    );

    // Query operations for Book

    @QueryMapping
    public Book bookById(@Argument("id") String id) {
        return getBookById(id);
    }

    @QueryMapping
    public List<Book> allBooks() {
        return books;
    }

    // Mutation operations for Book

    @MutationMapping
    public Book createBook(@Argument("name") String name, @Argument("pageCount") int pageCount, @Argument("authorId") String authorId) {
        Book newBook = new Book("book-" + (books.size() + 1), name, pageCount, authorId);
        books.add(newBook);
        return newBook;
    }

   

    @MutationMapping
    public Boolean deleteBook(@Argument("id") String id) {
        return books.removeIf(book -> book.id().equals(id));
    }

    // Query operations for Author

    @QueryMapping
    public Author authorById(@Argument("id") String id) {
        return getAuthorById(id);
    }

    @QueryMapping
    public List<Author> allAuthors() {
        return authors;
    }

    // Mutation operations for Author

    @MutationMapping
    public Author createAuthor(@Argument("firstName") String firstName, @Argument("lastName") String lastName) {
        Author newAuthor = new Author("author-" + (authors.size() + 1), firstName, lastName);
        authors.add(newAuthor);
        return newAuthor;
    }

   
    @MutationMapping
    public Boolean deleteAuthor(@Argument("id") String id) {
        return authors.removeIf(author -> author.id().equals(id));
    }

    // Helper methods to retrieve entities by ID
    private Book getBookById(String id) {
        return books.stream()
                .filter(book -> book.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    private Author getAuthorById(String id) {
        return authors.stream()
                .filter(author -> author.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}