package app.algorithm;

public class Shift {
	public static void main(String[] args) {
		byte a = 10; // 00001010
		byte b = 9; // 00001001
		byte c = 1; // 시프트할 칸수
		System.out.println(a + " & " + b + " = " + (a & b)); // 논리합
		System.out.println(a + " | " + b + " = " + (a | b)); // 논리곱
		System.out.println(a + " ^ " + b + " = " + (a ^ b)); // 배타적 논리합(xor)
		System.out.println("~10 = " + (~a)); // a 의 보수(반전)
		System.out.println(a + " << " + c + " = " + (a << c)); // 왼쪽 1비트 시프트(뒤를 0 으로 채움)
		System.out.println(a + " >> " + c + " = " + (a >> c)); // 오른쪽 1비트 시프트(앞을 밀리기전 첫째자리와 동일한 비트로 채움)
		System.out.println(a + " >>> " + c + " = " + (a >>> c)); // 오른쪽 1비트 논리 시프트(앞을 0 으로 채움)
		System.out.println(-1 * a + " >> " + c + " = " + (-1 * a >> c));
	}
}
