import Duke.task.*;

import java.util.ArrayList;

public class TaskList {

    public ArrayList<Task> taskList;

    public TaskList(){
        taskList = new ArrayList<>();
    }

    public void printList() {
        System.out.println(Messages.listMessage);
        for(int i = 0; i< taskList.size(); i++){
            System.out.print("    " + (i+1) + ".");
            taskList.get(i).printTask();
            System.out.println();
        }
        System.out.println(Messages.line);
    }

    public void markDone(String command) {
        int taskIndex = Integer.parseInt(command.replaceAll("[^0-9]", ""));
        taskIndex--;

        taskList.get(taskIndex).markDone();
        Duke.file.rewriteFile();
        System.out.println(Messages.markDoneMessage + taskList.get(taskIndex).getStatusIcon()
                + taskList.get(taskIndex).task );
    }

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
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid date and time format");
        }
    }

    public void deleteTask(String command) {
        int taskIndex = Integer.parseInt(command.replaceAll("[^0-9]", ""));
        taskIndex--;
        System.out.print(Messages.deleteMessage);
        taskList.get(taskIndex).printTask();
        System.out.println("\n    Now you have " + (taskList.size()-1) + " tasks in the list.");
        taskList.remove(taskIndex);
        Duke.file.rewriteFile();
        System.out.println(Messages.line);
    }
}
