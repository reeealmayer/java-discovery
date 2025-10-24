package kz.shyngys.proselyte_course.module_1_4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo5 {
    public static void main(String[] args) {
        ThreadPoolExecutor service = new ThreadPoolExecutor(10,
                100,
                120,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(300),
                new CustomRejectionHandler());
        for (int i = 0; i < 500; i++) {
            service.execute(new Task());
        }
    }

    private static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(100000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class CustomRejectionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task rejected");
        }
    }
}
