package com.emsbackend.todomanagementsystem.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TodoAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;
}
