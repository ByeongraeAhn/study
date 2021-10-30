package algorithm.programmers.hash;

import java.util.*;

public class Solution2_2 {
    public static void main(String[] args) {

        //String[] participant = {"leo", "kiki", "eden"};
        //String[] completion = {"eden", "kiki"};

        //String[] participant = {"mislav", "stanko", "mislav", "ana"};
        //String[] completion = {"stanko", "ana", "mislav"};

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"mislav", "stanko", "mislav"};
        System.out.println(solution(participant, completion));
        
    }

    public static String solution(String[] participant, String[] completion) {

        String answer = "";

        Map<String, Integer> resultMap = new HashMap<>();

        for (String participantOne : participant) {
            resultMap.put(participantOne, resultMap.getOrDefault(participantOne, 0) + 1);
        }

        for (String completionOne : completion) {
            resultMap.put(completionOne, resultMap.get(completionOne) - 1);
        }

        for (Map.Entry<String, Integer> element : resultMap.entrySet()) {
            if(element.getValue()!=0) answer = element.getKey(); 
        }
        
        return answer;
    }
}
