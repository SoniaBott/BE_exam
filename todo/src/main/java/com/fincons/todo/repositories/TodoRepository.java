package com.fincons.todo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fincons.todo.models.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long>{
	
	//Definisco la query per ottenere un todo tramite id
	@Query("select t from Todo t where t.id= :id")
	Todo findById(@Param("id") Integer id);
	
	//Definisco la query per ottenere todo che contengono una certa parola
	@Query("select t from Todo t where t.todoText like %:keyword%")
	List<Todo> findByKeyWord(@Param("keyword") String keyword);
	

}
