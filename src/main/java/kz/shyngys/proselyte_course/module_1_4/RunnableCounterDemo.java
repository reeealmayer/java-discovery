package kz.shyngys.proselyte_course.module_1_4;

public class RunnableCounterDemo {
    public static void main(String[] args) {
        RunnableCounterWorker scw1 = new RunnableCounterWorker("A", 15);
        RunnableCounterWorker scw2 = new RunnableCounterWorker("B", 15);

        Thread t1 = new Thread(scw1);
        t1.start();
        Thread t2 = new Thread(scw2);
        t2.start();
    }
}
