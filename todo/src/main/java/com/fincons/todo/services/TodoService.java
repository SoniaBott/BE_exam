package com.fincons.todo.services;

import java.util.List;

import com.fincons.todo.dto.TodoDto;
import com.fincons.todo.models.entities.Todo;

public interface TodoService {
	
	//Metodo per selezionare tutti i Todo 
	List<TodoDto> selectAllTodo ();
	//metodo per eliminare un todo
	void deleteTodo(Integer id);
	//metodo per inserire un todo
	TodoDto insertTodo(TodoDto dto);
	//metodo per aggiornare un todo
	TodoDto updateTodo(Integer id, TodoDto dto);
	//metodo per trovare i todo in base ad una keyword nel testo del todo
	List<TodoDto> findByKeyword(String keyword);



}
