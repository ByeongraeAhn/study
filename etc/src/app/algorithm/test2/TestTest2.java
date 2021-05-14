package app.algorithm.test2;

import java.util.ArrayList;
import java.util.List;

public class TestTest2 {
    
    public static void main(String[] args) {

        System.out.println(solution(new int[]{-3, -14, -5, 7, 8, 42, 8, 3})); //차이 34, SUMMER
        //System.out.println(solution(new int[]{2, -3, 3, 1, 10, 8, 2, 5, 13, -5, 3, -18})); //차이 21, AUTUMN
    }

    public static String solution(int[] T) {


        int seasonInterval = T.length / 4; //2

        List<Month> monthList = new ArrayList<>();

        String[] seasonArray = {"WINTER", "SPRING", "SUMMER", "AUTHUM"};


        // 0 1 / 2 3 / 4 5 / 6 7
        for (int i = 0; i < T.length; i++) {
            int monthCount = 0;
            int seasonIndex = 0;
            if(monthCount < seasonInterval) {
                monthList.add(new Month(seasonArray[seasonIndex], T[i]));
                monthCount++;
            }

            if(monthCount == seasonInterval) {
                monthCount++;
                seasonIndex++;
            }
        }

        
        return null;
    }

    static class Month {
        private String season;
        private int temperature;

        public Month(String season, int temperature) {

        }

    }
}
