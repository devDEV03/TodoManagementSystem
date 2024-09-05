package com.emsbackend.todomanagementsystem.Service;

import com.emsbackend.todomanagementsystem.DTO.ToDoDto;

import java.util.List;

public interface ToDoService {
    ToDoDto addToDo(ToDoDto toDoDto);


    List<ToDoDto> getTodos();

    ToDoDto getTodo(String id);

    ToDoDto updateToDo(String id, ToDoDto toDoDto);

    void deleteToDo(String id);

    ToDoDto completeToDo(String id);

    ToDoDto incompleteToDo(String id);
}
