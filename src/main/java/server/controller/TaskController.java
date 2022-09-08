package server.controller;

import server.entity.Task;
import server.service.TaskService;

import java.util.List;

public record TaskController(TaskService taskService) {


    public void createTask(Task task) {
        taskService.createTask(task);

    }


    public List<Task> findAll() {

        return taskService.findAll();
    }


    public List<Task> findAllNotCompletedTasks() {

        return taskService.findAllNotCompletedTasks();
    }


    public List<Task> findAllTasksByAssignedPerson(String person) {

        return taskService.findAllTasksByAssignedPerson(person);
    }

    public List<Task> findAllTasksToBeCompletedThisWeek() {

        return taskService.findAllTasksToBeCompletedThisWeek();
    }


    public void deleteTaskByName(String name) {
        taskService.deleteTaskByName(name);

    }
}
