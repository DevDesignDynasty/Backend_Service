package com.devdesign.backend.repositories;

import com.devdesign.backend.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepo extends JpaRepository<Question, String> {

}
