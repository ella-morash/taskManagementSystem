package server.repository.impl;

import server.entity.Task;
import server.repository.TaskRepository;
import server.utils.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class TaskRepositoryFileSystemImpl implements TaskRepository {

    private  ArrayList<Task> listOfTasks ;
    private  Map<String,List<Task>> personToTasksMap ;
    private  Set<String> taskNameSet;

    private ArrayList<Task> getListOfTasks() {

        String path = Constants.BASE_FOLDER
                + File.separator
                + Constants.CHILD_FOLDER
                + File.separator
                + Constants.TASK_LIST_PATH;

        File file = new File(path);
        if(!file.exists()) {
            return new ArrayList<>();
        }
        listOfTasks = new ArrayList<>();
        List<Task> tasks =FileReader.readFromFile(path);
        this.listOfTasks.addAll(tasks);
        return listOfTasks;

    }
    private Set<String> getTaskNameSet(){
        return  getListOfTasks().stream()
                .map(Task::getName)
                .collect(Collectors.toSet());
    }



    private Map<String,List<Task>> getPersonToTasksMap(){
        personToTasksMap = getListOfTasks().stream()
                                           .collect(Collectors.groupingBy(Task::getAssignedPerson
                                                                           ,Collectors.toList()));


        return personToTasksMap;


    }

    @Override
    public void persist(Task task) {

        listOfTasks = getListOfTasks();
        taskNameSet = getTaskNameSet();

        if(!taskNameSet.add(task.getName())) {
            throw new UnsupportedOperationException(String.format(
                    "Task with name %s already exists in the system",task.getName()
            ));

        }

        listOfTasks.add(task);

        String pathOfTaskFile = "";
        String pathListOfTasks = "";
        try {
              pathListOfTasks = FileInitializer.initListOfTasksFile();
              pathOfTaskFile = FileInitializer.initTaskFile(task.getName());

        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter.writeToFile(pathListOfTasks,listOfTasks);
        FileWriter.writeToFile(pathOfTaskFile,task);


    }

    @Override
    public List<Task> findAll() {
        return getListOfTasks();
    }

    @Override
    public List<Task> findAllNotCompletedTasks() {
        return  getListOfTasks().stream()
                .filter(t-> !t.isCompleted())
                .toList();
    }

    @Override
    public List<Task> findAllTasksByAssignedPerson(String person) {
        return getPersonToTasksMap().get(person);
    }

    @Override
    public List<Task> findAllTasksToBeCompletedThisWeek() {

        return  getListOfTasks().stream()
                .filter(entry->Period.between(LocalDate.now(),entry.getCompletionDate()).getDays()<7)
                .toList();


    }

    @Override
    public void deleteTaskByName(String name) {
        taskNameSet = getTaskNameSet();
        listOfTasks = getListOfTasks();

        if (!taskNameSet.contains(name)) {
            throw new IllegalStateException(String.format("There is no task with name %s",name));
        }

        listOfTasks = new ArrayList<>(listOfTasks.stream()
                .filter(t->!t.getName().equals(name))
                .toList());

        String pathOfTaskFile = "";
        String pathListOfTasks = "";
        try {
            pathListOfTasks = FileInitializer.initListOfTasksFile();
            pathOfTaskFile = FileInitializer.initTaskFile(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter.writeToFile(pathListOfTasks,listOfTasks);
        FileEraser.deleteFile(pathOfTaskFile);




    }
}
