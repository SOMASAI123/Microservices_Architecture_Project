package com.springlogin.Controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springlogin.Service.QuestionService;
import com.springlogin.entities.QuestionWrapper;
import com.springlogin.entities.Questions;
import com.springlogin.entities.Response;

@RestController
@RequestMapping("/question")
public class QuestionController {
     
	@Autowired
	private QuestionService service;
	@Autowired
	private Environment environmnet;
	
	@PostMapping("/create")
	public ResponseEntity<Questions> addQuestions(@RequestBody Questions question)
	{
		return service.addQuestions(question);
	}
	
	@GetMapping("/get")
   public  List<Questions> getAllQuestions()
   {
	return service.getAllQuestions();
   }
	
	@GetMapping("/get/{id}")
	public Optional<Questions> getById(@PathVariable("id") int id)
	{
	       return service.getById(id);	
	}
	
	@GetMapping("/find/{category}")
	public List<Questions> getByCategory(@PathVariable("category") String category)
	{
		return service.getByCategory(category);
	}
	
	@PutMapping("/update/{id}")
	public Questions updateQuestions(@PathVariable("id") int id , @RequestBody Questions question)
	{
		return service.updateQuestions(id, question);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteQuestion(@PathVariable("id") int id)
	{
		service.deleteQuestion(id);
	}
	
	@PostMapping("/createquiz")
	public ResponseEntity<List<Integer>> createQuiz(@RequestParam String category, @RequestParam int numQ)
	{   
		System.out.println(environmnet.getProperty("local.Server.port"));
		return service.createQuiz(category,numQ);
	}
	
	@PostMapping("/retrieve")
	public ResponseEntity<List<QuestionWrapper>> findbyId(@RequestBody List<Integer> id)
	{
		return service.findbyId(id);
	}
	@PostMapping("/submit")
	public ResponseEntity<Integer> submitQuiz( @RequestBody List<Response> response)
	{
		return service.submitQuiz(response);
	}
	
	
}
