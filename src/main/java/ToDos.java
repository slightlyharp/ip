public class ToDos extends Task{
    public ToDos(String command) throws EmptyTaskException {
        super(getTask(command), TaskType.T);
    }

    public ToDos(boolean isDone, String task){
        super(task, TaskType.T, isDone);
    }

    public static String getTask(String command) throws EmptyTaskException {
        if ((( command.replace("todo", "")).replace(" ", "")).isEmpty()){
            throw new EmptyTaskException("todo");
        } else{
            int spaceIndex = command.indexOf(" ");
            return command.substring(spaceIndex + 1);
        }
    }

    @Override
    public String getTime() {
        return null;
    }
}

