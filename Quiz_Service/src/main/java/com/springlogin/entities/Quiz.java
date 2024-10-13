package com.springlogin.entities;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Quiz {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	@ElementCollection
	private List<Integer> questionsIds;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Integer> getQuestions() {
		return getQuestions();
	}
	public void setQuestions(List<Integer> questions) {
		this.questionsIds = questions;
	}
	public Quiz(int id, String title, List<Integer> questions) {
		super();
		this.id = id;
		this.title = title;
		this.questionsIds = questions;
	}
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", questions=" + questionsIds + "]";
	}
	
	
}
