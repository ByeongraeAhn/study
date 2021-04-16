package app.algorithm.old;

public class Atoi {
	
	public int getStrToInt(String str) {
		
		boolean Sign = true;
		int result = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '-')
				Sign = false;
			else if (ch != '+')
				result = result * 10 + (ch - '0');
		}
		return Sign ? 1 : -1 * result;
	}

	// 아래는 테스트로 출력해 보기 위한 코드
	public static void main(String args[]) {
		Atoi strToInt = new Atoi();
		System.out.println(strToInt.getStrToInt("-1234"));
		
		/*int num = Integer.valueOf("-5678");
		
		int num2 =  Integer.parseInt("9998");
		
		System.out.println(num);
		System.out.println(num2);*/
	}
}