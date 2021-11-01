package generic;

// Topic : 제네릭을 사용하여 코드 중복을 없앰
public class Generic3 {
	public static void main(String[] args) {
		StudentInfo3 si = new StudentInfo3(2);
		Person3<StudentInfo3> sp = new Person3(si);
		System.out.println(sp.info.grade); // 2
		EmployeeInfo3 ei = new EmployeeInfo3(1);
		Person3<EmployeeInfo3> ep = new Person3(ei);
		System.out.println(ep.info.rank); // 1

		Person3<String> st = new Person3("test");
//		System.out.println(st.info.grade); // 컴파일 에러

	}
}

class StudentInfo3{
	public int grade;
	StudentInfo3(int grade){ this.grade = grade; }
}

class EmployeeInfo3{
	public int rank;
	EmployeeInfo3(int rank){ this.rank = rank; }
}

class Person3<T>{
	public T info;
	Person3(T info){ this.info = info; }
}