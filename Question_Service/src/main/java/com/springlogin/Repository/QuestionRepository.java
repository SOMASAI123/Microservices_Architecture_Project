package com.springlogin.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.springlogin.entities.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer> {

	List<Questions> findByCategory(String category);
	  

	 @Query(
		        value = "SELECT q.id FROM questions q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ",
		        nativeQuery = true
		    )
		    List<Integer> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);
	
}
