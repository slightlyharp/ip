import Duke.task.*;
import org.jetbrains.annotations.NotNull;

public class Parser {

    public TaskList taskList;

    public Parser(TaskList taskList){

        this.taskList =  taskList;
    }

    public static void commandParser(String command){
        String[] words = command.split(" ");
        String action = words[0];
        switch (action) {
        case "list": taskList.printList();
            break;
        case "done": TaskList.markDone(command);
            break;
        case "todo":
        case "deadline":
        case "event":
            TaskList.addTask(command);
            break;
        case "delete": TaskList.deleteTask(command);
            break;
        default: System.out.println(Messages.line + Messages.spaces
                + "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" + Messages.line);
        }
    }

    public static void fileParser(@NotNull String command){
        String[] words = command.split("\\|");
        TaskType taskType = TaskType.valueOf(words[0]);
        String taskStatus = words[1];
        String taskName = words[2];
        switch (taskType) {
        case T:
            TaskList.taskList.add(new ToDos(Boolean.parseBoolean(taskStatus),
                    taskName));
            break;
        case D:
            TaskList.taskList.add(new Deadlines(Boolean.parseBoolean(taskStatus),
                    taskName, words[3]));
            break;
        case E:
            TaskList.taskList.add(new Events(Boolean.parseBoolean(taskStatus),
                    taskName, words[3]));
            break;
        default:
            System.out.println("OOPS something wrong with the data file");
            break;
        }
    }
}
