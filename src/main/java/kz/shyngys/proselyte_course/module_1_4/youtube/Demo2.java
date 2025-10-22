package kz.shyngys.proselyte_course.module_1_4.youtube;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        WorkerThread worker = new WorkerThread();
        worker.setDaemon(true);
        SleeperThread sleeper = new SleeperThread();
        sleeper.setDaemon(true);

        System.out.println("starting threads");
        worker.start();
        sleeper.start();


        Thread.sleep(1000L);

//        System.out.println("Interrupting threads");
//        worker.interrupt();
//        sleeper.interrupt();
//
//        System.out.println("Joining threads");
//        worker.join();
//        sleeper.join();

        System.out.println("All done");
    }

    private static class WorkerThread extends Thread {
        @Override
        public void run() {
            long sum = 0;
            for (int i = 0; i < 1_000_000_000; i++) {
//                System.out.print(i + " ");
                if (i % 100 == 0 && isInterrupted()) {
                    System.out.println("Loop interrupted at i = " + i);
                }
            }
        }
    }

    private static class SleeperThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
        }
    }
}
