package common;

import java.io.Serializable;
import java.time.LocalDate;

public class TaskDTORequest implements Serializable {
    private final long serialVersionUID = 3L;
    private String name;
    private boolean isCompleted;
    private String assignedPerson;
    private LocalDate createdDate;
    private LocalDate completionDate;

    public TaskDTORequest(String name, boolean isCompleted, String assignedPerson, LocalDate createdDate, LocalDate completionDate) {
        this.name = name;
        this.isCompleted = isCompleted;
        this.assignedPerson = assignedPerson;
        this.createdDate = createdDate;
        this.completionDate = completionDate;
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
