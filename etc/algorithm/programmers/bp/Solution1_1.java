package algorithm.programmers.bp;

import java.util.*;


class Solution1_1 {

    public static void main(String[] args) {
        //int[] answers = {1,2,3,4,5};
        int[] answers = {1,3,2,4,2};
        //int[] answers = new int[20];
        solution(answers);
    }


    public static int[] solution(int[] answers) {

        //1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
        //2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
        //3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
        
        
        List<Integer> answerArray = new ArrayList<Integer>();
        for (Integer integer : answers) {
            answerArray.add(integer);
        }

        int size = answerArray.size();

        List<Integer> answersUser1 = new ArrayList<Integer>();
        List<Integer> answersUser2 = new ArrayList<Integer>();
        List<Integer> answersUser3 = new ArrayList<Integer>();
        
        for (int i = 0; i < size; i++) {
            if (i%5 == 0) {
                answersUser1.add(1);
            } else if(i%5 == 1) {
                answersUser1.add(2);
            } else if(i%5 == 2) {
                answersUser1.add(3);
            } else if(i%5 == 3) {
                answersUser1.add(4);
            } else if(i%5 == 4) {
                answersUser1.add(5);
            } 
        }

        for (int i = 0; i < size; i++) {
            if (i%2 == 0) {
                answersUser2.add(2);
            } else if(i%8 == 1) {
                answersUser2.add(1);
            } else if(i%8 == 3) {
                answersUser2.add(3);
            } else if(i%8 == 5) {
                answersUser2.add(4);
            } else if(i%8 == 7) {
                answersUser2.add(5);
            } 
        }

        for (int i = 0; i < size; i++) {
            if (i%10 == 0 || i%10 == 1) {
                answersUser3.add(3);
            } else if(i%10 == 2 || i%10 == 3) {
                answersUser3.add(1);
            } else if(i%10 == 4 || i%10 == 5) {
                answersUser3.add(2);
            } else if(i%10 == 6 || i%10 == 7) {
                answersUser3.add(4);
            } else if(i%10 == 8 || i%10 == 9) {
                answersUser3.add(5);
            } 
        }

        int answerUser1Cnt = 0;
        int answerUser2Cnt = 0;
        int answerUser3Cnt = 0;
        

        for (int i = 0; i < size; i++) {
            int answer = answerArray.get(i);
            if(answersUser1.get(i) == answer) answerUser1Cnt++;
            if(answersUser2.get(i) == answer) answerUser2Cnt++;
            if(answersUser3.get(i) == answer) answerUser3Cnt++;
        }

        Map<Integer,Integer> answerMap = new HashMap<Integer,Integer>();
        answerMap.put(1, answerUser1Cnt);
        answerMap.put(2, answerUser2Cnt);
        answerMap.put(3, answerUser3Cnt);
        System.out.println(answerMap);

        List<Integer> keySetList = new ArrayList<>(answerMap.keySet());
        Collections.sort(keySetList, (value1, value2) -> (answerMap.get(value2).compareTo(answerMap.get(value1))));
        //keySetList.forEach(System.out::println);

        List<Integer> answerList = new ArrayList<Integer>();

        int max = answerMap.get(keySetList.get(0));
        for (int i = 1; i < 4; i++) {
            if(answerMap.get(i)==max) answerList.add(i);
        }

        Collections.sort(answerList);
        
        System.out.println(answerList);

        int[] answer = answerList.stream().mapToInt(i->i).toArray();

        return answer;
    }

}
