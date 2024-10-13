package com.springlogin.fiegn;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.springlogin.entities.QuestionWrapper;
import com.springlogin.entities.Response;

@FeignClient(name= "QUESTION-SERVICE")
public interface QuizInterface {
      
	@PostMapping("/question/createquiz")
	public ResponseEntity<List<Integer>> createQuiz(@RequestParam String category, @RequestParam int numQ);
	
	@PostMapping("/question/retrieve")
	public ResponseEntity<List<QuestionWrapper>> findbyId(@RequestBody List<Integer> id);

	@PostMapping("/question/submit")
	public ResponseEntity<Integer> submitQuiz( @RequestBody List<Response> response);
	
}
