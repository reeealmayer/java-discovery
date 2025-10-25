package kz.shyngys.proselyte_course.module_1_4.foo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooWithConditions {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition firstMethodCondition = lock.newCondition();
    private final Condition secondMethodCondition = lock.newCondition();

    private boolean isFirstDone = false;
    private boolean isSecondDone = false;

    public void first() {
        lock.lock();
        try {
            System.out.println("first");
            isFirstDone = true;
            firstMethodCondition.signal();
        } finally {
            lock.unlock();
        }

    }

    public void second() {
        lock.lock();
        try {
            while (!isFirstDone) {
                firstMethodCondition.await();
            }
            System.out.println("second");
            isSecondDone = true;
            secondMethodCondition.signal();
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
    }

    public void third() {
        lock.lock();
        try {
            while (!isSecondDone) {
                secondMethodCondition.await();
            }
            System.out.println("third");
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
    }
}
