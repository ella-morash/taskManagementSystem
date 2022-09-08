package server.service.impl;

import server.entity.Task;
import server.repository.TaskRepository;
import server.service.TaskService;

import java.util.List;

public record TaskServiceFileSystemImpl(TaskRepository taskRepository) implements TaskService {

    @Override
    public void createTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Must be not null");
        }
        taskRepository.persist(task);

    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findAllNotCompletedTasks() {

        return taskRepository.findAllNotCompletedTasks();
    }

    @Override
    public List<Task> findAllTasksByAssignedPerson(String person) {

        return taskRepository.findAllTasksByAssignedPerson(person);
    }

    @Override
    public List<Task> findAllTasksToBeCompletedThisWeek() {

        return taskRepository.findAllTasksToBeCompletedThisWeek();
    }

    @Override
    public void deleteTaskByName(String name) {
        taskRepository.deleteTaskByName(name);


    }
}
