package Duke.task;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadlines extends Task {
    private final LocalDateTime deadline;

    public Deadlines(String command) throws EmptyTaskException, ArrayIndexOutOfBoundsException {
        super(getTask(command), TaskType.D);
        this.deadline = getDeadline(command);
    }

    public Deadlines(boolean isDone, String task, String deadline){
        super(task,TaskType.D, isDone);
        this.deadline = LocalDateTime.parse(deadline);
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

    public static LocalDateTime getDeadline(String command)throws ArrayIndexOutOfBoundsException{
        String[] dateTime;
        String[] date;
        String time;
        int byIndex = command.indexOf("/by");
        dateTime = command.substring(byIndex + 4).split(" ");
        date = dateTime[0].split("/");
        time = dateTime[1];
        return LocalDateTime.of(Integer.parseInt(date[2]),Integer.parseInt(date[1]), Integer.parseInt(date[0]),
                Integer.parseInt(time.substring(0,2)), Integer.parseInt(time.substring(2,4)));
    }

    @Override
    public String getTime() {
        return deadline.format(DateTimeFormatter.ofPattern("LLL dd yyyy hh:mm a"));
    }

    @Override
    public String saveTime(){
        return deadline.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    @Override
    public void printTask() {
        super.printTask();
        System.out.print(" (by: " + getTime() + ")");
    }
}
