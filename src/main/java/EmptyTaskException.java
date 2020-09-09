public class EmptyTaskException extends Exception {
    public String taskType;

    EmptyTaskException(String taskType){
        this.taskType = taskType;
    }

}
