package app.Rambda;

//두개의 수중 큰수 찾기
public class RambdaTest3 {
    // @FunctionalInterface//함수형 인터페이스 체크 어노테이션
    public interface MyNumber{
	  int getMax(int num1, int num2);
    }
    public static void main(String[] args) {
	  MyNumber max = (x,y)->(x>=y)? x:y;
      System.out.println(max.getMax(10, 30));
    }
}