package kz.shyngys.proselyte_course.module_1_4.threads;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int curPhase;

        System.out.println("Запуск потоков");

        new MyThread3(phaser, "A");
        new MyThread3(phaser, "B");
        new MyThread3(phaser, "C");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");

        phaser.arriveAndDeregister();

        if (phaser.isTerminated()) {
            System.out.println("Синхронизатор завершен");
        }
    }
}

class MyThread3 implements Runnable {
    Phaser phsr;
    String name;

    public MyThread3(Phaser phsr, String name) {
        this.phsr = phsr;
        this.name = name;
        phsr.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Поток " + name + " начинает первую фазу");
        phsr.arriveAndAwaitAdvance();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Поток " + name + " начинает вторую фазу");
        phsr.arriveAndAwaitAdvance();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Поток " + name + " начинает третью фазу");
        phsr.arriveAndDeregister();
    }
}
