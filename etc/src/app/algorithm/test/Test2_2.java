package app.algorithm.test;

import java.util.HashSet;
import java.util.Set;

public class Test2_2 {
    
    public static void main(String[] args) {

        System.out.println(solution("abacdec")); //3 (a,bac,dec) (a,bacd,ec) (ab, ac, dec) (ab, acde, c)
        System.out.println(solution("world")); //1
        System.out.println(solution("dddd")); //4
        System.out.println(solution("cycle")); //2 (cy,cle) (c,ycle)
        System.out.println(solution("abba")); //2
    }

    public static int solution(String S) {

        String[] stringArray = S.split("");

        int cnt = 0;

        for (int i = 0; i < stringArray.length - 1; i++) {
            for (int j = i + 1; j < stringArray.length; j++) {
                if(stringArray[i].equals(stringArray[j])) { // 2로
                    cnt++;
                    i = j;
                }
            }
            
        }

        return cnt + 1;
    }
}
