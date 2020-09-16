package Duke.task;

import Duke.task.EmptyTaskException;
import Duke.task.Task;
import Duke.task.TaskType;

public class ToDos extends Task {
    public ToDos(String command) throws EmptyTaskException {
        super(getTask(command), TaskType.T);
    }

    public static String getTask(String command) throws EmptyTaskException {
        if ((( command.replace("todo", "")).replace(" ", "")).isEmpty()){
            throw new EmptyTaskException("todo");
        } else{
            int spaceIndex = command.indexOf(" ");
            return command.substring(spaceIndex + 1, command.length());
        }
    }
}

