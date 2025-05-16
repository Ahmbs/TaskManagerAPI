package com.example.TaskManagerAPI.dto;

import com.example.TaskManagerAPI.model.Task.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record TaskDTO(
        @NotBlank @Size(max = 100) String title,
        @NotBlank @Size(max = 500) String description,
        @NotBlank @Size(max = 50) String assignee,
        @NotNull Priority priority,
        @NotNull LocalDate deadline
) {
}
