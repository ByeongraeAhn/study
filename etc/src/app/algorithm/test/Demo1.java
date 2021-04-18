import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo1 {
    
    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(solution(new int[]{3, 2, 1}));
        System.out.println(solution(new int[]{-1 , -3}));
        System.out.println(solution(new int[]{-1 , -3, 2}));
        System.out.println(solution(new int[]{-1 , -3, 1}));
        System.out.println(solution(new int[]{10000}));
    }

    public static int solution(int[] A) {
        A = Arrays.stream(A)
                .filter(i -> i > 0)
                .sorted()
                .toArray();

        if (A.length == 0 || A[0] > 1) {
            return 1;
        }

        for (int i = 0; i < A.length-1; i++) {
            if(A[i + 1] - A[i] > 1) return A[i] + 1;
        }

        return A[A.length-1] + 1;
    }
}
