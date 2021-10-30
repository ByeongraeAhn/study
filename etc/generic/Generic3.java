package generic;

//제네릭을 사용하여 코드 중복을 없앰
public class Generic3 {
	public static void main(String[] args) {
		StudentInfo2 si = new StudentInfo2(2);
		Person2<StudentInfo2> sp = new Person2(si);
		System.out.println(sp.info.grade); // 2
		EmployeeInfo2 ei = new EmployeeInfo2(1);
		Person2<EmployeeInfo2> ep = new Person2(ei);
		System.out.println(ep.info.rank); // 1

		Person2<String> st = new Person2("test");
//		System.out.println(st.info.grade); // 컴파일 에러

	}
}

class StudentInfo2{
	public int grade;
	StudentInfo2(int grade){ this.grade = grade; }
}

class EmployeeInfo2{
	public int rank;
	EmployeeInfo2(int rank){ this.rank = rank; }
}

class Person2<T>{
	public T info;
	Person2(T info){ this.info = info; }
}