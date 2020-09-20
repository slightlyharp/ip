import Duke.task.Deadlines;
import Duke.task.EmptyTaskException;
import Duke.task.Events;
import Duke.task.Task;
import Duke.task.ToDos;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static ArrayList<Task> taskList;
    public static final String line = "    ____________________________________________________________\n";
    public static final String spaces = "    ";

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String greeting = "    ____________________________________________________________\n" +
                "     Hello! I'm Duke\n" +
                "     What can I do for you?\n" +
                "    ____________________________________________________________\n";
        String bye = "     Bye. Hope to see you again soon!\n" +
                "    ____________________________________________________________";
        String command = "null";

        taskList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        FileClass file = new FileClass("tasks.txt");

        System.out.println(greeting);
        while (!command.equals("bye")) {
            command = in.nextLine();
            if (command.equals("bye")) {
                System.out.println(line + bye);
            } else if(command.equals("list")){
                printList();
            } else if(command.contains("done")){
                markDone(command, file);
            } else if(command.contains("todo")|| command.contains("deadline")|| command.contains("event")){
                addTask(command, file);
            } else if(command.contains("delete")){
                deleteTask(command, file);
            }else {
                System.out.println(line + spaces + "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" + line);
            }
        }
    }

    public static void deleteTask(String command, FileClass file) {
        int taskIndex = Integer.parseInt(command.replaceAll("[^0-9]", ""));
        taskIndex--;
        writeFile(file);
        System.out.print(line + "    Noted. I've removed this task:\n    ");
        taskList.get(taskIndex).printTask();
        System.out.println("\n    Now you have " + (taskList.size()-1) + " tasks in the list.");
        taskList.remove(taskIndex);
        System.out.println(line);
    }

    public static void addTask(String command, FileClass file) {
        try {
            if (command.contains("todo")) {
                taskList.add(new ToDos(command));
            } else if (command.contains("deadline")) {
                taskList.add(new Deadlines(command));
            } else if (command.contains("event")) {
                taskList.add(new Events(command));

            }
            file.writeFile(taskList.get(taskList.size()-1));
            System.out.println(line + spaces + "Got it. I've added this task:");
            System.out.print(spaces + spaces);
            taskList.get(taskList.size()-1).printTask();
            System.out.println("\n" + spaces + "Now you have " + taskList.size()
                    + " tasks in the list.\n" + line);
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println(line + spaces + "☹ OOPS!!! The description do not fulfil the specific task requirement.\n" + line);
        }
        catch (EmptyTaskException e){
            System.out.println(line + spaces + "☹ OOPS!!! The description of a " + e.taskType + " cannot be empty.\n" + line);
        }
    }

    public static void markDone(String command, FileClass file) {
        int taskIndex = Integer.parseInt(command.replaceAll("[^0-9]", ""));
        taskIndex--;

        taskList.get(taskIndex).markDone();
        writeFile(file);
        System.out.println(line + "    Nice! I've marked this task as done:\n    "
                + taskList.get(taskIndex).getStatusIcon() + taskList.get(taskIndex).task );
    }

    public static void printList() {
        System.out.print(line);
        System.out.println(spaces + "Here are the tasks in your list:");
        for(int i = 0; i< taskList.size(); i++){
            System.out.print("    " + (i+1) + ".");
            taskList.get(i).printTask();
            System.out.println();
        }
        System.out.println(line);
    }

    public static void writeFile(FileClass file) {
        try {
            FileWriter fw = new FileWriter("tasks.txt");
            fw.write("");
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong" + e.getMessage());
        }
        for (Task task : taskList) {
            file.writeFile(task);
        }
    }
}
