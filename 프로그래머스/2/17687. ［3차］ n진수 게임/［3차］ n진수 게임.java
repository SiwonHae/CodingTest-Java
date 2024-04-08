import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        // 2진법 0 1 1 0 1 1 1 0
        // 2명이서 진행 할 때
        // 1번 : 0 1 1 1
        // 2번 : 1 0 1 0

        String radixString = "";
        for (int i = 0; i < t * m; i++) {
            radixString += Integer.toString(i, n);
        }

        Map<Integer, String> map = new HashMap<>();
        int order = 1;
        for (int i = 0; i < radixString.length(); i++) {
            if (order == m + 1) {
                order = 1;
            }
            map.put(order, map.getOrDefault(order, "") + radixString.charAt(i));
            order++;
        }

        answer = map.get(p).substring(0, t).toUpperCase();

        return answer;
    }
}