package app.Thread;

public class ThreadTest1 {
    public static void main(String args[]) {
        // Thread 클래스 상속
        ThreadEx1_1 t1 = new ThreadEx1_1();

        // Runnable 구현
        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r); // 생성자 Thread(Runnable target)

        t1.start(); // 쓰레드 실행
        t2.start(); // 쓰레드 실행
    }
}

class ThreadEx1_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName());
        }
    }
}

class ThreadEx1_2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // Thread.currentThread() -> 현재 실행중인 쓰레드 반환
            System.out.println(Thread.currentThread().getName());
        }
    }
}