package app.Thread;

import java.awt.Robot;

public class ThreadTest6 {
    //ThreadTest7과 속도비교 테스트

    public static void main(String args[]) {

        Thread[] thread = new Thread[800];

        for (int i = 0; i <800; i++) {
            thread[i] = new ThreadEx_1(i+200);
        }

        for (int i = 0; i <800; i++) {
            thread[i].start();
        }

         
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

    public int x;

    public ThreadEx_1(int index) {
        this.x = index;
    }

    @Override
    public void run() {
        for (int j = 200; j < 1000; j++) {
            robot.mouseMove(x, j);
        }
    }
}
