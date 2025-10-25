package kz.shyngys.proselyte_course.module_1_4.foo;

import java.util.concurrent.Semaphore;

public class FooWithSemaphores {
    private final Semaphore betweenFirstAndSecond = new Semaphore(0);
    private final Semaphore betweenSecondAndThird = new Semaphore(0);


    public void first() {
        System.out.println("first");
        betweenFirstAndSecond.release();
    }

    public void second() {
        try {
            betweenFirstAndSecond.acquire();
            System.out.println("second");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            betweenSecondAndThird.release();
        }

    }

    public void third() {
        try {
            betweenSecondAndThird.acquire();
            System.out.println("third");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            betweenSecondAndThird.release();
        }
    }
}
