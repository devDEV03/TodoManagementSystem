package com.emsbackend.todomanagementsystem.Controller;


import com.emsbackend.todomanagementsystem.DTO.ToDoDto;
import com.emsbackend.todomanagementsystem.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public ResponseEntity<ToDoDto> addToDo(@RequestBody ToDoDto toDoDto){
        ToDoDto savedtodo = toDoService.addToDo(toDoDto);
        return new ResponseEntity<>(savedtodo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ToDoDto>> getToDos(){
        List<ToDoDto> toDoDtoList = toDoService.getTodos();
        return ResponseEntity.ok(toDoDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoDto> geToDo(@PathVariable String id){
        ToDoDto toDoDto = toDoService.getTodo(id);
        return ResponseEntity.ok(toDoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoDto> updateToDo(@PathVariable String id,@RequestBody ToDoDto toDoDto){
        ToDoDto updateToDoDto = toDoService.updateToDo(id,toDoDto);
        return ResponseEntity.ok(updateToDoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable String id){
        toDoService.deleteToDo(id);
        return ResponseEntity.ok("ToDo has been deleted");
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<ToDoDto> completeToDo(@PathVariable String id){
        ToDoDto toDoDto = toDoService.completeToDo(id);
        return ResponseEntity.ok(toDoDto);
    }

    @PatchMapping("/{id}/incomplete")
    public ResponseEntity<ToDoDto> incompleteToDo(@PathVariable String id){
        ToDoDto toDoDto = toDoService.incompleteToDo(id);
        return ResponseEntity.ok(toDoDto);
    }
}
