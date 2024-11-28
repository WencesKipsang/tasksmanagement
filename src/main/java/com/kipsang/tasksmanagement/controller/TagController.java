package com.kipsang.tasksmanagement.controller;

import com.kipsang.tasksmanagement.dto.TagDetailsDto;
import com.kipsang.tasksmanagement.dto.TagSummaryDto;
import com.kipsang.tasksmanagement.service.TagService;
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
}
