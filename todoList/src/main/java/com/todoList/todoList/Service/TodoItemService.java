package com.todoList.todoList.Service;

import com.todoList.todoList.Repository.TodoItemRepository;
import com.todoList.todoList.model.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    public List<TodoItem> getAllItems() {
        return todoItemRepository.findAll();
    }

    public Optional<TodoItem> getItemById(Long id) {
        return todoItemRepository.findById(id);
    }

    public TodoItem createOrUpdateItem(TodoItem item) {
        return todoItemRepository.save(item);
    }

    public void deleteItem(Long id) {
        todoItemRepository.deleteById(id);
    }
}
