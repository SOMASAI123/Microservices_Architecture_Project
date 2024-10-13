package com.springlogin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.springlogin.entities.Questions;
import com.springlogin.entities.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
  
}
