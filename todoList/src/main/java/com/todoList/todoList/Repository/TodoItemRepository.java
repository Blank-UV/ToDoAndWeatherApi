package com.todoList.todoList.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todoList.todoList.model.*;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
