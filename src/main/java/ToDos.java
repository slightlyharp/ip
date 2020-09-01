public class ToDos extends Task{
    public ToDos(String command) {
        super(getTask(command), TaskType.T);
    }

    public static String getTask(String command){
        int spaceIndex = command.indexOf(" ");
        return command.substring(spaceIndex, command.length());
    }
}
