package kz.shyngys.proselyte_course.module_1_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo2 {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        for (int j = 0; j < 100; j++) {
            executorService.execute(new CpuIntensiveTask());
        }
    }

    static class CpuIntensiveTask implements Runnable {

        @Override
        public void run() {

        }
    }
}
