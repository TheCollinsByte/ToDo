package dev.collin.todo.model;

import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.Instant;

/**
 * Task ID:
 *     A unique identifier for each task. This can be an auto-incrementing integer or a UUID
 * Title:
 *     The title or name of the task.
 * Description:
 *     Additional details or notes about the task.
 * Due Date:
 *     The date and time by which the task is expected to be completed.
 * Priority:
 *     An indication of the task's importance or urgency, often represented as a numeric value or a label (e.g., "High," "Medium," "Low").
 * Status:
 *     The current status of the task, such as "Not Started," "In Progress," or "Completed."
 * Category/Project:
 *     The category or project to which the task belongs. This could be a label or reference to a separate table of categories/projects.
 * Tags/Labels:
 *     Any tags or labels associated with the task for better organization and filtering.
 * Creation Date:
 *     The date and time when the task was created.
 * Completion Date:
 *     The date and time when the task was marked as completed.
 * User ID/Owner:
 *     A reference to the user who owns or created the task. This is important for associating tasks with specific users in a multi-user environment.
 * Reminders:
 *     A list of reminders or notifications associated with the task.
 * Comments/Discussions:
 *     If your application supports task discussions, you might want to include a field to store comments or discussions related to the task.
 */
@Component
public class Task {
    private Long id;

    private String title;

    private String description;

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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
