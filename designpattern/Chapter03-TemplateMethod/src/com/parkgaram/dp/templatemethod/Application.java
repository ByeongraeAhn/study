package com.parkgaram.dp.templatemethod;

public class Application {

	//정의 : 알고리즘의 구조를 메소드에 정의하고 하위클래스에서 알고리즘 구조의 변경없이 알고리즘을 재정의하는 패턴

	//사용처-1 : 구현하려는 알고리즘이 일정한 프로세스가 있다.
	//사용처-2 : 구현하려는 알고리즘이 변경가능성이 있다.

	//단계-1 : 알고리즘을 여러 단계로 나눈다
	//단계-2 : 나눠진 알고리즘의 단계를 메소드로 선언한다.
	//단계-3 : 알고리즘을 수행할 템플릿 메소드를 만든다. 
	//단계-4 : 하위클래스에서 나눠진 메소드들을 구현한다.

	public static void main(String[] args) {
		AbstConnectHelper abstConnectHelper = new ConcreteConnectHelper();
		
		abstConnectHelper.requestConnection("info");
	}

}
