package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class App0002_Locks_in_java {
    public static void main(String[] args) {
        final Account account = new Account();

        class MyDepositThread extends Thread {
            @Override
            public void run() {
                try {
                    account.deposit(200);
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
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        int balance = 0;

        public void deposit(int amount) throws InterruptedException {
            lock.lock();
            System.out.println(Thread.currentThread() + "  Deposit " + amount + "$");
            balance += amount;
            Thread.sleep(10); //чтобы withdraw-поток наверняка уже ждал condition.signalAll()
            condition.signalAll();
            System.out.println(Thread.currentThread() + "  Balance became " + balance + "$");
            lock.unlock();
        }

        public void withdraw(int amount) throws InterruptedException {
            lock.lock();
            System.out.println(Thread.currentThread() + "  Attempt to withdraw " + amount + "$ from balance " + balance + "$");
            while (amount > balance) {
                System.out.println(Thread.currentThread() + "  going to sleep by await()");
                condition.await(); //если amount > balance то поток идёт  спать и отпускаем Lock
                System.out.println(Thread.currentThread() + "  waken up by signalAll()");
            }
            balance -= amount;
            System.out.println(Thread.currentThread() + "  Withdrawen " + amount + "$ balance became " + balance + "$");
            lock.unlock();
        }
    }
}

