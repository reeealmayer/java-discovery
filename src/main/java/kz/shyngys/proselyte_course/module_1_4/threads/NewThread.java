package kz.shyngys.proselyte_course.module_1_4.threads;

public class NewThread implements Runnable {
    Thread t;
    String name;

    public NewThread(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен.");
    }
}

class DemoJoin {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("один");
        NewThread ob2 = new NewThread("два");
        NewThread ob3 = new NewThread("три");

        System.out.println("Поток один запущен: " + ob1.t.isAlive());
        System.out.println("Поток два запущен: " + ob2.t.isAlive());
        System.out.println("Поток три запущен: " + ob3.t.isAlive());

        try {
            System.out.println("Ожидание завершения потоков.");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }

        System.out.println("Поток один запущен:" + ob1.t.isAlive());
        System.out.println("Поток два запущен:" + ob2.t.isAlive());
        System.out.println("Поток три запущен:" + ob3.t.isAlive());

        System.out.println("Главный поток завершен");
    }

}
