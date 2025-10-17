package kz.shyngys.proselyte_course.module_1_4.threads;

class Incremenator extends Thread {

    private volatile boolean mIsIncrement = true;

    public void changeAction() {
        mIsIncrement = !mIsIncrement;
    }

    @Override
    public void run() {
        do {
            if (!Thread.interrupted()) {
                if (mIsIncrement) {
                    Program2.mValue++;
                } else {
                    Program2.mValue--;
                }
                System.out.print(Program2.mValue + " ");
            } else {
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        } while (true);

    }
}

public class Program2 {
    public static int mValue = 0;

    static Incremenator incremenator;

    public static void main(String[] args) {
        incremenator = new Incremenator();
        System.out.print("Значение: ");
        incremenator.start();

        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(i * 2 * 1000);
            } catch (InterruptedException e) {
            }
            incremenator.changeAction();
        }
        incremenator.interrupt();
    }
}
