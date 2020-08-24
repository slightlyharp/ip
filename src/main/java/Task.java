public class Task {
    public String task;
    private boolean isDone;

    public Task(String task){
        this.task = task;
        this.isDone = false;
    }

    public String getStatusIcon(){
        return (isDone? "[\u2713] " : "[\u2718] ");
    }

    public void taskDone(){
        isDone = true;
    }

}
