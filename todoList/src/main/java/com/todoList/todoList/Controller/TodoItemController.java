package com.todoList.todoList.Controller;


import com.todoList.todoList.Service.TodoItemService;
import com.todoList.todoList.model.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping
    public List<TodoItem> getAllItems() {
        return todoItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getItemById(@PathVariable Long id) {
        Optional<TodoItem> item = todoItemService.getItemById(id);
        return item.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TodoItem> createItem(@RequestBody TodoItem item) {
        TodoItem createdItem = todoItemService.createOrUpdateItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> updateItem(@PathVariable Long id, @RequestBody TodoItem item) {
        if (!todoItemService.getItemById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        item.setId(id);
        TodoItem updatedItem = todoItemService.createOrUpdateItem(item);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (!todoItemService.getItemById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        todoItemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
