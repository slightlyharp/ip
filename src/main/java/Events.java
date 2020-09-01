public class Events extends Task{
    private final String time;

    public Events(String command) {
        super(getTask(command), TaskType.E);
        time = getTime(command);
    }

    public static String getTask(String command){
        int spaceIndex = command.indexOf(" ");
        int slashIndex = command.indexOf("/");
        return command.substring(spaceIndex, slashIndex-1);
    }

    public static String getTime(String command){
        int atIndex = command.indexOf("/at");
        return command.substring(atIndex + 4, command.length());
    }

    @Override
    public void printTask() {
        super.printTask();
        System.out.print(" (at: " + time + ")");
    }
}
