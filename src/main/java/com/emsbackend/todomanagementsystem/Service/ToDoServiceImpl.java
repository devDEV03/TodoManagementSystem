package com.emsbackend.todomanagementsystem.Service;

import com.emsbackend.todomanagementsystem.DTO.ToDoDto;
import com.emsbackend.todomanagementsystem.Entity.Todo;
import com.emsbackend.todomanagementsystem.Mapper.TodoMapper;
import com.emsbackend.todomanagementsystem.Repository.ToDoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
@AllArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ToDoDto addToDo(ToDoDto toDoDto) {
        Todo todo = modelMapper.map(toDoDto,Todo.class);
       Todo savedTodo = toDoRepository.save(todo);
       return modelMapper.map(savedTodo,ToDoDto.class);
    }

    @Override
    public List<ToDoDto> getTodos() {
        List<Todo> todoList = toDoRepository.findAll();
        return todoList.stream().map((todos) -> modelMapper.map(todos,ToDoDto.class)).collect(Collectors.toList());
    }

    @Override
    public ToDoDto getTodo(Long id) {
        Todo todo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo doesn't exist"));
        return modelMapper.map(todo,ToDoDto.class);
    }

    @Override
    public ToDoDto updateToDo(Long id, ToDoDto toDoDto) {
        Todo todo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo doesn't exist"));
        todo.setTitle(toDoDto.getTitle());
        todo.setDescription(toDoDto.getDescription());
        todo.setCompleted(toDoDto.isCompleted());
        return modelMapper.map(todo,ToDoDto.class);
    }

    @Override
    public void deleteToDo(Long id) {
        Todo todo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo doesn't exist"));
        toDoRepository.delete(todo);
    }

    @Override
    public ToDoDto completeToDo(Long id) {
        Todo todo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo doesn't exist"));
        todo.setCompleted(Boolean.TRUE);
        Todo savedToDo = toDoRepository.save(todo);
        return modelMapper.map(savedToDo,ToDoDto.class);
    }

    @Override
    public ToDoDto incompleteToDo(Long id) {
        Todo todo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo doesn't exist"));
        todo.setCompleted(Boolean.FALSE);
        Todo savedToDo = toDoRepository.save(todo);
        return modelMapper.map(savedToDo,ToDoDto.class);
    }

}
