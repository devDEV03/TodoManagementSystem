package com.emsbackend.todomanagementsystem.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title" , nullable = false)
    private String title;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "boolean")
    private boolean completed;
}
