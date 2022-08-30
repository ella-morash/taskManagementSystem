package server.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Task implements Serializable {
    private final long serialVersionUID = 1L;
    private String name;
    private boolean isCompleted;
    private String assignedPerson;
    private LocalDate createdDate;
    private LocalDate completionDate;


    public Task(String name, boolean isCompleted, String assignedPerson, LocalDate createdDate, LocalDate completionDate) {
        this.name = name;
        this.isCompleted = isCompleted;
        this.assignedPerson = assignedPerson;
        this.createdDate = createdDate;
        this.completionDate = completionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return isCompleted == task.isCompleted && Objects.equals(name, task.name) && Objects.equals(assignedPerson, task.assignedPerson) && Objects.equals(createdDate, task.createdDate) && Objects.equals(completionDate, task.completionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isCompleted, assignedPerson, createdDate, completionDate);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", isCompleted=" + isCompleted +
                ", assignedPerson='" + assignedPerson + '\'' +
                ", createdDate=" + createdDate +
                ", completionDate=" + completionDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getAssignedPerson() {
        return assignedPerson;
    }

    public void setAssignedPerson(String assignedPerson) {
        this.assignedPerson = assignedPerson;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }
}
