public class Task {
    public String task;
    private boolean isDone;
    private TaskType taskType;

    public Task(String task, TaskType taskType){
        this.task = task;
        this.isDone = false;
        this.taskType = taskType;
    }

    public String getStatusIcon(){
        return (isDone? "[\u2713] " : "[\u2718] ");
    }

    public void markDone(){
        isDone = true;
    }

    public void printTask(){
        System.out.print("[" + taskType + "]" + getStatusIcon() + task );
    }

}

