package app.algorithm.programmers.stack_queue;

import java.util.*;

public class Solution1_2_ {
    public static void main(String[] args) {

        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book, (a, b)->Integer.compare(a.length(), b.length()));

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if(phone_book[i].startsWith(phone_book[j])) return false;
                if(phone_book[j].startsWith(phone_book[i])) return false;
            }
        }

        boolean answer = true;
        return answer;
    }
}
