package com.example.quiz;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Response {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qstn_id;
	private String response;
	
	public int getId() {
		return qstn_id;
	}
	public void setId(int qstn_id) {
		this.qstn_id = qstn_id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	public Response(int qstn_id, String response) {
		super();
		this.qstn_id = qstn_id;
		this.response = response;
	}
	public Response() {
		super();
	}
	
	
}
