package com.emsbackend.todomanagementsystem.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ToDoDto {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
}
