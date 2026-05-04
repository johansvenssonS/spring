package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();

    }

    @PostMapping()
    public void addTodo(@RequestBody TodoDTO todoDTO) {
        todoService.create(todoDTO);
    }
}

