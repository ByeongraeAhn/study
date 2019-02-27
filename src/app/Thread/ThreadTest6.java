package app.Thread;

import java.awt.Robot;

public class ThreadTest6 {

    public static void main(String args[]) {

        Thread thread1 = new ThreadEx_1();
        Thread thread2 = new ThreadEx_2();
        Thread thread3 = new ThreadEx_3();
        thread1.start();
        thread2.start();
        thread3.start();
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
    @Override
    public void run() {
        for (int i = 1000; i < 1700; i++) {
            robot.delay(1);
            robot.mouseMove(i, 500);
        }
    }
}
class ThreadEx_2 extends Thread {

    private static Robot robot;
    static {
        try {
            robot = new Robot();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void run() {
        for (int i = 1000; i < 1700; i++) {
            robot.delay(1);
            robot.mouseMove(i, 510);
        }
    }
}
class ThreadEx_3 extends Thread {

    private static Robot robot;
    static {
        try {
            robot = new Robot();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void run() {
        for (int i = 1000; i < 1700; i++) {
            robot.delay(1);
            robot.mouseMove(i, 520);
        }
    }
}