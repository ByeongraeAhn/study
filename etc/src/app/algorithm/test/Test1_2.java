import java.util.*;

public class Test1_2 {
    
    public static void main(String[] args) {

        System.out.println(solution(new int[]{3, 4, 3, 0, 2, 2, 3, 0, 0})); //5
        System.out.println(solution(new int[]{4, 2, 0})); //0
        System.out.println(solution(new int[]{4, 4, 3, 3, 1, 0})); //3

    }

    public static int solution(int[] A) {

        int cnt = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if(A[i] + 1 == A[j]) {
                    cnt++;
                    break;
                }
            }
        }

        return cnt;
    }
}
