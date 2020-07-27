package app.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;


// https://futurecreator.github.io/2018/08/26/java-8-streams/
public class StreamTest1 {

    public static void main(String[] args) {

        //////////////////////////////////// [생성 관련]

        // 배열 스트림
        String[] arr = new String[] { "a", "b", "c" };
        Stream<String> stream = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3); // [b, c]

        // 컬렉션 스트림
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream2 = list.stream();
        Stream<String> parallelStream = list.parallelStream(); // 병렬 처리 스트림

        //빈 스트림
        Stream<String> emptyStream = Stream.empty();

        // 스트림 빌더
        Stream<String> builderStream = Stream.<String>builder()
        .add("Eric")
        .add("Elena")
        .add("Java")
        .build(); // [Eric, Elena, Java]

        //제네레이트
        //Supplier<T> 에 해당하는 람다로 값을 넣을 수 있다.(인자없고 리턴만 있다.)
        //이 때 생성되는 스트림은 크기가 정해져있지 않고 무한(infinite)하기 때문에 특정 사이즈로 최대 크기를 제한해야 한다.
        Stream<String> generatedStream = Stream.generate(() -> "gen").limit(5); // [gen, gen, gen, gen, gen]


        //Stream.iterate()
        Stream<Integer> iteratedStream =  Stream.iterate(30, n -> n + 2).limit(5); //[30, 32, 34, 36, 38]

        //기본 타입형 스트림
        //제네릭을 사용하지 않고 직접적으로 해당 타입의 스트림
        IntStream intStream = IntStream.range(1, 5); // [1, 2, 3, 4]
        IntStream intStreamRange = IntStream.rangeClosed(1, 5); // [1, 2, 3, 4, 5]
        Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed(); //박싱
        DoubleStream doubles = new Random().doubles(3); // 난수 3개 생성

        //병렬 스트림 Parallel Stream
        //스트림 생성 시 사용하는 stream 대신 parallelStream 메소드를 사용해서 병렬 스트림을 쉽게 생성할 수 있다. 
        //내부적으로는 쓰레드를 처리하기 위해 자바 7부터 도입된 Fork/Join framework 를 사용한다.
        List<String> parallelList = Arrays.asList("a", "b", "c");
        Stream<String> parallelStream2 = parallelList.parallelStream(); //병렬 스트림 생성
        boolean isParallel = parallelStream2.isParallel();
        parallelStream2.sequential(); //시퀀셜 스트림으로 변경
        Stream<String> sequentialStream = parallelStream2.sequential();
        boolean isParallel2 = sequentialStream.isParallel();

        //스트림 연결
        Stream<String> streamString1 = Stream.of("Java", "Scala", "Groovy");
        Stream<String> streamString2 = Stream.of("Python", "Go", "Swift");
        Stream<String> concat = Stream.concat(streamString1, streamString2); // [Java, Scala, Groovy, Python, Go, Swift]

        //////////////////////////////////// [가공 관련]


    }

}