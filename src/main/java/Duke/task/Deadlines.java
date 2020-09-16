package Duke.task;


public class Deadlines extends Task {
    private final String deadline;

    public Deadlines(String command) throws EmptyTaskException {
        super(getTask(command), TaskType.D);
        this.deadline = getDeadline(command);
    }

    public Deadlines(boolean isDone, String task, String deadline){
        super(task,TaskType.D, isDone);
        this.deadline = deadline;
    }

    public static String getTask(String command) throws EmptyTaskException{
        if(((command.replace("deadline", "")).replace(" ", "")).isEmpty()) {
            throw new EmptyTaskException("deadline");
        }else {
            int spaceIndex = command.indexOf(" ");
            int slashIndex = command.indexOf("/");
            return command.substring(spaceIndex + 1, slashIndex - 1);
        }
    }

    public static String getDeadline(String command){
        int byIndex = command.indexOf("/by");
        return command.substring(byIndex + 4);
    }

    @Override
    public String getTime() {
        return deadline;
    }

    @Override
    public void printTask() {
        super.printTask();
        System.out.print(" (by: " + deadline + ")");
    }
}
