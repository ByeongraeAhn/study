package app.algorithm.test;

public class Test3 {
    
    public static void main(String[] args) {

        System.out.println(solution(new int[]{1,1,2,3,3}, 3)); //true
        System.out.println(solution(new int[]{1,1,3}, 2)); //false
        System.out.println(solution(new int[]{0,1,1,2,3,3}, 3)); //true

        System.out.println(solution(new int[]{1,2,3,4,5}, 4)); //true
        System.out.println(solution(new int[]{1,2,3,4,5}, 7)); //true
    }

    public static boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) { 
            if (A[i] + 1 < A[i + 1])
                return false;
        }
        if (A[0] > 1 || A[n - 1] < K) //첫번째 배열이 1이상이거나 아니거나, 마지막배열이 K가 아닌지 검증
            return false;
        else
            return true;
    }
}
