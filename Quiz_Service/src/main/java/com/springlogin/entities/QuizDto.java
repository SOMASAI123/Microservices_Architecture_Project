package com.springlogin.entities;

public class QuizDto {
   
	private String categeory;
	private int numq;
	private String title;
	public String getCategeory() {
		return categeory;
	}
	public void setCategeory(String categeory) {
		this.categeory = categeory;
	}
	public int getNumq() {
		return numq;
	}
	public void setNumq(int numq) {
		this.numq = numq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public QuizDto(String categeory, int numq, String title) {
		super();
		this.categeory = categeory;
		this.numq = numq;
		this.title = title;
	}
	public QuizDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "QuizDto [categeory=" + categeory + ", numq=" + numq + ", title=" + title + "]";
	}
	
	
}
