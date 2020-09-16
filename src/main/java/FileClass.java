import Duke.task.Deadlines;
import Duke.task.Events;
import Duke.task.ToDos;
import Duke.task.TaskType;
import Duke.task.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileClass {

    public static File tasks;

    public FileClass(String filePath){
        tasks = new File(filePath);
        checkFile();
    }

    public void checkFile(){
        try{
            if(tasks.createNewFile()){
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
            Scanner s = new Scanner(tasks);
            while (s.hasNext()){
                String command = s.nextLine();
                String[] words = command.split("\\|",-1);
                switch (words[0]) {
                case "T":
                    Duke.taskList.add(new ToDos(Boolean.parseBoolean(words[1]),
                            words[2]));
                    break;
                case "D":
                    Duke.taskList.add(new Deadlines(Boolean.parseBoolean(words[1]),
                            words[2], words[3]));
                    break;
                case "E":
                    Duke.taskList.add(new Events(Boolean.parseBoolean(words[1]),
                            words[2], words[3]));
                    break;
                default:
                    System.out.println("OOPS something wrong with the data file");
                    break;
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public void writeFile(Task task){
        try{
            FileWriter fw = new FileWriter("data/tasks.txt", true);
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
}
