package com.fincons.todo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fincons.todo.dto.TodoDto;
import com.fincons.todo.services.TodoService;

@RestController

@RequestMapping("/todo")
public class TodoController {
	//il log va messo all'entrata e all'uscita dei metodi
	 private static final Logger logger = LoggerFactory.getLogger("TodoController.class");
	//Inietto nel costruttore del controller il service
	TodoService tS;
	
	public TodoController(TodoService tS) {
		this.tS=tS;
	}
	
	//Definisco un metodo get senza parametri per ottenere tutti i todo
	@GetMapping
	public List<TodoDto> selectAllTodo(){
		logger.info("selectAllTo: start ");
		return tS.selectAllTodo();
	
	}
	
	//Definisco un metodo post per inserire una nuova entity che mi restituisce il dto creato
	//La post crea
	@PostMapping
	public TodoDto insertTodo(@RequestBody TodoDto dto) {
		logger.info("insertTodo: start input: post body ");
		return tS.insertTodo(dto);
	}
	
	//definisco un metodo delete per eliminare una entity conoscendo l'id
	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable("id") Integer id) {
		logger.info("deleteTodo: start input:pathvariable id");
		tS.deleteTodo(id);
	}
	
	//Definisco un metodo per modificare una entity
	//che prende in input il nuovo dto e ne restituisce l'id
	//la put aggiorna
	@PutMapping("/{id}")
	public TodoDto alterTodo(@PathVariable("id") Integer id, @RequestBody TodoDto dto) {
		logger.info("alterTodo: start  input:pathvariable:id and put body ");
		return tS.updateTodo(id,dto);
	}
	
	@GetMapping("/{keyword}")
	public List<TodoDto> getByKeyword(@PathVariable("keyword") String keyword){
		return tS.findByKeyword(keyword);
	}
	




}
