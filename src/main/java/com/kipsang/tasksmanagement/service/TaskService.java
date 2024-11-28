package com.kipsang.tasksmanagement.service;

import com.kipsang.tasksmanagement.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);

    List<TaskDto> getAllTasks(Boolean completed, List<String> tags);

    TaskDto updateTask(Long id, TaskDto taskDto);

    void deleteTask(Long id);
}
