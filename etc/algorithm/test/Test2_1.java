package algorithm.test;

import java.util.HashSet;
import java.util.Set;

public class Test2_1 {
    
    public static void main(String[] args) {

        System.out.println(solution("abacdec")); //3 (a,bac,dec) (a,bacd,ec) (ab, ac, dec) (ab, acde, c)
        System.out.println(solution("world")); //1
        System.out.println(solution("dddd")); //4
        System.out.println(solution("cycle")); //2 (cy,cle) (c,ycle)
        System.out.println(solution("abba")); //2
    }

    public static int solution(String S) {

        int result = 0;
        Set<String> tmp = new HashSet<>();

        for (int i = 0; i < S.length(); i++) {
            String partial = S.substring(i, i + 1);
            if (tmp.contains(partial)) {
                result++;
                tmp.clear();
            }
            tmp.add(partial);
        }

        return result + 1;
    }
}
