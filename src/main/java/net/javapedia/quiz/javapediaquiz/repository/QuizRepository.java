package net.javapedia.quiz.javapediaquiz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.javapedia.quiz.javapediaquiz.model.Quiz;

public interface QuizRepository extends CrudRepository<Quiz, Integer> {
	@Override
	Optional<Quiz> findById(Integer id);
	
	@Override
	Quiz save(Quiz entity) ;
	
	List<Quiz> findByTitleId(int titleId);
}
