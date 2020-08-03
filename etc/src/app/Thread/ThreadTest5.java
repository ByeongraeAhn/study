package app.thread;

public class ThreadTest5 {
    public static void main(String args[]) {

        Runnable runnable = new ThreadEx_5();

        Thread[] thread = make(runnable);

        for (Thread test : thread) {
            test.start();
        }

        System.out.println("end");
    }

    public static Thread[] make(Runnable r) {

        Thread[] thread = new Thread[10];
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new Thread(r);
        }

        return thread;
    }
}

class ThreadEx_5 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}