package kz.shyngys.proselyte_course.module_1_4.threads;

import java.util.concurrent.Semaphore;

public class ThreeThreadsExample {
    private static final Semaphore semaphore1 = new Semaphore(0);
    private static final Semaphore semaphore2 = new Semaphore(0);

    public static void first() {
        System.out.println("first");
        semaphore1.release();
    }

    public static void second() {
        try {
            semaphore1.acquire();
            System.out.println("second");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore2.release();
        }
    }

    public static void third() {
        try {
            semaphore2.acquire();
            System.out.println("third");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore2.release();
        }
    }
}
