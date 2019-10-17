package adapter;

//연관성 없는 두 객체를 묶어서 사용한다.
//AdapterImpl 클래스를 통해서 Math 라이브러리에 접근한다.
//AdapterImpl를 통해서 Math 라이브러리에 사용하기 적합한 형태로 변환한다.
public class Application {

	
	public static void main(String[] args) {

		//요구사항을 수행하는 인스턴스
		Adapter target = new AdapterImpl();
		
		System.out.println(target.twiceOf(100.0f));
		System.out.println(target.halfOf(100.3f));
		
	}
	
	
}
