package service;

import entity.Task;

import java.util.List;

public interface TaskService {
    void createTask(Task task);
    List<Task> findAll();
    List<Task> findAllNotCompletedTasks();
    List<Task> findAllTasksByAssignedPerson(String person);
    List<Task> findAllTasksToBeCompletedThisWeek();
    void deleteTaskByName(String name);
}
