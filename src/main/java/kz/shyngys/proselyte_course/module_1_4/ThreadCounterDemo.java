package kz.shyngys.proselyte_course.module_1_4;

public class ThreadCounterDemo {
    public static void main(String[] args) {
        ThreadCounterWorker tcw1 = new ThreadCounterWorker("A", 1500);
        ThreadCounterWorker tcw2 = new ThreadCounterWorker("B", 1500);

        tcw1.start();
        tcw2.start();
    }
}
