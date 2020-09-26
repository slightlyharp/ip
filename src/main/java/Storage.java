import Duke.task.TaskType;
import Duke.task.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represent the file the that the data going to saved to
 * contain methods to edit the file
 */
public class Storage {

    private static File taskFile;
    private final String filePath;

    public Storage(String filePath){
        this.filePath = filePath;
        taskFile = new File(filePath);
        checkFile();
    }

    /**
     * check if the file already exist if it exist load the file content into the task list
     * if the file do not exist create a new file under the filepath
     */
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

    private void loadFile(){
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

    /**
     * write the newly added task to the file
     * @param task new tasks need to be written to the file
     */
    public void writeFile(Task task){
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

    /**
     * clear all the content in the file and rewrite the the list to the file
     */
    public void rewriteFile() {
        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write("");
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong" + e.getMessage());
        }
        for (Task task : Duke.tasks.taskList) {
            writeFile(task);
        }
    }
}
