package com.fincons.todo.dto;

import java.util.Date;

import com.fincons.todo.models.utils.TodoStateEnum;

public class TodoDto {
	//Definisco le variabili del mio dto
	private Integer id;
	private  String todoText;
	private  TodoStateEnum state;
	private Date createdAt;
	private Date dueDate;
	public Integer getId() {
		return id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTodoText() {
		return todoText;
	}
	public void setTodoText(String todoText) {
		this.todoText = todoText;
	}
	public TodoStateEnum getState() {
		return state;
	}
	public void setState(TodoStateEnum state) {
		this.state = state;
	}

	
	
}
