package kz.shyngys.proselyte_course.module_1_4.threads;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Текущий поток исполнения " + t);

        t.setName("My Thread");
        System.out.println("После изменения имени " + t);

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                t.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток исполнения прерван");
        }
    }
}
