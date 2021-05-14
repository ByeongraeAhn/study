package app.algorithm.test;

import java.util.*;

public class Test1_1 {
    
    public static void main(String[] args) {

        System.out.println(solution(new int[]{3, 4, 3, 0, 2, 2, 3, 0, 0})); //5
        System.out.println(solution(new int[]{4, 2, 0})); //0
        System.out.println(solution(new int[]{4, 4, 3, 3, 1, 0})); //3

    }

    public static int solution(int[] A) {

        NavigableMap<Integer, Integer> rankCount = new TreeMap<>();

        

        // init map
        for (int soldier : A) {
            Integer count = rankCount.getOrDefault(soldier, 0);
            rankCount.put(soldier, count + 1);
        }

        int result = 0;
        int general = rankCount.lastKey();
        int prevRank = general;

        for (Integer rank : rankCount.descendingKeySet()) {
            if (rank.equals(general)) {
                continue;
            }

            if (prevRank - rank == 1) {
                result += rankCount.get(rank);
            }
            prevRank = rank;
        }

        return result;
    }
}
