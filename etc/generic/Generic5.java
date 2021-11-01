package generic;

// Topic1 : 제네릭의 생략
// Topic2 : 메서드에서 제네릭 사용
public class Generic5 {
	public static void main(String[] args) {
		EmployeeInfo5 ei = new EmployeeInfo5(1);
		Integer i = Integer.valueOf(5);
//		Person5<EmployeeInfo5, Integer> p = new Person5(ei, i);
		Person5 p = new Person5(ei, i); // 제네릭 생략 가능

		//메서드 제네릭 사용
//		p.<EmployeeInfo5>printInfo(ei);
		p.printInfo(ei); // 메서드 제네릭도 생략이 가능하다.

	}
}

class EmployeeInfo5{
	public int rank;
	EmployeeInfo5(int rank){ this.rank = rank; }
}

class Person5<T, S>{
	public T info;
	public S id;
	Person5(T info, S id){
		this.info = info;
		this.id = id;
	}

	//클래스 뿐만 아니라 메서드에서도 사용할 수 있다.
	//접근제어자와 리턴값 사이에 제네릭을 꺽쇠로 명시한다.
	public <U> void printInfo (U info) {
		System.out.println(info);
	}
}