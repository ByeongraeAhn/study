package generic;

public class Generic1 {

	public static void main(String[] args) {

		Person<String> p1 = new Person<>();
		Person<StringBuilder> p2 = new Person<>();
	}
}

class Person<T> {
	public T info;
}


