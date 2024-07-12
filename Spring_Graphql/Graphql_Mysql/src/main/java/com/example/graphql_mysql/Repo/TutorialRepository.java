package com.example.graphql_mysql.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphql_mysql.DTO.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}