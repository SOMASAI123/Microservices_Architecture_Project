package com.springlogin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springlogin.Repository.QuestionRepository;
import com.springlogin.entities.QuestionWrapper;
import com.springlogin.entities.Questions;
import com.springlogin.entities.Response;

@Service
public class QuestionService {
   
	@Autowired
	private QuestionRepository repo;

	public ResponseEntity<Questions> addQuestions(Questions question) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>( repo.save(question),HttpStatus.OK);
	}

	public List<Questions> getAllQuestions() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<Questions> getById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public List<Questions> getByCategory(String category) {
		// TODO Auto-generated method stub
		return repo.findByCategory(category);
	}


	public Questions updateQuestions(int id, Questions question) {
		// TODO Auto-generated method stub
		return repo.save(question);
	}

	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		 repo.deleteById(id);
	}

	public ResponseEntity<List<Integer>> createQuiz(String category, int numQ) {
		// TODO Auto-generated method stub
		 List<Integer> questions=repo.findRandomQuestionsByCategory(category, numQ);
		 
		 return new ResponseEntity<>(questions,HttpStatus.OK); 
		 
		 }

	public ResponseEntity<List<QuestionWrapper>> findbyId(List<Integer> q_id) {
		// TODO Auto-generated method stub
		
		List<QuestionWrapper> wrapper=new ArrayList<>();
		List<Questions> questions=new ArrayList();
		
		for(Integer id: q_id)
		{
			questions.add(repo.findById(id).get());
		}
		
		for(Questions q: questions)
		{ 
			QuestionWrapper wrapper1=new QuestionWrapper();
			wrapper1.setId(q.getId());
			wrapper1.setOption1(q.getOption1());
			wrapper1.setOption2(q.getOption2());
			wrapper1.setOption3(q.getOption3());
			wrapper1.setOption4(q.getOption4());
			wrapper.add(wrapper1);
			
		}
		return new ResponseEntity<>(wrapper,HttpStatus.OK);
		
	}

	public ResponseEntity<Integer> submitQuiz( List<Response> response) {
		// TODO Auto-generated method stub
		
		int right=0;
		
		for(Response res:response)
		{
			 Questions q=repo.findById(res.getId()).get();
			 if(res.getResponse().equals(q.getRightanswer()))
			 {
				 right++;
			 }
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}

	
	
	
	
}
