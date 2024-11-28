package com.kipsang.tasksmanagement.repository;

import com.kipsang.tasksmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task ,Long> {
    List<Task> findByCompleted(Boolean completed);

    List<Task> findByTagsNameIn(List<String> tagNames);

    List<Task> findByCompletedAndTagsNameIn(Boolean completed, List<String> tagNames);
}
