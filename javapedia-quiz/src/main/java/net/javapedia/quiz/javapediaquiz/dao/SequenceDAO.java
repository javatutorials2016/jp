package net.javapedia.quiz.javapediaquiz.dao;

import org.springframework.stereotype.Service;

public interface SequenceDAO {
	
	long getNextSequenceId (String key) throws SequenceException;

}
