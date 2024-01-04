package com.example.quiz.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz.Quiz;
import com.example.quiz.Quizwrapper;
import com.example.quiz.Response;
import com.example.quiz.services.Quizservice;

@RestController
@RequestMapping("/quiz")
public class Quizcontroller {
	
	@Autowired
	Quizservice quizservice;
	
	@PostMapping("/create")
	public Quiz create(@RequestParam("name") String name,@RequestParam("qno") int no,@RequestParam("difficulty")String difficulty) {
		return quizservice.createQuiz(name,no,difficulty);
		
	}
	
	@GetMapping("/get/{id}")
	public List<Quizwrapper> getquiz(@PathVariable("id") int id) {
		return quizservice.get(id);
		
	}
	
	@GetMapping("/result/{id}")
	public int getScore(@PathVariable("id") int id,@RequestBody List<Response> response) {
		 return quizservice.getResult(id,response);
	}

}
