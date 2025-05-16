package com.example.TaskManagerAPI.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table (name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public boolean isCompleted() {
        return this.status == Status.CONCLUIDA;
    }

    private String title;
    private String description;
    private String assignee;

    @Enumerated(EnumType.STRING)
    private Priority priority;
    public enum Priority {
        ALTA, MEDIA, BAIXA
    }
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private Status status = Status.EM_ANDAMENTO;
    public enum Status{
        EM_ANDAMENTO,CONCLUIDA
    }
}
