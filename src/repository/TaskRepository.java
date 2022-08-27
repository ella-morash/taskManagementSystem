package repository;

import entity.Task;

import java.util.List;

public interface TaskRepository {
    void persist(Task task);
    List<Task> findAll();
    List<Task> findAllNotCompletedTasks();
    List<Task> findAllTasksByAssignedPerson(String person);
    List<Task> findAllTasksToBeCompletedThisWeek();
    void deleteTaskByName(String name);
}