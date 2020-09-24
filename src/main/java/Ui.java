import java.util.Scanner;

public class Ui {

    private static Scanner in;
    public TaskList taskList;

    public Ui(TaskList taskList){
        this.taskList = taskList;
        in = new Scanner(System.in);

    }

    public static void printGreeting(){
        System.out.println(Messages.greeting);
    }

    public static void printBye(){

        System.out.println(Messages.bye);
    }

    public static boolean readCommand(){
        String command = in.nextLine();
        if(command.equals("bye")){
            return true;
        }else {
            Parser.commandParser(command);
            return false;
        }
    }



}
