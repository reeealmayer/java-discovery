package kz.shyngys.proselyte_course.module_1_4.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeThreadsWithConditionsExample {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition1 = lock.newCondition();
    private static final Condition condition2 = lock.newCondition();

    private static boolean isFirst = false;
    private static boolean isSecond = false;

    public static void first() {
        lock.lock();
        System.out.println("first");
        isFirst = true;
        condition1.signal();
        lock.unlock();
    }

    public static void second() {
        lock.lock();
        try {
            while(!isFirst) {
                condition1.await();
            }
            System.out.println("second");
            isSecond = true;
            condition2.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        lock.unlock();
    }

    public static void third() {
        lock.lock();
        try {
            while(!isSecond) {
                condition2.await();
            }
            System.out.println("third");
            condition2.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock.unlock();
    }
}
