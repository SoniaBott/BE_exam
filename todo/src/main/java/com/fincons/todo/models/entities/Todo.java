package com.fincons.todo.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fincons.todo.models.utils.TodoStateEnum;

@Entity
@Table(name="todo2")
public class Todo implements Serializable{
	
	//Definizione colonne della tabella
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="todo_text")
	private String todoText;
	
	@Column(name="state")
	private TodoStateEnum state; 
	
	@Column(name="createdat")
	private Date createdAt;
	
	@Column(name="duedate")
	private Date dueDate;

	//Metodi setter e getters
	
	public Integer getId() {
		return id;
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


	

	

}
