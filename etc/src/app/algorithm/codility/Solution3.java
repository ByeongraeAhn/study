package app.algorithm.codility;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Solution3 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3})); //1000010001
        
    }

    public static int solution(int[] A) {

        int dominator = A.length / 2;

        Map<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        List<Entry<Integer, Integer>> entries =  map.entrySet()
                                                    .stream()
                                                    .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                                                    .collect(Collectors.toList());

        for (Entry<Integer, Integer> entry : entries) {
            System.out.println("Key: " + entry.getKey() + ", "
                    + "Value: " + entry.getValue());
        }

        for (Entry<Integer,Integer> entry : entries) {
            if(entry.getValue() >= dominator) return entry.getKey();
        }

        return -1;
    }
}
