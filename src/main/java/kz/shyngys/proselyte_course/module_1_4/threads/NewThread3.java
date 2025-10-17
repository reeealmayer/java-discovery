package kz.shyngys.proselyte_course.module_1_4.threads;

public class NewThread3 implements Runnable {
    private String name;
    private Thread t;

    public NewThread3(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("Поток " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен");
    }
}
