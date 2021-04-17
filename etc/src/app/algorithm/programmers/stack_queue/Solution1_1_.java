package app.algorithm.programmers.stack_queue;

import java.util.*;

public class Solution1_1_ {
    public static void main(String[] args) {

        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {

        Set<String> set = new HashSet<>();
        Arrays.sort(phone_book, (a, b)->Integer.compare(a.length(), b.length()));

        int totalCnt = phone_book.length;
        for (int i = 0; i < phone_book.length - 1; i++) {
            set.add(phone_book[i]);
            int length = phone_book[i].length();
            for (int j = i + 1; j < phone_book.length; j++) {
                set.add(phone_book[j].substring(0, length));
            }
            if(totalCnt-i != set.size()) return false;
            set.clear();
        }

        boolean answer = true;
        return answer;
    }
}
