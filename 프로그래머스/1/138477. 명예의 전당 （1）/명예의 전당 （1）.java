import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> honor = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (honor.size() < k) {
                honor.add(score[i]);
            } else {
                int min = Collections.min(honor);
                if (min < score[i]) {
                    honor.remove(Integer.valueOf(min));
                    honor.add(score[i]);
                }
            }

            answer[i] = Collections.min(honor);
        }

        return answer;
    }
}