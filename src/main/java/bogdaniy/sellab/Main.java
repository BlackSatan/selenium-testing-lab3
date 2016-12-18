package bogdaniy.sellab;

import bogdaniy.sellab.tasks.FirstTask;
import bogdaniy.sellab.tasks.SecondTask;
import bogdaniy.sellab.tasks.TaskManager;

public class Main {

        public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addTask(new FirstTask(5, "Ковальчук-Химюк Людмила Олександрівна"));
        manager.addTask(new SecondTask(5, "Борисов Олексій Вікторович"));
        manager.runAll();
    }
}
