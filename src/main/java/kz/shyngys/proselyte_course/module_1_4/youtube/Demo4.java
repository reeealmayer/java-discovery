package kz.shyngys.proselyte_course.module_1_4.youtube;

public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();

        new DepositThread(account).start();

        System.out.println("Calling waitAndWithdraw()...");

        account.waitAndWithDraw(50_000_000);

        System.out.println("waitAndWithDraw() finished");
    }

    private static class DepositThread extends Thread {
        private final Account account;

        private DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50_000_000; i++) {
                account.deposit(1);
            }
        }
    }
}
