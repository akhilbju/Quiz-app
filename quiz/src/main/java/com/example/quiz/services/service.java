package com.example.quiz.services;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.quiz.questions;
import com.example.quiz.dao.qstndao;

@Service
public class service {
	@Autowired
	qstndao qstns;
	
	public List<questions> getqstn(){
		return qstns.findAll();
		
	}
	
	public List<questions> getbydiff(String difficulty){
			return qstns.findByDifficulty(difficulty);
				
	}
	
	public questions add(questions qstn) {
		return qstns.save(qstn);
	}
	
	public ResponseEntity<questions> delete(int id){
		qstns.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public void update(questions qstn,int id){
		questions qs = qstns.getById(id);
		qs.setAnswer(qstn.getAnswer());
		qs.setDifficulty(qstn.getDifficulty());
		qs.setOption1(qstn.getOption1());
		qs.setOption2(qstn.getOption2());
		qs.setOption3(qstn.getOption3());
		qs.setQuestion(qstn.getQuestion());
		qstns.save(qs);
	}

}
