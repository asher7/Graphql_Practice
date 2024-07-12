//package com.example.graphql_mysql.Graphql;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.example.graphql_mysql.DTO.Author;
//import com.example.graphql_mysql.DTO.Tutorial;
//import com.example.graphql_mysql.Repo.AuthorRepository;
//
//import graphql.kickstart.tools.GraphQLResolver;
//
//
//@Component
//public class TutorialResolver implements GraphQLResolver<Tutorial> {
//  @Autowired
//  private AuthorRepository authorRepository;
//
//  public TutorialResolver(AuthorRepository authorRepository) {
//    this.authorRepository = authorRepository;
//  }
//
//  public Author getAuthor(Tutorial tutorial) {
//    return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
//  }
//}