package com.kipsang.tasksmanagement.repositories;

import com.kipsang.tasksmanagement.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task ,Long> {
    List<Task> findByCompleted(Boolean completed);

    List<Task> findByTagsNameIn(List<String> tagNames);

    List<Task> findByCompletedAndTagsNameIn(Boolean completed, List<String> tagNames);
}

