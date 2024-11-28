package com.kipsang.tasksmanagement.dto;

import java.util.List;

public class TagDetailsDto {

    private Long id;
    private String name;
    private List<TaskDto> tasks;

    public TagDetailsDto() {
    }

    public TagDetailsDto(Long id, String name, List<TaskDto> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }

    public TagDetailsDto(String name, List<TaskDto> tasks) {
        this.name = name;
        this.tasks = tasks;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
    }
}
