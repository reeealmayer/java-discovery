package kz.shyngys.proselyte_course.module_1_4.threads;

import java.util.concurrent.Semaphore;

public class SemDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new IncThread(semaphore, "A");
        new DecThread(semaphore, "B");
    }
}

class Shared {
    static int count = 0;
}

class IncThread implements Runnable {
    String name;
    Semaphore semaphore;

    IncThread(Semaphore s, String n) {
        semaphore = s;
        name = n;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Запуска потока " + name);
        try {
            System.out.println("Поток " + name + " ожидает разрешения");
            semaphore.acquire();
            System.out.println("Поток " + name + " получает разрешение");

            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Поток " + name + " освобождает разрешение");
        semaphore.release();
    }
}

class DecThread implements Runnable {
    String name;
    Semaphore semaphore;

    DecThread(Semaphore s, String n) {
        semaphore = s;
        name = n;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Запуска потока " + name);
        try {
            System.out.println("Поток " + name + " ожидает разрешения");
            semaphore.acquire();
            System.out.println("Поток " + name + " получает разрешение");

            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Поток " + name + " освобождает разрешение");
        semaphore.release();
    }
}
