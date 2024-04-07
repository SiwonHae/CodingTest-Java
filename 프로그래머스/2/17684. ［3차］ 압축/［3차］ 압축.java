import java.util.*;

class Solution {
    public int[] solution(String msg) {

        List<Integer> result = new ArrayList<>();

        Map<String, Integer> dictionary = new HashMap<>();
        char alphabet = 'A';
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf(alphabet), i + 1);
            alphabet++;
        }

        int idx = 27;
        int start = 0;
        int end = msg.length();
        while (start < end) {

            String w = msg.substring(start, end);
            while (!dictionary.containsKey(w)) {
                end--;
                w = msg.substring(start, end);
            }

            // 반복문을 나왔다는 것은 사전에 있다는 것.
            result.add(dictionary.get(w));

            // 현재 입력과 다음 글자를 사전에 등록
            if (end < msg.length()) {
                String c = String.valueOf(msg.charAt(end));
                String word = w + c;
                dictionary.put(word, idx++);
            }

            start += w.length();
            end = msg.length();

        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}