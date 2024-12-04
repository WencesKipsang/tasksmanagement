package com.kipsang.tasksmanagement.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.*;

public class TaskDto {

    private Long id;

    @NotBlank(message = "Title is required")
    private String title;
    private Boolean completed;
    private List<String> tags;

    public TaskDto() {
    }

    public TaskDto(Long id, String title, Boolean completed, List<String> tags) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.tags = tags;
    }

    public TaskDto(String title, Boolean completed, List<String> tags) {
        this.title = title;
        this.completed = completed;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}

