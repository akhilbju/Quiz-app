package com.example.quiz.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quiz.Quiz;
import com.example.quiz.Quizwrapper;
import com.example.quiz.Response;
import com.example.quiz.questions;
import com.example.quiz.dao.QuizDao;
import com.example.quiz.dao.qstndao;

@Service
public class Quizservice {

	@Autowired
	QuizDao quizDao;
	@Autowired
	qstndao qstn;
	
	
	public Quiz createQuiz(String name, int no, String difficulty) {
		
		List<questions> qstns = qstn.findByDifficultyAndNO(no,difficulty);
		Quiz qu = new Quiz();
		qu.setQuiz_name(name);
		qu.setQuestions(qstns);
		quizDao.save(qu);
		return qu;
	
	}

	public List<Quizwrapper> get(int id) {
		Optional<Quiz> quiz =  quizDao.findById(id);
		List<questions> qstnsFromDb = quiz.get().getQuestions();
		List<Quizwrapper> qstnsToUser = new ArrayList<Quizwrapper>();
		for(questions q:qstnsFromDb) {
			Quizwrapper wrapper = new Quizwrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3());
			qstnsToUser.add(wrapper);
		}
		
		return qstnsToUser;
	}

	public int getResult(int id, List<Response> response) {
		
		Optional<Quiz> quiz = quizDao.findById(id);
		List<questions> qstn = quiz.get().getQuestions();
		int right = 0,i=0;
		for(Response res :response) {
			if(res.getResponse().equals(qstn.get(i).getAnswer())) {
				right++;
			}
			i++;
		}
		
		return right;
	}
}
