import Duke.task.Deadlines;
import Duke.task.EmptyTaskException;
import Duke.task.Events;
import Duke.task.Task;
import Duke.task.ToDos;

import java.util.ArrayList;

/**
 *Represent the list of tasks recorded
 * contains operation to edit the list
 */
public class TaskList {

    public ArrayList<Task> taskList;

    public TaskList(){
        taskList = new ArrayList<>();
    }

    /**
     * display all the tasks store in the task list
     */
    public void printList() {
        System.out.println(Messages.listMessage);
        for(int i = 0; i< taskList.size(); i++){
            System.out.print("    " + (i+1) + ".");
            taskList.get(i).printTask();
            System.out.println();
        }
        System.out.println(Messages.line);
    }

    /**
     *Change the status of isDone of the particular task in the list from false to true
     *
     * @param command User input that contain keyword "done" and a number correspond to the index to the task
     */
    public void markDone(String command) {
        int taskIndex = Integer.parseInt(command.replaceAll("[^0-9]", ""));
        taskIndex--;

        taskList.get(taskIndex).markDone();
        Duke.file.rewriteFile();
        System.out.println(Messages.markDoneMessage + taskList.get(taskIndex).getStatusIcon()
                + taskList.get(taskIndex).task );
    }

    /**
     * Add a new task to the task list
     *
     * @param command user input that contain the task type key word, task name and time
     */
    public void addTask(String command) {
        try {
            if (command.contains("todo")) {
                taskList.add(new ToDos(command));
            } else if (command.contains("deadline")) {
                taskList.add(new Deadlines(command));
            } else if (command.contains("event")) {
                taskList.add(new Events(command));

            }
            Duke.file.writeFile(taskList.get(taskList.size()-1));
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

    /**
     * delete a specific tasks from the list
     *
     * @param command user input that contain key word "delete" and the index of the specific task
     */
    public void deleteTask(String command) {
        int taskIndex = Integer.parseInt(command.replaceAll("[^0-9]", ""));
        taskIndex--;
        Duke.file.rewriteFile();
        System.out.print(Messages.deleteMessage);
        taskList.get(taskIndex).printTask();
        System.out.println("\n    Now you have " + (taskList.size()-1) + " tasks in the list.");
        taskList.remove(taskIndex);
        System.out.println(Messages.line);
    }
}
