package server;

import server.controller.TaskController;
import server.entity.Task;
import common.Request;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ServerRequestParser {

    public static void parseRequest(Request request, TaskController taskController, ObjectOutputStream oos) throws IOException {

        switch (request.getCommandType()) {
            case FIND_ALL -> oos.writeObject(taskController.findAll());
            case FIND_ALL_BY_PERSON ->
                    oos.writeObject(taskController.findAllTasksByAssignedPerson(request.getPerson()));

            case FIND_ALL_NOT_COMPLETED -> oos.writeObject(taskController.findAllNotCompletedTasks());

            case CREATE_TASK -> {
                taskController.createTask((new Task(

                        request.getTaskDTORequest().getName()
                        , request.getTaskDTORequest().isCompleted()
                        , request.getTaskDTORequest().getAssignedPerson()
                        , request.getTaskDTORequest().getCreatedDate()
                        , request.getTaskDTORequest().getCompletionDate())));
                oos.writeObject("created");
            }

            case FIND_ALL_TO_BE_COMPLETED_THIS_WEEK ->
                    oos.writeObject(taskController.findAllTasksToBeCompletedThisWeek());

            case DELETE_TASK_BY_NAME -> taskController.deleteTaskByName(request.getTaskName());

            default -> oos.writeObject("Unprocessable request");
        }
    }
}


abstract class ResponseProcessor {
    private ObjectOutputStream oos;
    abstract Object getResponseAction();
    void sendResponse() {
        Object response = getResponseAction();
        if (response == null) {
            response = "completed";
        }

//        oos.writeObject(response);
    }
}

class FindAllProcessor extends ResponseProcessor {
    @Override
    Object getResponseAction() {
        return new ArrayList<>() {{
            add("peter");
            add("john");
        }};
    }
}
class CreateTaskProcessor extends ResponseProcessor {

    @Override
    Object getResponseAction() {
        return null;
    }
}