package com.emsbackend.todomanagementsystem.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Document(collection = "todos")
public class Todo {

    @Id
    private String id;

    @Column(name = "title" , nullable = false)
    private String title;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "boolean")
    private boolean completed;
}
