package com.kipsang.tasksmanagement.repository;

import com.kipsang.tasksmanagement.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository  extends JpaRepository<Tag,Long> {
    Optional<Tag> findByName(String name);
//    List<Tag> findByNameIn(@Param("names") List<String> names);
}
