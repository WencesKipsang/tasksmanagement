package com.kipsang.tasksmanagement.repositories;

import com.kipsang.tasksmanagement.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository  extends JpaRepository<Tag,Long> {
    Optional<Tag> findByName(String name);
//    boolean existsByTagsContaining(Tag tag);
}
