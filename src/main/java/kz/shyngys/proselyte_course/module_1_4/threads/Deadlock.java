package kz.shyngys.proselyte_course.module_1_4.threads;

class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " зашел в метод foo()");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(name + " пытается вызвать метод b.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("A last");
    }

}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " зашел в метод bar()");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(name + " пытается вызвать a.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("B last");
    }
}

public class Deadlock implements Runnable {
    A a = new A();
    B b = new B();
    Thread t;

    public Deadlock() {
        Thread.currentThread().setName("Главный поток");
        t = new Thread(this, "Побочный поток");
        t.start();
        a.foo(b);
    }

    @Override
    public void run() {
        b.bar(a);
    }

    public static void main(String[] args) {
        new Deadlock();
    }
}