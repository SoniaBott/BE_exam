package com.fincons.todo.models.utils;

import com.fincons.todo.dto.TodoDto;
import com.fincons.todo.models.entities.Todo;

public class TodoUtils {
	
	//Metodo per convertire una entity in dto
	public static TodoDto fromTodoToTodoDto(Todo t) {
		TodoDto todoDto=new TodoDto();
		
		todoDto.setId(t.getId());
		todoDto.setTodoText(t.getTodoText());
		todoDto.setState(t.getState());
		todoDto.setCreatedAt(t.getCreatedAt());
		todoDto.setDueDate(t.getDueDate());
		
		return todoDto;
	}
	
	public static Todo fromTodoDtoToTodo(TodoDto dto) {
		Todo t=new Todo();
		t.setId(dto.getId());
		t.setTodoText(dto.getTodoText());
		t.setState(dto.getState());
		t.setCreatedAt(dto.getCreatedAt());
		t.setDueDate(dto.getDueDate());
		
		return t;
	}

}
