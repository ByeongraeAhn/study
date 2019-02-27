package app.Thread;

public class ThreadTest3 {
	public static void main(String[] args) {
		ThreadEX threadex = new ThreadEX();
		ThreadEX threadex2 = new ThreadEX();
		Thread thread1 = new Thread(threadex, "A");
		Thread thread2 = new Thread(threadex2, "B");

		thread1.start();
		thread2.start();

		Thread.currentThread().getName();
	}
}

class ThreadEX implements Runnable {

	int TestNum = 0;

	@Override
	public /* synchronized 하나가 끝나야 실행됨 */ void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (Thread.currentThread().getName().equals("A")) {
				System.out.println("=======================");
				TestNum++;
			}
			System.out.println("ThreadName =" + Thread.currentThread().getName() + "TestNum =" + TestNum);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}