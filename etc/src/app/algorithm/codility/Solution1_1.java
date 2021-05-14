package app.algorithm.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class Solution1_1 {
    public static void main(String[] args) {

        System.out.println(solution(529)); //1000010001
        System.out.println(solution(32)); //100000

        
    }

    public static int solution(int N) {

        String binaryString = Integer.toBinaryString(N);

        String[] binaryStringArray = binaryString.split("");

        int[] binaryIntArray = Arrays.stream(binaryStringArray).mapToInt(Integer::parseInt).toArray();

        List<Integer> binaryCntList = new ArrayList<>();

        int binaryCnt = 0;

        for (int i = 1; i < binaryIntArray.length; i++) {
            if(binaryIntArray[i] != 1) {
                binaryCnt++;
            }
            if(binaryIntArray[i] == 1) {
                binaryCntList.add(binaryCnt);
                binaryCnt = 0;
            }
        }

        if(binaryCntList.isEmpty()) return 0;

        binaryCntList.sort((a, b) -> b.compareTo(a));

        return binaryCntList.get(0);
    }
}
