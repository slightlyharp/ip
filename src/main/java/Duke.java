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
        String commandList[] = new String[100];
        int num = 0;

        System.out.println(greeting);
        while (!command.equals("bye")) {
            Scanner in = new Scanner(System.in);
            command = in.nextLine();
            if (command.equals("bye")) {
                System.out.println(line + bye);
            }
            else if(command.equals("list")){
                System.out.print(line);
                for(int i=0; i<num; i++){
                    System.out.println("    " + (i+1) + ". " + commandList[i] );
                }
                System.out.println(line);

            }
            else {
                commandList[num] = command;
                System.out.println(line + "    " + "added: " + command + "\n" + line);
                num ++;
            }
        }
    }
}
