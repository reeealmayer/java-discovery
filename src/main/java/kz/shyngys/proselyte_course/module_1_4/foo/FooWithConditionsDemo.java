package kz.shyngys.proselyte_course.module_1_4.foo;

public class FooWithConditionsDemo {
    public static void main(String[] args) {
        FooWithConditions fooWithConditions = new FooWithConditions();
        Thread t1 = new Thread(fooWithConditions::first);
        Thread t2 = new Thread(fooWithConditions::second);
        Thread t3 = new Thread(fooWithConditions::third);

        t1.start();
        t2.start();
        t3.start();
    }
}
