package generic;

// Topic : 복수의 제네릭
public class Generic4 {
	public static void main(String[] args) {
		EmployeeInfo4 ei = new EmployeeInfo4(1);
		Integer i = Integer.valueOf(5);
		Person4<EmployeeInfo5, Integer> p = new Person4(ei, i);
		System.out.println(p.id.intValue()); // 5

	}
}

class EmployeeInfo4{
	public int rank;
	EmployeeInfo4(int rank){ this.rank = rank; }
}

// 제네릭으로는 참조형만 올수 있다.(primitive 타입은 못씀. wrapper클래스 사용)
class Person4<T, S>{
	public T info;
	public S id;
	Person4(T info, S id){
		this.info = info;
		this.id = id;
	}
}