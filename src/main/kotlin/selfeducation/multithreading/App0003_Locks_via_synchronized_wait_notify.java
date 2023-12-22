package selfeducation.multithreading;

class App0003_Locks_via_synchronized_wait_notify {
    public static void main(String[] args) {
        final Account account = new Account();

        class MyDepositThread extends Thread {
            @Override
            public void run() {
                try {
                    account.deposit(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        class MyWithdrawThread extends Thread {
            @Override
            public void run() {
                try {
                    account.withdraw(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        MyDepositThread myDepoThread = new MyDepositThread();
        MyWithdrawThread myWithdrawThread = new MyWithdrawThread();

        for (int i = 0; i < 10; i++) {
            new Thread(myWithdrawThread, "myWithdrawThread-$i").start();
            new Thread(myDepoThread, "myDepositThread-$i").start();
        }
    }

    static class Account {
        int balance = 0;

        public synchronized void deposit(int amount) throws InterruptedException {
            System.out.println(Thread.currentThread() + "  Deposit " + amount + "$");
            balance += amount;
            Thread.sleep(10); //чтобы withdraw-поток наверняка уже ждал notifyAll();
            notifyAll();
            System.out.println(Thread.currentThread() + "  Balance became " + balance + "$");
        }

        public synchronized void withdraw(int amount) throws InterruptedException {
            System.out.println(Thread.currentThread() + "  Attempt to withdraw " + amount + "$ from balance " + balance + "$");
            while (amount > balance) {
                System.out.println(Thread.currentThread() + "  going to sleep by await()");
                wait();
                System.out.println(Thread.currentThread() + "  waken up by signalAll()");
            }
            balance -= amount;
            System.out.println(Thread.currentThread() + "  Withdrawen " + amount + "$ balance became " + balance + "$");
        }
    }
}

