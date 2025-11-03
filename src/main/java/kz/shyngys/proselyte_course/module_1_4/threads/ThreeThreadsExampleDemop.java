package kz.shyngys.proselyte_course.module_1_4.threads;

public class ThreeThreadsExampleDemop {
    public static void main(String[] args) {
        new Thread(ThreeThreadsExample::second).start();
        new Thread(ThreeThreadsExample::first).start();
        new Thread(ThreeThreadsExample::third).start();
    }
}
