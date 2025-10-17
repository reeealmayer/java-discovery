package kz.shyngys.proselyte_course.module_1_4.threads;

public class ExtendedThread {
    public static void main(String[] args) {
        new NewThread2().start();

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Главный поток: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }
}
