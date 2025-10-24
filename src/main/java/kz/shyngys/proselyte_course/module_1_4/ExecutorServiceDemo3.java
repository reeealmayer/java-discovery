package kz.shyngys.proselyte_course.module_1_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Task());
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {

        }
    }
}
