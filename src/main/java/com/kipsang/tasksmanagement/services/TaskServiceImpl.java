package com.kipsang.tasksmanagement.services;


import com.kipsang.tasksmanagement.dtos.TaskDto;
import com.kipsang.tasksmanagement.models.Tag;
import com.kipsang.tasksmanagement.models.Task;
import com.kipsang.tasksmanagement.exceptions.TaskNotFoundException;
import com.kipsang.tasksmanagement.repositories.TagRepository;
import com.kipsang.tasksmanagement.repositories.TaskRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Autowired
    private  TaskRepository taskRepository;
    @Autowired
    private TagRepository tagRepository;

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        // Create or find tags
        List<Tag> tags = taskDto.getTags().stream()
                .map(tagName -> tagRepository.findByName(tagName)
                        .orElseGet(() -> tagRepository.save(new Tag(tagName, null))))
                .toList();

        // Save the task
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setCompleted(taskDto.getCompleted());
        task.setTags(tags);
        Task savedTask = taskRepository.save(task);

        return mapToTaskDto(savedTask);
    }

    @Override
    public List<TaskDto> getAllTasks(Boolean completed, List<String> tags) {
        // Get tasks based on filters completed
        List<Task> tasks;
        if (completed != null && tags != null && !tags.isEmpty()) {
            tasks = taskRepository.findByCompletedAndTagsNameIn(completed, tags);
        } else if (completed != null) {
            tasks = taskRepository.findByCompleted(completed);
        } else if (tags != null && !tags.isEmpty()) {
            tasks = taskRepository.findByTagsNameIn(tags);
        } else {
            tasks = taskRepository.findAll();
        }

        return tasks.stream().map(this::mapToTaskDto).toList();
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto taskDto) {
        // Find the existing task
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id  "+ id));

        // Update task properties
        task.setTitle(taskDto.getTitle());
        task.setCompleted(taskDto.getCompleted());

        // Update tags
        List<Tag> updatedTags = taskDto.getTags().stream()
                .map(tagName -> tagRepository.findByName(tagName)
                        .orElseGet(() -> tagRepository.save(new Tag(tagName, null))))
                .collect(Collectors.toList());

        task.setTags(updatedTags);

        Task updatedTask = taskRepository.save(task);
        return mapToTaskDto(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Task not found with id "+ id);
        }
        taskRepository.deleteById(id);
    }

    private TaskDto mapToTaskDto(Task task) {
        List<String> tagNames = task.getTags().stream().map(Tag::getName).toList();
        return new TaskDto(task.getId(), task.getTitle(), task.getCompleted(), tagNames);
    }
}
