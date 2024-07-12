package com.example.graphql_mysql.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphql_mysql.DTO.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}