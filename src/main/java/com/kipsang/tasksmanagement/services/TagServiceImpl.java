package com.kipsang.tasksmanagement.services;

import com.kipsang.tasksmanagement.dtos.TagDetailsDto;
import com.kipsang.tasksmanagement.dtos.TagSummaryDto;
import com.kipsang.tasksmanagement.dtos.TaskDto;
import com.kipsang.tasksmanagement.models.Tag;
import com.kipsang.tasksmanagement.globalExceptions.ResourceNotFoundException;
import com.kipsang.tasksmanagement.repositories.TagRepository;
import com.kipsang.tasksmanagement.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService{
    private final TagRepository tagRepository;
    private final TaskRepository taskRepository;

    public TagServiceImpl(TagRepository tagRepository, TaskRepository taskRepository) {
        this.tagRepository = tagRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TagSummaryDto> getAllTags() {
        return tagRepository.findAll().stream()
                .map(tag -> new TagSummaryDto(tag.getId(), tag.getName(), (long) tag.getTasks().size()))
                .toList();
    }

    @Override
    public TagDetailsDto getTagDetails(Long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found"));

        List<TaskDto> tasks = tag.getTasks().stream()
                .map(task -> new TaskDto(task.getId(), task.getTitle(), task.getCompleted(),
                        task.getTags().stream().map(Tag::getName).toList()))
                .toList();

        return new TagDetailsDto(tag.getId(), tag.getName(), tasks);
    }

    public void deleteTag(Long tagId) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new ResourceNotFoundException("Tag with ID " + tagId + " not found"));

        //Remove the tag association from tasks before deletion
        taskRepository.findAll().forEach(task -> {
            if (task.getTags().contains(tag)) {
                task.getTags().remove(tag);
                taskRepository.save(task);
            }
        });

        tagRepository.delete(tag);
    }
}
