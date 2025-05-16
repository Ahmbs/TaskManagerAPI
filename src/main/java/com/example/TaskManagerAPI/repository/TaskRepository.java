package com.example.TaskManagerAPI.repository;
import com.example.TaskManagerAPI.model.Task;
import com.example.TaskManagerAPI.model.Task.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {
    List<Task> findByStatus(Status status);
}
