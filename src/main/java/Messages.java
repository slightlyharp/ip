/**
 * contains messages need-ed to be output in different situations
 */
public class Messages {
    public static final String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    public static final String greeting = "    ____________________________________________________________\n" +
            "     Hello! I'm Duke\n" +
            "     What can I do for you?\n" +
            "    ____________________________________________________________\n";
    public static final String bye = "     Bye. Hope to see you again soon!\n" +
            "    ____________________________________________________________";
    public static final String line = "    ____________________________________________________________\n";
    public static final String spaces = "    ";
    public static final String listMessage = line + spaces + "Here are the tasks in your list:";
    public static final String markDoneMessage = line + "    Nice! I've marked this task as done:\n    ";
    public static final String deleteMessage = line + "    Noted. I've removed this task:\n    ";
    public static final String addTaskMessage = line + spaces + "Got it. I've added this task:\n" + spaces + spaces;
    public static final String outOfBoundsExceptionMessage = line + spaces
            + "☹ OOPS!!! The description do not fulfil the specific task requirement.\n" + line;
    public static final String emptyTaskMessage = line + spaces
            + "☹ OOPS!!! The description of a task cannot be empty.\n" + line;
}
