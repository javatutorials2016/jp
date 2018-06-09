package net.javapedia.quiz.javapediaquiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javapedia.quiz.javapediaquiz.dao.SequenceDaoImpl;
import net.javapedia.quiz.javapediaquiz.model.Quiz;
import net.javapedia.quiz.javapediaquiz.repository.QuizRepository;

@Controller
public class QuizController {

	@Autowired
	QuizRepository quizRepository;
	@Autowired
	SequenceDaoImpl sequenceRepo;
	@RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }
	
	@RequestMapping("/save")
	public String save (@RequestParam String question, @RequestParam List<String> answers, @RequestParam int correctAnswer, @RequestParam int titleId, @RequestParam int sortOrder )
	
	{
		long id= sequenceRepo.getNextSequenceId("quiz") ; 
		Optional<Quiz> quiz =quizRepository.findById((int)id );
		quiz.orElse(new Quiz(question,answers,correctAnswer,titleId,sortOrder));
		/*quiz.
		quiz.flatMap(quiz -> {
			quiz.setQuestion (question);
			quiz.setAnswers(answers);
			quiz.setCorrectAnswer(correctAnswer);
			quiz.setTitleId(titleId);
			quiz.setSortOrder(sortOrder);
	
		}); */
		return null;
	
	}
	
}
