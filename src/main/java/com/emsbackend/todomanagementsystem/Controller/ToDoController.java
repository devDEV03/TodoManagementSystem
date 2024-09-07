package com.emsbackend.todomanagementsystem.Controller;


import com.emsbackend.todomanagementsystem.DTO.ToDoDto;
import com.emsbackend.todomanagementsystem.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ToDoDto> addToDo(@RequestBody ToDoDto toDoDto){
        ToDoDto savedtodo = toDoService.addToDo(toDoDto);
        return new ResponseEntity<>(savedtodo, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public ResponseEntity<List<ToDoDto>> getToDos(){
        List<ToDoDto> toDoDtoList = toDoService.getTodos();
        return ResponseEntity.ok(toDoDtoList);
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
    public ResponseEntity<ToDoDto> geToDo(@PathVariable Long id){
        ToDoDto toDoDto = toDoService.getTodo(id);
        return ResponseEntity.ok(toDoDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ToDoDto> updateToDo(@PathVariable Long id,@RequestBody ToDoDto toDoDto){
        ToDoDto updateToDoDto = toDoService.updateToDo(id,toDoDto);
        return ResponseEntity.ok(updateToDoDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable Long id){
        toDoService.deleteToDo(id);
        return ResponseEntity.ok("ToDo has been deleted");
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("/{id}/complete")
    public ResponseEntity<ToDoDto> completeToDo(@PathVariable Long id){
        ToDoDto toDoDto = toDoService.completeToDo(id);
        return ResponseEntity.ok(toDoDto);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("/{id}/incomplete")
    public ResponseEntity<ToDoDto> incompleteToDo(@PathVariable Long id){
        ToDoDto toDoDto = toDoService.incompleteToDo(id);
        return ResponseEntity.ok(toDoDto);
    }
}
