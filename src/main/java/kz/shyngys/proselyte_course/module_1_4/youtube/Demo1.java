package kz.shyngys.proselyte_course.module_1_4.youtube;

public class Demo1 {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Hello from " + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
//            new HelloThread().start();
//            new Thread(new HelloRunnable()).start();
            new Thread(runnable).start();
        }
        System.out.println("Hello from " + Thread.currentThread().getName() + " thread");
    }

    private static class HelloThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from " + getName());
        }
    }

    private static class HelloRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }
}
