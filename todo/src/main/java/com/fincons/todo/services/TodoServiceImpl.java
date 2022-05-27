package com.fincons.todo.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fincons.todo.dto.TodoDto;
import com.fincons.todo.models.entities.Todo;
import com.fincons.todo.models.utils.DataUtils;
import com.fincons.todo.models.utils.TodoUtils;
import com.fincons.todo.repositories.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService{
	
	TodoRepository tR;
	//il log va messo all'entrata e all'uscita dei metodi
	private static final Logger logger = LoggerFactory.getLogger("TodoServiceImpl.class");
	
	//Constructor injection per poter utilizzare i metodi della repository
	public TodoServiceImpl(TodoRepository tR) {
		logger.info("constructor injction");
		this.tR=tR;
	}

	//Override del metodo per selezionare tutti i todo
	@Override
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<TodoDto> selectAllTodo() {
		logger.info("selectAllTo: start ");
		//chiamo la findall di hibernate per ottenere tutti i todo del database
		List<Todo> todoList=tR.findAll();
		List<TodoDto> dtoList=new ArrayList<TodoDto>();
		
		//Converto ogni entity in dto 
		//metiante il metodo statico fornito dalla classe TodoUtils
		todoList.stream().forEach(u->dtoList.add(TodoUtils.fromTodoToTodoDto(u)));
		
		logger.info("selectAllTo: end");
		return dtoList;
		
	}

	//Override del metodo per la delete
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void deleteTodo(Integer id) {
		logger.info("deleteTodo: start");
		tR.delete(tR.findById(id));
		logger.info("deleteTodo: end");
	}
	
	
	//Override del metodo per per la post
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public TodoDto insertTodo(TodoDto dto) {
		logger.info("insertTodo: start");
		//Genero la data corrente
		Date date = Calendar.getInstance().getTime(); 
		dto.setCreatedAt(date);
		
		//Controllo il campo dueDate del dto se la stringa è vuota lo genero n giorni dopo con il metodo in DataUtils
		if (dto.getDueDate()==null) {
			dto.setDueDate(DataUtils.dueDateDef(date));
		}else {
			
			dto.setDueDate(dto.getDueDate());
		}

		//Creo una entity per inserire il nuovo todo
		Todo t=TodoUtils.fromTodoDtoToTodo(dto);
		
		logger.info("insertTodo: end");
		//salvo la nuova entity e la restituisco come dto
		return TodoUtils.fromTodoToTodoDto(tR.save(t));
		
	}
	

	@Override //del metodo per la put
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public TodoDto updateTodo(Integer id, TodoDto dto) {
		logger.info("updateTodo: start");
		tR.delete(tR.findById(id));
		//creo la nuova entity
		Todo t=TodoUtils.fromTodoDtoToTodo(dto);
		//salvo la nuova entity
		TodoDto dtoNew=TodoUtils.fromTodoToTodoDto(tR.save(t));
		logger.info("updateTodo: end");
		//teoricamente se va ristituisco l'id
		return dtoNew;
	}
	
	
	@Override //del metodo per la get con una keyword
	public List<TodoDto> findByKeyword(String keyword){
		logger.info("findByKeyword: start");
		List<Todo> todoList=tR.findByKeyWord(keyword);
		List<TodoDto> dtoList=new ArrayList<TodoDto>();
		//Converto ogni entity in dto 
		//metiante il metodo statico fornito dalla classe TodoUtils
		todoList.stream().forEach(u->dtoList.add(TodoUtils.fromTodoToTodoDto(u)));
		logger.info("findByKeyWord: end");
		return dtoList;
				
	}

	
	

}
