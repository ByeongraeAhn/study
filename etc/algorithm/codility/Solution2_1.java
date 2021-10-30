package algorithm.codility;
import java.util.*;

public class Solution2_1 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{9,3,9,3,9,7,9}));

    }

    public static int solution(int[] A) {

        Map<Integer, Integer> intMap = new HashMap<>();

        for (int i : A) {
            if (intMap.get(i) == null || intMap.get(i) == 0) {
                intMap.put(i, intMap.getOrDefault(i, 0) + 1);
            } else {
                intMap.put(i, intMap.get(i)-1);
            }
        }

        for (int i : intMap.keySet()) {
            if(intMap.get(i) != 0) return i;
        }

     return 0;
    }
}
