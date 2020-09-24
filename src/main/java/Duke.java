import Duke.task.Task;

import java.util.Scanner;

public class Duke {

    private TaskList tasks;
    private Ui ui;
    private Storage file;
    private Parser parser;

    public void main(String[] args) {
        file = new Storage("tasks.txt");
        ui = new Ui(tasks);

        run();
    }

    public static void run(){
        boolean isExit = false;
        while (!isExit){
            isExit = Ui.readCommand();
        }
    }










}
