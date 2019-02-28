package app.Thread;

import java.awt.Robot;

public class ThreadTest6 {

    public static void main(String args[]) {

        for (int i = 0; i <30; i++) {
            Thread thread = new ThreadEx_1(500+((i+1)*10));
            thread.start();
        }


        // Thread thread = new ThreadEx_1(500);
        // thread.start();
        
        // Thread thread2 = new ThreadEx_1(600);
        // thread2.start();

        // Thread thread3 = new ThreadEx_1(700);
        // thread3.start();


         
        System.out.println("end");
    }

}

class ThreadEx_1 extends Thread {

    private static Robot robot;
    static {
        try {
            robot = new Robot();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int index;

    public ThreadEx_1(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        for (int i = 1000; i < 1700; i++) {
            robot.mouseMove(i, index);
        }
    }
}
