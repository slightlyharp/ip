package Duke.task;

/**
 * Represent tasks that need to be done by a specific date and time
 */
public class Deadlines extends Task {
    private final String deadline;

    /**
     *Construct the deadline object from user command
     * @param command User input with deadline key word
     * @throws EmptyTaskException when there is no task name provided
     */
    public Deadlines(String command) throws EmptyTaskException {
        super(getTask(command), TaskType.D);
        this.deadline = getDeadline(command);
    }

    /**
     *Construct deadline object from file
     * @param isDone whether the task is done
     * @param task name of the task
     * @param deadline Date and Time that the task is due
     */
    public Deadlines(boolean isDone, String task, String deadline){
        super(task,TaskType.D, isDone);
        this.deadline = deadline;
    }

    /**
     * get the name of task from user input
     * @param command User input
     * @return the name of the task
     * @throws EmptyTaskException if there is no name of task input
     */
    public static String getTask(String command) throws EmptyTaskException{
        if(((command.replace("deadline", "")).replace(" ", "")).isEmpty()) {
            throw new EmptyTaskException("deadline");
        }else {
            int spaceIndex = command.indexOf(" ");
            int slashIndex = command.indexOf("/");
            return command.substring(spaceIndex + 1, slashIndex - 1);
        }
    }

    /**
     * get the date and time when the task is due
     * @param command user input
     * @return date and time that the task is due
     */
    public static String getDeadline(String command){
        int byIndex = command.indexOf("/by");
        return command.substring(byIndex + 4);
    }

    /**
     * returns the due date and time of this deadline object
     * @return date and time when the task is due
     */
    @Override
    public String getTime() {
        return deadline;
    }

    /**
     * print out the task in the format taskType isDone? taskName(by: time)
     */
    @Override
    public void printTask() {
        super.printTask();
        System.out.print(" (by: " + deadline + ")");
    }
}
