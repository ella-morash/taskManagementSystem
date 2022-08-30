package common;

public enum CommandType {

    CREATE_TASK(),
    FIND_ALL,
    FIND_ALL_NOT_COMPLETED,
    FIND_ALL_BY_PERSON,
    FIND_ALL_TO_BE_COMPLETED_THIS_WEEK,
    DELETE_TASK_BY_NAME
    ;

//    private Class<?> classType;
//
//    CommandType(Class<?> classType) {
//        this.classType = classType;
//    }
//
//    public Class<?> getClassType() {
//        return classType;
//    }
}
