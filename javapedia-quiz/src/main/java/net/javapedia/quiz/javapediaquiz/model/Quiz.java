package net.javapedia.quiz.javapediaquiz.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "quiz")

public class Quiz {
	
public Quiz(String question, String opt1, String opt2, String opt3,String opt4, String opt5, String opt6,int correctAnswer, int titleId, int sortOrder,String explanation) {
		super();
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.titleId = titleId;
		this.sortOrder = sortOrder;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.opt5 = opt5;
		this.opt6 = opt6;
		this.explanation = explanation;
	}

@Id
Long id;

String question;

String opt1;
String opt2;
String opt3;
String opt4;
String opt5;
String opt6;

int correctAnswer;

int titleId;

int sortOrder;

String explanation;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getQuestion() {
	return question;
}

public void setQuestion(String question) {
	this.question = question;
}

public int getCorrectAnswer() {
	return correctAnswer;
}

public void setCorrectAnswer(int correctAnswer) {
	this.correctAnswer = correctAnswer;
}

public int getTitleId() {
	return titleId;
}

public void setTitleId(int titleId) {
	this.titleId = titleId;
}

public int getSortOrder() {
	return sortOrder;
}

public void setSortOrder(int sortOrder) {
	this.sortOrder = sortOrder;
}

public String getExplanation() {
	return explanation;
}

public void setExplanation(String explanation) {
	this.explanation = explanation;
}

public String getOpt1() {
	return opt1;
}

public void setOpt1(String opt1) {
	this.opt1 = opt1;
}

public String getOpt2() {
	return opt2;
}

public void setOpt2(String opt2) {
	this.opt2 = opt2;
}

public String getOpt3() {
	return opt3;
}

public void setOpt3(String opt3) {
	this.opt3 = opt3;
}

public String getOpt4() {
	return opt4;
}

public void setOpt4(String opt4) {
	this.opt4 = opt4;
}

public String getOpt5() {
	return opt5;
}

public void setOpt5(String opt5) {
	this.opt5 = opt5;
}

public String getOpt6() {
	return opt6;
}

public void setOpt6(String opt6) {
	this.opt6 = opt6;
}

}
