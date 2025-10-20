package kz.shyngys.proselyte_course.module_1_4.threads;

import java.util.concurrent.Semaphore;

public class ProdCon {
    public static void main(String[] args) {
        Q2 q = new Q2();
        new Consumer2(q);
        new Producer2(q);
    }
}

class Q2 {
    int n;

    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Получено: " + n);
        semProd.release();
    }

    void put(int n) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        this.n = n;
        System.out.println("Отправлено: " + n);
        semCon.release();
    }
}

class Producer2 implements Runnable {
    Q2 q;
    Producer2(Q2 q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            q.put(i);
        }
    }
}

class Consumer2 implements Runnable {
    Q2 q;
    Consumer2(Q2 q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            q.get();
        }
    }
}