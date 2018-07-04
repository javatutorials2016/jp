package net.javapedia.quiz.javapediaquiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javapedia.quiz.javapediaquiz.dao.SequenceDAO;
import net.javapedia.quiz.javapediaquiz.model.Quiz;
import net.javapedia.quiz.javapediaquiz.repository.QuizRepository;

@Controller
public class QuizController {

	@Autowired
	QuizRepository quizRepository;
	@Autowired
	SequenceDAO sequenceRepo;
	@RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }
	
	@RequestMapping("/save")
	public String save (@RequestParam String question, @RequestParam List<String> answers, @RequestParam int correctAnswer, @RequestParam int titleId, @RequestParam int sortOrder )
	
	{
		/*
	@todo
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
	
		}); 
		return null;
		*/
		
		Quiz quiz = new Quiz(question,answers,correctAnswer,titleId,sortOrder);
		quizRepository.save(quiz);
		 return "redirect:/show/" + quiz.getId();
	
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable Integer id, Model model) {
		model.addAttribute("quiz",quizRepository.findById(id));
		return "show";
	}
	@RequestMapping("/delete")
    public String delete(@RequestParam Integer id) {
		Optional<Quiz> quiz = quizRepository.findById(id);
		quizRepository.delete(quiz.get());

        return "redirect:/quiz";
    }
	
	@RequestMapping("/edit/{id}")
	public String edit (@PathVariable Integer id, Model model) {
		model.addAttribute("quiz", quizRepository.findById(id));
		return "edit";
				
	}
	
	@RequestMapping("/update")
	public String update (@RequestParam Integer id, @RequestParam String question, @RequestParam List<String> answers, @RequestParam int correctAnswer, @RequestParam int titleId, @RequestParam int sortOrder) {
		Optional<Quiz> quiz = quizRepository.findById(id);
		 quiz.ifPresent(q -> {q.setQuestion (question);
			q.setAnswers(answers); 
			q.setCorrectAnswer(correctAnswer);
			q.setTitleId(titleId);
			q.setSortOrder(sortOrder);});
		 quizRepository.save(quiz.get());
		 return "redirect:/show/" + quiz.get().getId();
		/*
		q.setCorrectAnswer(correctAnswer);
		q.setTitleId(titleId);
		q.setSortOrder(sortOrder);
		*/
	}
	
	
}
