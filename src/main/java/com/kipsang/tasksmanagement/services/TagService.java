package com.kipsang.tasksmanagement.services;

import com.kipsang.tasksmanagement.dtos.TagDetailsDto;
import com.kipsang.tasksmanagement.dtos.TagSummaryDto;

import java.util.List;

public interface TagService {
    List<TagSummaryDto> getAllTags();

    TagDetailsDto getTagDetails(Long id);

    void deleteTag(Long tagId);
}

