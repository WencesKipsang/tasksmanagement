package com.kipsang.tasksmanagement.dtos;

public class TagSummaryDto {

    private Long id;
    private String name;
    private Long taskCount;

    public TagSummaryDto() {
    }

    public TagSummaryDto(Long id, String name, Long taskCount) {
        this.id = id;
        this.name = name;
        this.taskCount = taskCount;
    }

    public TagSummaryDto(String name, Long taskCount) {
        this.name = name;
        this.taskCount = taskCount;
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

    public Long getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Long taskCount) {
        this.taskCount = taskCount;
    }
}
