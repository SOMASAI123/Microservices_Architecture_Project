package com.springlogin.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Response {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
	private int id;
	private String response;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Response(int id, String response) {
		super();
		this.id = id;
		this.response = response;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
