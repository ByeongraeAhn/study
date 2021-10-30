package algorithm.programmers.bp;

import java.util.ArrayList;
import java.util.List;

public class Solution2_2 {
    public static void main(String[] args) {

        solution(24, 24);
        //solution(8, 1);
        //solution(10, 2);
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        //전체 카펫 약수
        int totalXY = brown + yellow;
        //System.out.println("총갯수 : " + totalXY);
        for (int i = 3; i <= totalXY/i; i++) {
            if(totalXY % i == 0 && totalXY/i >= 3) {
                int totalY = i;
                int totalX = totalXY/i;
                //System.out.println("totalX : " + totalX + ", totalY : " + totalY);
                if((totalY-2)*(totalX-2) == yellow) {
                    answer[0] = totalX;
                    answer[1] = totalY;
                }
            }
        }

        for (int is : answer) {
            //System.out.println(is);
        }
        
        return answer;
    }
}
