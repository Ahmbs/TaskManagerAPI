package com.example.TaskManagerAPI.repository;

import com.example.TaskManagerAPI.model.Task;
import com.example.TaskManagerAPI.model.Task.Priority;
import com.example.TaskManagerAPI.model.Task.Status;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecifications {
    public static Specification<Task> hasTitle(String title) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), "%" + title + "%");
    }

    public static Specification<Task> hasResponsible(String responsible) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("assignee"), "%" + responsible + "%");
    }

    public static Specification<Task> hasPriority(Priority priority) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("priority"), priority);
    }

    public static Specification<Task> hasStatus(Status status) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
    }
}
