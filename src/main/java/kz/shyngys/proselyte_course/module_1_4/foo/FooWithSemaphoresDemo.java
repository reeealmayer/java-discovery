package kz.shyngys.proselyte_course.module_1_4.foo;

public class FooWithSemaphoresDemo {
    public static void main(String[] args) {
        FooWithSemaphores fooWithConditions = new FooWithSemaphores();
        Thread t1 = new Thread(fooWithConditions::first);
        Thread t2 = new Thread(fooWithConditions::second);
        Thread t3 = new Thread(fooWithConditions::third);

        t1.start();
        t2.start();
        t3.start();
    }
}
