package Duke.task;

/**
 * represent an event that will happen at certain time
 */
public class Events extends Task {
    private final String time;

    /**
     *
     *Construct the event object from user command
     * @param command User input with event key word
     * @throws EmptyTaskException when there is no task name provided
     */
    public Events(String command) throws EmptyTaskException {
        super(getTask(command), TaskType.E);
        time = getTime(command);
    }

    /**
     * Construct the event object from file
     * @param isDone whether the task is done
     * @param task name of the task
     * @param time Date and Time that the task is happening
     */
    public Events(Boolean isDone, String task, String time){
        super(task, TaskType.E, isDone);
        this.time = time;
    }

    /**
     * get the name of task from user input
     * @param command User input
     * @return the name of the task
     * @throws EmptyTaskException if there is no name of task input
     */
    public static String getTask(String command) throws EmptyTaskException{
        if ((( command.replace("event", "")).replace(" ", "")).isEmpty()){
            throw new EmptyTaskException("event");
        }else {
            int spaceIndex = command.indexOf(" ");
            int slashIndex = command.indexOf("/");
            return command.substring(spaceIndex + 1, slashIndex - 1);
        }
    }

    /**
     * get the date and time when the task is happening
     * @param command user input
     * @return date and time that the task is happening
     */
    public static String getTime(String command){
        int atIndex = command.indexOf("/at");
        return command.substring(atIndex + 4);
    }

    /**
     * print out the task in the format taskType isDone? taskName(at: time)
     */
    @Override
    public void printTask() {
        super.printTask();
        System.out.print(" (at: " + time + ")");
    }

    /**
     * returns the date and time of this event object
     * @return date and time when the task is happening
     */
    @Override
    public String getTime() {
        return time;
    }
}
