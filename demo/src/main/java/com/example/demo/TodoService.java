package com.example.demo;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {



    private final TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public void create(TodoDTO todoDTO) {
        Todo todo = new Todo(todoDTO.getTitle(), false);
         todoRepository.save(todo);
    }
}
