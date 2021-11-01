package generic;

// Topic : 제네릭의 제한
public class Generic6{
	public static void main(String[] args) {
		Person6<EmployeeInfo6> p1 = new Person6(new EmployeeInfo6(1));
		//Person6<String> p2 = new Person6("부장"); //Stirng은 Info의 자식이 아니므로 컴파일 에러가 발생한다.

	}
}

//추상클래스 뿐만 아니라 인터페이스도 가능하다.
abstract class Info{
	public abstract int getLevel();
}

class EmployeeInfo6 extends Info{
	public int rank;
	EmployeeInfo6(int rank) {
		this.rank = rank;
	}
	@Override
	public int getLevel() {
		return this.rank;
	}
}

class Person6<T extends Info>{ //여기서의 extends는 부모가 누구인지를 의미한다. 때문에 인터페이스더라도 implements로 변경하면 안됨
	public T info;
	Person6(T info){
		this.info = info;
	}
}