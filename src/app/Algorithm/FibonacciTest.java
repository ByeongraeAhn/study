package app.Algorithm;

public class FibonacciTest {

	public static void main(String[] args) {
		
		//this Recursion Fibonacci Call
		int input = 8; // index 8
		System.out.println("Recursion Fibonacci");
		for(int i=0; i <= 8; i++ ) {
			System.out.print(getFiboRecursion(i) + " ");
		}
		
		System.out.println();
		
		//this Non Recursion Fibonacci Call
		System.out.println("Non Recursion Fibonacci");
		for(int i=0; i <= 8; i++ ) {
			System.out.print(getFiboNonRecursion(i) + " ");
		}
		
	}

	public static int getFiboRecursion(int n) {
		if (n <= 1) {
			return n;
		} else {
			return getFiboRecursion(n-2) + getFiboRecursion(n-1);
		}
	}

	public static int getFiboNonRecursion(int n) {
		
		int fisrt = 0;
		int second = 1;
		int nth = 0;
		
		if (n <= 1) {
			return  n;
		} else {
			for (int i = 2; i <= n; i++) {
				nth = fisrt + second;
				fisrt = second;
				second = nth;
			}
		}
		return nth;
	}
	
}
