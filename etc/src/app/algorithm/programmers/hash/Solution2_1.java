package app.algorithm.programmers.hash;

import java.util.*;

public class Solution2_1 {
    public static void main(String[] args) {

        //String[] participant = {"leo", "kiki", "eden"};
        //String[] completion = {"eden", "kiki"};

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
        
    }

    public static String solution(String[] participant, String[] completion) {

        //Set<String> wordsSet = new HashSet<>(Arrays.asList(participant));

        
        String answer = "";
        String duplicationName ="";

        Set<String> participantSet = new HashSet<>();
        for (String participatetOne : participant) {
            if(participantSet.contains(participatetOne)) {
                duplicationName = participatetOne; continue;
            }
            participantSet.add(participatetOne);
        }

        for (String completeOne : completion) {
            participantSet.remove(completeOne);
        }

        for (String participatetOne : participantSet) {
            answer = participatetOne;
        }

        if(answer.isBlank()) return duplicationName;
        return answer;
    }
}
