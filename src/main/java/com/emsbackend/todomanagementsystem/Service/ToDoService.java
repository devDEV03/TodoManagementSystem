package com.emsbackend.todomanagementsystem.Service;

import com.emsbackend.todomanagementsystem.DTO.ToDoDto;

import java.util.List;

public interface ToDoService {
    ToDoDto addToDo(ToDoDto toDoDto);

    List<ToDoDto> getTodos();

    ToDoDto getTodo(Long id);

    ToDoDto updateToDo(Long id, ToDoDto toDoDto);

    void deleteToDo(Long id);

    ToDoDto completeToDo(Long id);

    ToDoDto incompleteToDo(Long id);
}
