import Duke.task.Deadlines;
import Duke.task.EmptyTaskException;
import Duke.task.Events;
import Duke.task.Task;
import Duke.task.ToDos;

import java.util.ArrayList;

public class TaskList {

    public ArrayList<Task> taskList;
    public static Storage file;
    public final String filePath = "tasks.txt";

    public TaskList(){
        ArrayList<Task> taskList = new ArrayList<>();
        file = new Storage(filePath);
    }

    public static void printList() {
        System.out.println(Messages.listMessage);
        for(int i = 0; i< taskList.size(); i++){
            System.out.print("    " + (i+1) + ".");
            taskList.get(i).printTask();
            System.out.println();
        }
        System.out.println(Messages.line);
    }

    public static void markDone(String command) {
        int taskIndex = Integer.parseInt(command.replaceAll("[^0-9]", ""));
        taskIndex--;

        taskList.get(taskIndex).markDone();
        Storage.rewriteFile();
        System.out.println(Messages.markDoneMessage + taskList.get(taskIndex).getStatusIcon()
                + taskList.get(taskIndex).task );
    }

    public static void addTask(String command) {
        try {
            if (command.contains("todo")) {
                taskList.add(new ToDos(command));
            } else if (command.contains("deadline")) {
                taskList.add(new Deadlines(command));
            } else if (command.contains("event")) {
                taskList.add(new Events(command));

            }
            Storage.writeFile(taskList.get(taskList.size()-1));
            System.out.print(Messages.addTaskMessage);
            taskList.get(taskList.size()-1).printTask();
            System.out.println("\n" + Messages.spaces + "Now you have " + taskList.size()
                    + " tasks in the list.\n" + Messages.line);
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println(Messages.outOfBoundsExceptionMessage);
        }
        catch (EmptyTaskException e){
            System.out.println(Messages.emptyTaskMessage);
        }
    }

    public static void deleteTask(String command) {
        int taskIndex = Integer.parseInt(command.replaceAll("[^0-9]", ""));
        taskIndex--;
        Storage.rewriteFile();
        System.out.print(Messages.deleteMessage);
        taskList.get(taskIndex).printTask();
        System.out.println("\n    Now you have " + (taskList.size()-1) + " tasks in the list.");
        taskList.remove(taskIndex);
        System.out.println(Messages.line);
    }
}
