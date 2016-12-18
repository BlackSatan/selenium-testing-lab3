package bogdaniy.sellab.tasks;



import java.util.ArrayList;
import java.util.List;
public class TaskManager {

    protected List<BaseTask> tasks = new ArrayList<>();

    public void addTask(BaseTask t) {
        tasks.add(t);
    }

    public void runSpecific(int number) {
        if(number < tasks.size()) {
            tasks.get(number).execute();
        }
    }

    public void runAll() {
        for (int i = 0; i < tasks.size(); i++) {
            BaseTask task = tasks.get(i);
            System.out.println("Starting " + (i + 1) + " task : " + task.getClass().getName());
            runSpecific(i);
            System.out.println("Ending " + (i + 1) + " task");
        }

    }

}
