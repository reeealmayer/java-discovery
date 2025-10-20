package kz.shyngys.proselyte_course.module_1_4.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, () -> System.out.println("Барьер достигнут"));

        System.out.println("Запуск потоков");

        new MyThread2(cb, "a");
        new MyThread2(cb, "b");
        new MyThread2(cb, "c");
        new MyThread2(cb, "as");
        new MyThread2(cb, "aasd");
        new MyThread2(cb, "aasdasd");
        new MyThread2(cb, "aasdasdasdqwee");
    }
}

class MyThread2 implements Runnable {
    CyclicBarrier cbar;
    String name;

    public MyThread2(CyclicBarrier cbar, String name) {
        this.cbar = cbar;
        this.name = name;

        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name);

        try {
            cbar.await();
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

