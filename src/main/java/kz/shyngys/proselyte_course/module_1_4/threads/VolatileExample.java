package kz.shyngys.proselyte_course.module_1_4.threads;

public class VolatileExample {
    private volatile int counter = 0;

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                example.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                example.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter value: " + example.getCounter());
    }
}
