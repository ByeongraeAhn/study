package algorithm.programmers.bp;

import java.util.ArrayList;
import java.util.List;

public class Solution2_1 {
    public static void main(String[] args) {

        //solution(24, 24);
        solution(8, 1);
        //solution(10, 2);


    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        List<int[]> yellowXYList = new ArrayList<>();
        //노란 카펫 약수
        for (int j = 1; j <= yellow/j; j++) {
            if(yellow % j == 0) {
                int yellowY = j;
                int yellowX = yellow/j;
                System.out.println("yellowX : " + yellowX + ", yellowY : " + yellowY);
                int[] yellowXYArray = {yellowX, yellowY};
                yellowXYList.add(yellowXYArray);
            }
        }


        //전체 카펫 약수
        int totalXY = brown + yellow;
        System.out.println("총갯수 : " + totalXY);
        for (int i = 3; i <= totalXY/i; i++) {
            if(totalXY % i == 0 && totalXY/i >= 3) {
                int totalY = i;
                int totalX = totalXY/i;
                System.out.println("totalX : " + totalX + ", totalY : " + totalY);

                for (int[] yellowXYArray : yellowXYList) {
                    if(totalX-2 == yellowXYArray[0]) { // 전체 카펫 가로길이의 -2와 노란부분 가로의 길이가 같은경우 정답
                        answer[0] = totalX;
                        answer[1] = totalY;
                    }
                }
            }
        }

        for (int is : answer) {
            System.out.println(is);
        }
        
        return answer;
    }
}
