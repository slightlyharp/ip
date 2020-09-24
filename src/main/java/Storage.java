import Duke.task.TaskType;
import Duke.task.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {

    private static File taskFile;
    private final String filePath;

    public Storage(String filePath){
        this.filePath = filePath;
        taskFile = new File(filePath);
        checkFile();
    }

    public void checkFile(){
        try{
            if(taskFile.createNewFile()){
                System.out.println("New file created for task list");
            }else {
                loadFile();
            }
        }catch (IOException e){
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void loadFile(){
        try{
            Scanner s = new Scanner(taskFile);
            while (s.hasNext()){
                String command = s.nextLine();
                Parser.fileParser(command);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public static void writeFile(Task task){
        try{
            FileWriter fw = new FileWriter(filePath, true);
            if(task.taskType.equals(TaskType.T)){
                fw.write("T|" + task.isDone + "|" + task.task
                        + System.lineSeparator());
            }else if(task.taskType.equals(TaskType.D)){
                fw.write("D|" + task.isDone + "|" + task.task + "|"
                        + task.getTime()+ System.lineSeparator());
            }else if(task.taskType.equals(TaskType.E)) {
                fw.write("E|" + task.isDone + "|" + task.task + "|"
                        + task.getTime()+ System.lineSeparator());
            }
            fw.close();
        }
        catch (IOException e){
            System.out.println("Something went wrong" + e.getMessage());
        }
    }

    public static void rewriteFile() {
        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write("");
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong" + e.getMessage());
        }
        for (Task task : TaskList.taskList) {
            writeFile(task);
        }
    }
}
