//package com.example.graphql_mysql.Graphql;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.example.graphql_mysql.DTO.Author;
//import com.example.graphql_mysql.DTO.Tutorial;
//import com.example.graphql_mysql.Repo.AuthorRepository;
//import com.example.graphql_mysql.Repo.TutorialRepository;
//
//import graphql.kickstart.tools.GraphQLQueryResolver;
//import graphql.scalars.ExtendedScalars;
//import graphql.schema.GraphQLScalarType;
//
//@Component
//public class Query implements GraphQLQueryResolver {
//  private AuthorRepository authorRepository;
//  private TutorialRepository tutorialRepository;
//
//  GraphQLScalarType longScalar = ExtendedScalars.newAliasedScalar("Long")
//          .aliasedScalar(ExtendedScalars.GraphQLLong)
//          .build();
//
//  @Autowired
//  public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
//    this.authorRepository = authorRepository;
//    this.tutorialRepository = tutorialRepository;
//  }
//
//  public Iterable<Author> findAllAuthors() {
//    return authorRepository.findAll();
//  }
//
//  public Iterable<Tutorial> findAllTutorials() {
//    return tutorialRepository.findAll();
//  }
//
//  public long countAuthors() {
//    return authorRepository.count();
//  }
//
//  public long countTutorials() {
//    return tutorialRepository.count();
//  }
//
//}