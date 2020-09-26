package Duke.task;

/**
 * represent a task add by user
 */
public abstract class Task {

    public String task;
    public boolean isDone;
    public TaskType taskType;

    public Task(String task, TaskType taskType){
            this.task = task;
            this.isDone = false;
            this.taskType = taskType;
    }

    public Task(String task, TaskType taskType, boolean isDone){
        this.task = task;
        this.isDone = isDone;
        this.taskType = taskType;
    }

    public String getStatusIcon(){
        return (isDone? "[✓] " : "[✘] ");
    }

    public void markDone(){
        isDone = true;
    }

    public void printTask(){
        System.out.print("[" + taskType + "]" + getStatusIcon() + task );
    }

    public abstract String getTime();

}

