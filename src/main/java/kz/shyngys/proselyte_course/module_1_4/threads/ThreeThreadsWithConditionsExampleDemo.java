package kz.shyngys.proselyte_course.module_1_4.threads;

public class ThreeThreadsWithConditionsExampleDemo {
    public static void main(String[] args) {
        new Thread(ThreeThreadsWithConditionsExample::third).start();
        new Thread(ThreeThreadsWithConditionsExample::second).start();
        new Thread(ThreeThreadsWithConditionsExample::first).start();
    }
}
