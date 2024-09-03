package com.emsbackend.todomanagementsystem.Mapper;

import com.emsbackend.todomanagementsystem.DTO.ToDoDto;
import com.emsbackend.todomanagementsystem.Entity.Todo;

public class TodoMapper {
    public static ToDoDto changestoTODODTO(Todo todo){
        ToDoDto toDoDto = new ToDoDto(todo.getId(),todo.getTitle(),todo.getDescription(),todo.isCompleted());
        return toDoDto;
    }

    public static Todo changestoTODO(ToDoDto toDoDto){
        Todo todo = new Todo(toDoDto.getId(),toDoDto.getTitle(),toDoDto.getDescription(),toDoDto.isCompleted());
        return todo;
    }
}
