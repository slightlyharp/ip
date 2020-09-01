public class Deadlines extends Task{
    private final String deadline;

    public Deadlines(String command) {
        super(getTask(command), TaskType.D);
        this.deadline = getDeadline(command);
    }

    public static String getTask(String command){
        int spaceIndex = command.indexOf(" ");
        int slashIndex = command.indexOf("/");
        return command.substring(spaceIndex, slashIndex-1);
    }

    public static String getDeadline(String command){
        int byIndex = command.indexOf("/by");
        return command.substring(byIndex + 4, command.length());
    }

    @Override
    public void printTask() {
        super.printTask();
        System.out.print(" (by: " + deadline + ")");
    }
}
