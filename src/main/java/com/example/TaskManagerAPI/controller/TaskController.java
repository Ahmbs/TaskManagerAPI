package com.example.TaskManagerAPI.controller;

import com.example.TaskManagerAPI.dto.TaskDTO;
import com.example.TaskManagerAPI.model.Task;
import com.example.TaskManagerAPI.model.Task.Priority;
import com.example.TaskManagerAPI.model.Task.Status;
import com.example.TaskManagerAPI.repository.TaskRepository;
import com.example.TaskManagerAPI.repository.TaskSpecifications;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String assignee,
            @RequestParam(required = false) Priority priority,
            @RequestParam(required = false) Status status) {
        Specification<Task> spec = Specification.where(null);
        if (title != null) {
            spec = spec.and(TaskSpecifications.hasTitle(title));
        }
        if (assignee != null) {
            spec = spec.and(TaskSpecifications.hasResponsible(assignee));
        }
        if (priority != null) {
            spec = spec.and(TaskSpecifications.hasPriority(priority));
        }
        if (status != null) {
            spec = spec.and(TaskSpecifications.hasStatus(status));
        } else {
            spec = spec.and(TaskSpecifications.hasStatus(Status.EM_ANDAMENTO));
        }

        List<Task> tasks = taskRepository.findAll(spec);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody @Valid TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.title());
        task.setDescription(taskDTO.description());
        task.setAssignee(taskDTO.assignee());
        task.setPriority(taskDTO.priority());
        task.setDeadline(taskDTO.deadline());
        this.taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody @Valid TaskDTO taskDTO) {
        Task task = this.taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(taskDTO.title());
        task.setDescription(taskDTO.description());
        task.setAssignee(taskDTO.assignee());
        task.setPriority(taskDTO.priority());
        task.setDeadline(taskDTO.deadline());
        this.taskRepository.save(task);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Task> completeTask(@PathVariable Long id) {
        Task task = this.taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(Status.CONCLUIDA);
        taskRepository.save(task);
        return ResponseEntity.ok(task);
    }
}
