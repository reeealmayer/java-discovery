package kz.shyngys.proselyte_course.module_1_4.threads;

public class Program {
    public static void main(String[] args) {
        Thread myThready = new Thread(() -> System.out.println("Привет из побочного потока"));
        myThready.start();
        System.out.println("Привет из главного потока");
    }
}
