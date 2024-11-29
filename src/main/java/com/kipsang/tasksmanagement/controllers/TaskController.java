package com.kipsang.tasksmanagement.controllers;


import com.kipsang.tasksmanagement.dtos.TaskDto;
import com.kipsang.tasksmanagement.services.TaskService;
import com.kipsang.tasksmanagement.tokens.CsrfTokensInter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;

    private final CsrfTokensInter csrfTokensInter;

    public TaskController(TaskService taskService, CsrfTokensInter csrfTokensInter) {
        this.taskService = taskService;
        this.csrfTokensInter = csrfTokensInter;
    }

    @GetMapping("/getTokens")
    public CsrfToken Tokens(HttpServletRequest request){
        return  csrfTokensInter.getCsrfToken(request);
    }

    //Create New task
    @PostMapping("/createTasks")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        TaskDto createdTask = taskService.createTask(taskDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }


    // Get all tasks with optional filters
    @GetMapping("/getTasks")
    public ResponseEntity<List<TaskDto>> getAllTasks(
            @RequestParam(required = false) Boolean completed,
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) List<String> tags) {
        List<TaskDto> tasks = taskService.getAllTasks(completed, tags);
        return ResponseEntity.ok(tasks);
    }

    // Update a task
    @PutMapping("/updateTask/{id}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable Long id,
            @RequestBody TaskDto taskDto) {
        TaskDto updatedTask = taskService.updateTask(id, taskDto);
        return ResponseEntity.ok(updatedTask);
    }

    // Delete a task
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
