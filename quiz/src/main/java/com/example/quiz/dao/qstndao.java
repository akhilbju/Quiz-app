package com.example.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quiz.questions;

@Repository
public interface qstndao extends JpaRepository<questions, Integer>{

	List<questions> findByDifficulty(String difficulty);
	@Query(value = "select * from questions q where q.difficulty=?2 order by rand() limit ?1",nativeQuery = true)
	List<questions> findByDifficultyAndNO(int no, String difficulty);

}
