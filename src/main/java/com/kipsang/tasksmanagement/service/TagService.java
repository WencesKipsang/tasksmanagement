package com.kipsang.tasksmanagement.service;

import com.kipsang.tasksmanagement.dto.TagDetailsDto;
import com.kipsang.tasksmanagement.dto.TagSummaryDto;

import java.util.List;

public interface TagService {
    List<TagSummaryDto> getAllTags();

    TagDetailsDto getTagDetails(Long id);
}
