import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        List<Integer> valueSet = new ArrayList<>(map.values());

        // (의상1 + 1) * (의상2 + 1) ... 반복
        // +1은 해당 의상을 안입었을 경우
        for (int i : valueSet) {
            answer *= i + 1;
        }

        answer--; // 모두 다 안입었을 경우의 수 제외

        return answer;
    }
}