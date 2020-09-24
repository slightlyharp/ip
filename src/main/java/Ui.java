import java.util.Scanner;

public class Ui {

    private final Scanner in;

    public Ui(){
        in = new Scanner(System.in);
    }

    public static void printGreeting(){
        System.out.println(Messages.greeting);
    }

    public static void printBye(){

        System.out.println(Messages.bye);
    }

    public boolean readCommand(){
        String command = in.nextLine();
        if(command.equals("bye")){
            return true;
        }else {
            Parser.commandParser(command);
            return false;
        }
    }



}
