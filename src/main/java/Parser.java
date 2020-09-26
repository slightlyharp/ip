import Duke.task.Deadlines;
import Duke.task.Events;
import Duke.task.TaskType;
import Duke.task.ToDos;

/**
 * Methods need to parse commend input by user or message from the file storing tasks
 */
public class Parser {

    public static void commandParser(String command){
        String[] words = command.split(" ");
        String action = words[0];
        switch (action) {
        case "list": Duke.tasks.printList();
            break;
        case "done": Duke.tasks.markDone(command);
            break;
        case "todo":
        case "deadline":
        case "event":
            Duke.tasks.addTask(command);
            break;
        case "delete": Duke.tasks.deleteTask(command);
            break;
        case "find": Duke.tasks.findTask(command.replace("find ", ""));
            break;
        default: System.out.println(Messages.line + Messages.spaces
                + "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" + Messages.line);
        }
    }

    public static void fileParser(String command){
        String[] words = command.split("\\|");
        TaskType taskType = TaskType.valueOf(words[0]);
        String taskStatus = words[1];
        String taskName = words[2];
        switch (taskType) {
        case T:
            Duke.tasks.taskList.add(new ToDos(Boolean.parseBoolean(taskStatus),
                    taskName));
            break;
        case D:
            Duke.tasks.taskList.add(new Deadlines(Boolean.parseBoolean(taskStatus),
                    taskName, words[3]));
            break;
        case E:
            Duke.tasks.taskList.add(new Events(Boolean.parseBoolean(taskStatus),
                    taskName, words[3]));
            break;
        default:
            System.out.println("OOPS something wrong with the data file");
            break;
        }
    }
}
