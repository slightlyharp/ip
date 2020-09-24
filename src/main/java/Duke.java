public class Duke {

    public static TaskList tasks;
    public static Storage file;
    private static Ui ui;

    public static void main(String[] args) {
        tasks = new TaskList();
        file = new Storage("tasks.txt");
        ui = new Ui();
        Ui.printGreeting();
        run();
        Ui.printBye();

    }

    public static void run(){
        boolean isExit = false;
        while (!isExit){
            isExit = ui.readCommand();
        }
    }











}
