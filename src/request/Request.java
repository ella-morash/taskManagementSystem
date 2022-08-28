package request;

import java.io.Serializable;

public class Request implements Serializable {
    private final long serialVersionUID = 2L;
    private String mapping;
    private String command;
    private TaskDTORequest taskDTORequest;

    public Request(String mapping, String command) {
        this.mapping = mapping;
        this.command = command;
    }

    public Request(String mapping, String command, TaskDTORequest taskDTORequest) {
        this.mapping = mapping;
        this.command = command;
        this.taskDTORequest = taskDTORequest;
    }


    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public TaskDTORequest getTaskDTORequest() {
        return taskDTORequest;
    }

    public void setTaskDTORequest(TaskDTORequest taskDTORequest) {
        this.taskDTORequest = taskDTORequest;
    }
}
