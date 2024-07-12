package com.example.graphql_mysql.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.graphql_mysql.DTO.Tutorial;
import com.example.graphql_mysql.Repo.TutorialRepository;

@Service
public class TutorialService {

    private final TutorialRepository tutorialRepository;

    @Autowired
    public TutorialService(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    public List<Tutorial> findAllTutorials() {
        return tutorialRepository.findAll();
    }

    public Optional<Tutorial> findTutorialById(Long id) {
        return tutorialRepository.findById(id);
    }

    public Tutorial createOrUpdateTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    public boolean deleteTutorial(Long id) {
        if (tutorialRepository.existsById(id)) {
            tutorialRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
