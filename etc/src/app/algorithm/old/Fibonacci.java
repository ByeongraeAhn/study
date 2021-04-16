package app.algorithm.old;

public class Fibonacci {

	public static void main(String[] args) {
		
		//this Recursion Fibonacci Call
		int input = 8; // index 8
		System.out.println("Recursion Fibonacci");
		for (int i = 0; i <= input; i++) {
			System.out.print(getFiboRecursion(i) + " ");
		}
		
		System.out.println();
		
		//this Non Recursion Fibonacci Call
		System.out.println("Non Recursion Fibonacci");
		for (int i = 0; i <= input; i++) {
			System.out.print(getFiboNonRecursion(i) + " ");
		}
		
	}

	public static int getFiboRecursion(int n) {
		if (n <= 1)
			return n;
		else
			return getFiboRecursion(n - 2) + getFiboRecursion(n - 1);
	}

	public static int getFiboNonRecursion(int n) {
		if (n <= 1)
			return n;
		int first = 0;
		int second = 1;
		int nth = 1;
		for (int i = 2; i <= n; i++) {
			nth = first + second;
			first = second;
			second = nth;
		}
		return nth;
	}
}
