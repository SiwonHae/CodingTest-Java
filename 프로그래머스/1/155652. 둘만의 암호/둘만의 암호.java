import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        List<String> list = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            list.add(String.valueOf(i));
        }

        String[] jump = skip.split("");
        for (int i = 0; i < jump.length; i++) {
            list.remove(jump[i]);
        }

        String[] str = s.split("");
        for (int i = 0; i < str.length; i++) {
            // 리스트에서의 알파벳 자리 찾기
            int idx = list.indexOf(str[i]);
            idx = (idx + index) % list.size();
            answer += list.get(idx);
        }

        return answer;
    }
}