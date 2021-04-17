public class Solution1 {
    
    public static void main(String[] args) {
        System.out.println(solution(78, 195378678));
    }

    public static int solution(int A, int B) {

        String stringA = Integer.toString(A);
        String stringB = Integer.toString(B);


        return stringB.indexOf(stringA);
    }
}
