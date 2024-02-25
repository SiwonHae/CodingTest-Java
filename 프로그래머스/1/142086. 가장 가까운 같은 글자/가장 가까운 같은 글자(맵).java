import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<String, Integer> map = new HashMap<>();
        String[] str = s.split("");

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(str[i])) {
                // 앞에서 이미 문자가 등장했을 때
                answer[i] = i - map.get(str[i]);
            } else {
                // 앞에서 문자가 등장하지 않았을 때
                answer[i] = -1;
            }
            map.put(str[i], i); // 문자의 마지막 인덱스를 저장
        }


        return answer;
    }
}
