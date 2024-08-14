package com.example.gokapture.repository;

import com.example.gokapture.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


    List<Task> findByStatus(String status);

    List<Task> findByPriority(String priority);

    List<Task> findByUserId(Long userId);

    List<Task> findByTitleContainingOrDescriptionContaining(String title, String description);
}