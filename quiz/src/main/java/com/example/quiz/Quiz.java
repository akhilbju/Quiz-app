package com.example.quiz;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="quiz")
public class Quiz implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String quiz_name;
	@ManyToMany
	private List<questions> questions;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuiz_name() {
		return quiz_name;
	}
	public void setQuiz_name(String quiz_name) {
		this.quiz_name = quiz_name;
	}
	public List<questions> getQuestions() {
		return questions;
	}
	public void setQuestions(List<questions> questions) {
		this.questions = questions;
	}
	public Quiz() {
		super();
	}
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", quiz_name=" + quiz_name + ", questions=" + questions + "]";
	}
	

}
