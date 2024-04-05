import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            String s = phone_book[i];
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (map.containsKey(s.substring(0, j))) {
                    answer = false;
                    return answer;
                }
            }
        }

        return answer;
    }
}