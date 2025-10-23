package kz.shyngys.proselyte_course.module_1_4;

public class VolitileExample {
    private static volatile int a = 0;

    public static void incrementA() {
        a++;
    }

    public static void decrementA() {
        a--;
    }

    public static void main(String[] args) throws InterruptedException {
        TestTread t1 = new TestTread();
        t1.start();
        TestTread2 t2 = new TestTread2();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(a);
    }

    private static class TestTread extends Thread {

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 10; i++) {
                incrementA();
            }
        }
    }

    private static class TestTread2 extends Thread {

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 10; i++) {
                decrementA();
            }
        }
    }
}
