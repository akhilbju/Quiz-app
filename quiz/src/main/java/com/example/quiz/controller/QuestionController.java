package com.example.quiz.controller;

import java.net.http.HttpResponse;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.example.quiz.questions;
import com.example.quiz.services.service;


@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	service ser;
	
	@GetMapping("/getqstn")
	public List<questions> getqstn() {
		return ser.getqstn();
	}
	
	@GetMapping("/difficulty/{difficulty}")
	public List<questions> getqstndiff(@PathVariable("difficulty") String difficulty){
		return ser.getbydiff(difficulty);
	}
	
	@PostMapping("/add/question")
	public ResponseEntity<questions> add(@RequestBody questions qstn) {
		return new ResponseEntity<>(qstn,HttpStatus.CREATED);
		
	}
	@DeleteMapping("/delete/{id}" )
	public void delete(@PathVariable("id") int id){
		ser.delete(id);
		
	}
	
	@PutMapping("/update/{id}")
	public void update(@RequestBody questions qstn,@PathVariable("id") int id){
		 ser.update(qstn,id);
	}
}
