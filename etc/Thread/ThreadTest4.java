package thread;


public class ThreadTest4 {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Thread mother = new Thread(atm, "mother");
        Thread son = new Thread(atm, "son");
        mother.start();
        son.start();
    }
}

class ATM implements Runnable {
    private long depositeMoney = 10000;

    public void run() {
        synchronized (this) {

            for (int i = 0; i < 10; i++) {
                notify();
                try {
                    wait();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (getDepositeMoney() <= 0)
                    break;
                withDraw(1000);
            }
        }
    }

    public void withDraw(long howMuch) {
        if (getDepositeMoney() > 0) {
            depositeMoney -= howMuch;
            System.out.print(Thread.currentThread().getName() + " , ");
            System.out.printf("잔액 : %,d 원 %n", getDepositeMoney());
        } else {
            System.out.print(Thread.currentThread().getName() + " , ");
            System.out.println("잔액이 부족합니다.");
        }
    }

    public long getDepositeMoney() {
        return depositeMoney;
    }
}