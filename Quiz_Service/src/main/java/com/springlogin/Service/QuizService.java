
package com.springlogin.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.springlogin.Repository.QuizRepository;
import com.springlogin.entities.QuestionWrapper;
import com.springlogin.entities.Quiz;
import com.springlogin.entities.Response;

@Service
public class QuizService {
    
	@Autowired
	private QuizRepository repo;
	
	@Autowired
	private com.springlogin.fiegn.QuizInterface quizinterface;

	public ResponseEntity<String> createQuiz(String categeory,int numQ, String title) {

		List<Integer> questions=quizinterface.createQuiz(categeory, numQ).getBody();
		
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		repo.save(quiz);

		return new ResponseEntity<>("sucess",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getbyId(int id) {
		Quiz quiz=repo.findById(id).get();
		List<Integer> id1=quiz.getQuestions();
		
		
		 ResponseEntity<List<QuestionWrapper>> questions=quizinterface.findbyId(id1);
		 return questions;
	}

	public ResponseEntity<Integer> submitQuiz(int id, List<Response> response) {
		
		ResponseEntity<Integer> score=quizinterface.submitQuiz(response);
		return score;
	}

	
	
	
}
