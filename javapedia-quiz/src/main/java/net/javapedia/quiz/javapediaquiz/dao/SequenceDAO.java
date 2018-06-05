package net.javapedia.quiz.javapediaquiz.dao;

public interface SequenceDAO {
	
	long getNextSequenceId (String key) throws SequenceException;

}
