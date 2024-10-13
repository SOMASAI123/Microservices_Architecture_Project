package com.springlogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springlogin.Repository.QuizRepository;
import com.springlogin.Service.QuizService;
import com.springlogin.entities.QuestionWrapper;
import com.springlogin.entities.Quiz;
import com.springlogin.entities.QuizDto;
import com.springlogin.entities.Response;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    
	@Autowired
	private QuizService service;
	
	@PostMapping("/createquiz")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizdto)
	{
		return service.createQuiz(quizdto.getCategeory(),quizdto.getNumq(),quizdto.getTitle());
	}
	
	
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<List<QuestionWrapper>> getById(@PathVariable("id") int id)
	{
		return service.getbyId(id);
	}
	
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable("id") int id, @RequestBody List<Response> response)
	{
		return service.submitQuiz(id,response);
	}
}
