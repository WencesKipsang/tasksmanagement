package com.kipsang.tasksmanagement.controllers;

import com.kipsang.tasksmanagement.dtos.TagDetailsDto;
import com.kipsang.tasksmanagement.dtos.TagSummaryDto;
import com.kipsang.tasksmanagement.services.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    // Get all tags with task count
    @GetMapping("/getTags")
    public ResponseEntity<List<TagSummaryDto>> getAllTags() {
        List<TagSummaryDto> tags = tagService.getAllTags();
        return ResponseEntity.ok(tags);
    }

    // Get details of a specific tag
    @GetMapping("/getTagDetails/{id}")
    public ResponseEntity<TagDetailsDto> getTagDetails(@PathVariable Long id) {
        TagDetailsDto tagDetails = tagService.getTagDetails(id);
        return ResponseEntity.ok(tagDetails);
    }

    @DeleteMapping("/tags/{tagId}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long tagId) {
        tagService.deleteTag(tagId);
        return ResponseEntity.noContent().build(); // Respond with HTTP 204 No Content
    }
}
