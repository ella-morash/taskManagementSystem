package request;

import java.io.Serializable;

public class Request implements Serializable {
    private final long serialVersionUID = 2L;
    private MappingType mappingType;
    private CommandType commandType;
    private String person;
    private String taskName;
    private TaskDTORequest taskDTORequest;


    public Request(MappingType mappingType, CommandType commandType, TaskDTORequest taskDTORequest) {
        this.mappingType = mappingType;
        this.commandType = commandType;
        this.taskDTORequest = taskDTORequest;

    }

    public Request(MappingType mappingType, CommandType commandType,String taskName) {
        this.mappingType = mappingType;
        this.commandType = commandType;
        this.taskName = taskName;
    }



    public Request(CommandType commandType, String person) {
        this.commandType = commandType;
        this.person = person;
    }



    public MappingType getMappingType() {
        return mappingType;
    }

    public void setMappingType(MappingType mappingType) {
        this.mappingType = mappingType;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public TaskDTORequest getTaskDTORequest() {
        return taskDTORequest;
    }

    public void setTaskDTORequest(TaskDTORequest taskDTORequest) {
        this.taskDTORequest = taskDTORequest;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
