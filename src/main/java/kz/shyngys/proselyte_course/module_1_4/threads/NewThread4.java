package kz.shyngys.proselyte_course.module_1_4.threads;

public class NewThread4 implements Runnable {
    Thread t;
    String name;
    boolean isSuspend;

    public NewThread4(String name) {
        this.name = name;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 15; i++) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);

                synchronized (this) {
                    while (isSuspend) {
                        wait();
                    }
                }

            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(name + " завершен");

    }

    synchronized void mysuspend() {
        isSuspend = true;
    }

    synchronized void myresume() {
        isSuspend = false;
        notify();
    }
}

class SuspendResume {
    public static void main(String[] args) {
        NewThread4 ob1 = new NewThread4("Один");
        NewThread4 ob2 = new NewThread4("Два");

        try {
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Приостановка потока Один");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Возобновление потока Один");
            ob2.mysuspend();
            System.out.println("Приостановка потока Два");
            ob2.myresume();
            System.out.println("Возобновление потока Два");
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }

        try {
            System.out.println("Ожидание завершения потоков.");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }
}
