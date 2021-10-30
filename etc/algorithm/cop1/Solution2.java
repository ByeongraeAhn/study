package algorithm.cop1;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {

        System.out.println(solution("acbcbba"));
        System.out.println(solution("abcdefghijklmnopqrstuvwxyz"));

    }

    public static int solution(String S) {

        List<String> stringList = Arrays.asList(S.split(""));

        Map<String, Integer> map = new HashMap<>();

        int cnt = 0;

        for (String string : stringList) {
            if(map.get(string) == null || map.get(string) == 0) {
                map.put(string, map.getOrDefault(string, 0) + 1);
            } else {
                map.put(string, map.get(string) - 1);
            }
        }

        for (String string : map.keySet()) {
            if(map.get(string) != 0) cnt++;
        }

        return cnt;
    }
}
