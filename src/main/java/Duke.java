import java.util.Scanner;

public class Duke {
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
        String line = "    ____________________________________________________________\n";
        String command = "null";
        String spaces = "    ";
        Task[] commandList = new Task[100];
        int taskCount = 0;
        Scanner in = new Scanner(System.in);

        System.out.println(greeting);
        while (!command.equals("bye")) {
            command = in.nextLine();
            if (command.equals("bye")) {
                System.out.println(line + bye);
            } else if(command.equals("list")){
                System.out.print(line);
                System.out.println(spaces + "Here are the tasks in your list:");
                for(int i=0; i<taskCount; i++){
                    System.out.print("    " + (i+1) + ".");
                    commandList[i].printTask();
                    System.out.println();
                }
                System.out.println(line);
            } else if(command.contains("done")){
                int taskIndex = Integer.parseInt(command.replaceAll("[^0-9]", ""));
                taskIndex--;
                commandList[taskIndex].markDone();
                System.out.println(line + "    Nice! I've marked this task as done:\n    "
                        + commandList[taskIndex].getStatusIcon() + commandList[taskIndex].task );
            } else if(command.contains("todo")||command.contains("deadline")||command.contains("event")){
                try {
                    if (command.contains("todo")) {
                        commandList[taskCount] = new ToDos(command);
                    } else if (command.contains("deadline")) {
                        commandList[taskCount] = new Deadlines(command);
                    } else if (command.contains("event")) {
                        commandList[taskCount] = new Events(command);
                    }
                    System.out.println(line + spaces + "Got it. I've added this task:");
                    System.out.print(spaces + spaces);
                    commandList[taskCount].printTask();
                    System.out.println("\n" + spaces + "Now you have " + (taskCount + 1)
                            + " tasks in the list.\n" + line);
                    taskCount++;
                }
                catch (StringIndexOutOfBoundsException e){
                    System.out.println(line + spaces + "☹ OOPS!!! The description do not fulfil the specific task requirement.\n" + line);
                }
                catch (EmptyTaskException e){
                    System.out.println(line + spaces + "☹ OOPS!!! The description of a " + e.taskType + " cannot be empty.\n" + line);
                }
            }else {
                System.out.println(line + spaces + "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" + line);
            }
        }
    }
}
