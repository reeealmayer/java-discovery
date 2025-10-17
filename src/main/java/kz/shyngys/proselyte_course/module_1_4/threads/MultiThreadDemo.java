package kz.shyngys.proselyte_course.module_1_4.threads;

public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThread3("один");
        new NewThread3("два");
        new NewThread3("три");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }
}
