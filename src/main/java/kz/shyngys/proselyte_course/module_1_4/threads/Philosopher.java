package kz.shyngys.proselyte_course.module_1_4.threads;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    private Semaphore semaphore;

    private boolean isFull = false;

    private String name;

    public Philosopher(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            if (!isFull) {
                semaphore.acquire();

                sleep(3000);
                isFull = true;

                System.out.println(name + " поел! Он выходит из-за стола");
                semaphore.release();

                sleep(3000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        new Philosopher(semaphore, "1").start();
        new Philosopher(semaphore, "2").start();
        new Philosopher(semaphore, "3").start();
        new Philosopher(semaphore, "4").start();
        new Philosopher(semaphore, "5").start();
    }
}
