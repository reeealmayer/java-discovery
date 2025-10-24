package kz.shyngys.proselyte_course.module_1_4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo4 {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        service.schedule(new Task(), 4, TimeUnit.SECONDS);

        service.scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS);

        service.scheduleWithFixedDelay(new Task(), 15, 10, TimeUnit.SECONDS);

        service.shutdown();
    }

    static class Task implements Runnable {

        @Override
        public void run() {

        }
    }
}
