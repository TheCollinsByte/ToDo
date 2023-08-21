package dev.collin.todo.model;

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
public class Task {
    private Long id;

    private String title;

    private String description;

    private Time dueDate;

    private String priority;

    private String status;

    private String category;

    private String tags;

    private Instant creationDate;

    private Time completionDate;

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

    public Time getDueDate() {
        return dueDate;
    }

    public void setDueDate(Time dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Time getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Time completionDate) {
        this.completionDate = completionDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", category='" + category + '\'' +
                ", tags='" + tags + '\'' +
                ", creationDate=" + creationDate +
                ", completionDate=" + completionDate +
                '}';
    }
}
