package net.javapedia.quiz.javapediaquiz.dao;

public class SequenceException extends RuntimeException {
	
	private String errCode;
	private String errMsg;
	
	public SequenceException(String errMsg) {
		this.errMsg = errMsg;
	}

}
