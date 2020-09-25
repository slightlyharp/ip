package Duke.task;

public class Events extends Task {
    private final String time;

    public Events(String command) throws EmptyTaskException {
        super(getTask(command), TaskType.E);
        time = getTime(command);
    }


    public Events(Boolean isDone, String task, String time){
        super(task, TaskType.E, isDone);
        this.time = time;
    }

    public static String getTask(String command) throws EmptyTaskException{
        if ((( command.replace("event", "")).replace(" ", "")).isEmpty()){
            throw new EmptyTaskException("event");
        }else {
            int spaceIndex = command.indexOf(" ");
            int slashIndex = command.indexOf("/");
            return command.substring(spaceIndex + 1, slashIndex - 1);
        }
    }

    public static String getTime(String command){
        int atIndex = command.indexOf("/at");
        return command.substring(atIndex + 4);
    }

    @Override
    public void printTask() {
        super.printTask();
        System.out.print(" (at: " + time + ")");
    }

    @Override
    public String getTime() {
        return time;
    }

    @Override
    public String saveTime() {
        return null;
    }
}
