package bogdaniy.sellab;

import bogdaniy.sellab.tasks.FirstTask;
import bogdaniy.sellab.tasks.SecondTask;
import bogdaniy.sellab.tasks.TaskManager;
import bogdaniy.sellab.tasks.ThirdTask;

public class Main {

        public static void main(String[] args) {
                TaskManager manager = new TaskManager();
                manager.addTask(new FirstTask(5, "Ковальчук-Химюк Людмила Олександрівна"));
                manager.addTask(new SecondTask(5, "Борисов Олексій Вікторович"));
                manager.addTask(new ThirdTask(5, "Презентація проекту Erasmus+ з Університетом Лотарингії",
                        "Срд, 10/02/2016 - 04:57"));
                manager.runAll();
        }
}
