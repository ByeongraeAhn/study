package app.Lambda;

// 람다 사용, 미사용 비교
public class LambdaTest1 {
    public static void main(String[] args) {

        // 람다식 미사용
        Person person1 = new Person();
        person1.hi(new Say() {
            public int someting(int a, int b) {
                System.out.println("My Name is Coding-Factory");
                System.out.println("Nice to meet you");
                System.out.println("parameter number is " + a + "," + b);
                return a + b;
            }
        });

        // 람다식 사용
        Person person2 = new Person();
        person2.hi((a, b) -> {
            System.out.println("This is Coding-Factory!");
            System.out.println("Tank you Lamda");
            System.out.println("parameter number is " + a + "," + b);
            return a + b;
        });
    }
}

// @FunctionalInterface
interface Say {
    int someting(int a, int b);
}

class Person {
    public void hi(Say line) {
        int number = line.someting(3, 4);
        System.out.println("Number is " + number);
    }
}