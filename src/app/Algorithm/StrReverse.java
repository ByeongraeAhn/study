package app.Algorithm;

public class StrReverse {

	public static void main(String[] args) {
		
		String str = "abcd";
		char[] arrayChar = new char[str.length()];
		
		for (int i = 0; i < arrayChar.length; i++) {
			arrayChar[i] = str.charAt(arrayChar.length-i-1);
			System.out.println(arrayChar);
		}
		
		String reverseStr1 = String.valueOf(arrayChar);
		System.out.println(reverseStr1);
		
		String reverseStr2 = new String(arrayChar);
		System.out.println(reverseStr2);
		
	}
}
