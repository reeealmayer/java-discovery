package kz.shyngys.proselyte_course.module_1_4.threads;

public class NewThread2 extends Thread {

//    public NewThread2() {
//        super("Демонстрационный поток");
//        System.out.println("Дочерний поток");
//        start();
//    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Дочерний поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("дочерний поток прерван");
        }
        System.out.println("Дочерний поток завершен");
    }
}
