package app.thread;

public class ThreadTest2 implements Runnable {

    private int[] temp;

    public ThreadTest2() {
        temp = new int[10];

        for (int start = 0; start < temp.length; start++) {
            temp[start] = start;
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int start : temp) {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException ie) {
                ie.printStackTrace();
                // TODO: handle exception
            }

            System.out.println("스레드이름:" + Thread.currentThread().getName());
            System.out.println("temp value :" + start);
        }
    }

    public static void main(String[] args) {

        ThreadTest2 ct = new ThreadTest2();
        Thread t = new Thread(ct, "첫번째");

        t.start();
    }
}