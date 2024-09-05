package com.emsbackend.todomanagementsystem.Repository;

import com.emsbackend.todomanagementsystem.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ToDoRepository extends MongoRepository<Todo,String> {
}
