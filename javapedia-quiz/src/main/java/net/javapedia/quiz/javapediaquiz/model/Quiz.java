package net.javapedia.quiz.javapediaquiz.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "quiz")

public class Quiz {
	
public Quiz(String question, List<String> answers, int correctAnswer, int titleId, int sortOrder) {
		super();
		this.question = question;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
		this.titleId = titleId;
		this.sortOrder = sortOrder;
	}

@Id
Long id;

String question;

List<String> answers;

int correctAnswer;

int titleId;

int sortOrder;

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

public List<String> getAnswers() {
	return answers;
}

public void setAnswers(List<String> answers) {
	this.answers = answers;
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

}
