package app.Thread;

import java.awt.Robot;

public class ThreadTest7 {
    //ThreadTest6과 속도비교 테스트

    private static Robot robot;
    static {
        try {
            robot = new Robot();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {

        int start = 200;
        int end = 1000;

        for (int i = start; i < end; i++) {
            for (int j = start; j < end; j++) {
                robot.mouseMove(i, j);
            }
        }

    }

}
