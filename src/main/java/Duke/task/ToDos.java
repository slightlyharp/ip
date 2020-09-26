package Duke.task;

/**
 * Represent a task that need to be done
 */
public class ToDos extends Task {

    /**
     *Construct the event object from user command
     * @param command User input with todo key word
     * @throws EmptyTaskException when there is no task name provided
     */
    public ToDos(String command) throws EmptyTaskException {
        super(getTask(command), TaskType.T);
    }

    /**
     * Construct the todo object from file
     * @param isDone whether the task is done
     * @param task name of the task
     */
    public ToDos(boolean isDone, String task){
        super(task, TaskType.T, isDone);
    }

    /**
     * get the name of task from user input
     * @param command User input
     * @return the name of the task
     * @throws EmptyTaskException if there is no name of task input
     */
    public static String getTask(String command) throws EmptyTaskException {
        if ((( command.replace("todo", "")).replace(" ", "")).isEmpty()){
            throw new EmptyTaskException("todo");
        } else{
            int spaceIndex = command.indexOf(" ");
            return command.substring(spaceIndex + 1);
        }
    }

    /**
     * return null since the task do not have a time variable
     * @return null
     */
    @Override
    public String getTime() {
        return null;
    }
}

