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
	
	@RequestMapping("/quiz")
	public String quiz(Model model) {
		model.addAttribute("quizs",quizRepository.findAll());
		return "quiz";
	}
	
	@RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }
	
	@RequestMapping("/save")
	public String save (@RequestParam String question, @RequestParam String opt1,
			@RequestParam String opt2,@RequestParam String opt3,@RequestParam String opt4,@RequestParam String opt5,@RequestParam String opt6,
			@RequestParam int correctAnswer, @RequestParam int titleId, @RequestParam int sortOrder, @RequestParam String explanation )
	
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
		
		Quiz quiz = new Quiz(question,opt1,opt2,opt3,opt4,opt5,opt6,correctAnswer,titleId,sortOrder,explanation);
		long id= sequenceRepo.getNextSequenceId("quiz") ;
		quiz.setId(id);
		quizRepository.save(quiz);
		 return "redirect:/show/" + quiz.getId();
	
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable Integer id, Model model) {
		model.addAttribute("quiz",quizRepository.findById(id).get());
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
		model.addAttribute("quiz", quizRepository.findById(id).orElseThrow(IllegalArgumentException::new));
		return "edit";
				
	}
	
	@RequestMapping("/update")
	public String update (@RequestParam Integer id, @RequestParam String question, @RequestParam String opt1,
			@RequestParam String opt2,@RequestParam String opt3,@RequestParam String opt4,@RequestParam String opt5,@RequestParam String opt6,
			@RequestParam int correctAnswer, @RequestParam int titleId, @RequestParam int sortOrder, @RequestParam String explanation ) {
		Optional<Quiz> quiz = quizRepository.findById(id);
		 quiz.ifPresent(q -> {q.setQuestion (question);
			q.setOpt1(opt1);
			q.setOpt2(opt2);
			q.setOpt3(opt3);
			q.setOpt4(opt4);
			q.setOpt5(opt5);
			q.setOpt6(opt6);
			q.setCorrectAnswer(correctAnswer);
			q.setTitleId(titleId);
			q.setSortOrder(sortOrder); q.setExplanation(explanation);});
		 quizRepository.save(quiz.get());
		 return "redirect:/show/" + quiz.get().getId();
		/*
		q.setCorrectAnswer(correctAnswer);
		q.setTitleId(titleId);
		q.setSortOrder(sortOrder);
		*/
	}
	
	@RequestMapping("/attendQuiz/{id}/{qNo}")
	public String attendQuiz (@PathVariable Integer id, Model model, @PathVariable Integer qNo) {
		List<Quiz> quizList = quizRepository.findByTitleId(id);
//		model.addAttribute("quizs", );
		if (qNo == null || qNo<=0) {
			model.addAttribute("quizs", quizList.get(0));
		} else if (qNo<= quizList.size())
			model.addAttribute("quizs", quizList.get(qNo));
		return "quiz";
				
	}
	
	
}
