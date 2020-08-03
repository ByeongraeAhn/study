package app.java8.chap1;

@FunctionalInterface
public interface RunSomthing {

    int doIt(int number);

    //void doAgain(); //에러

    static void printName() {
        System.out.println("홍");
    }

    default void printAge() {
        System.out.println("10");
    }
    
}