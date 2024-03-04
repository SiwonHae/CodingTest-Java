import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        int boxCnt = score.length / m;
        int index = score.length - 1;
        
        for (int i = 0; i < boxCnt; i++) {
            List<Integer> box = new ArrayList<>();
            int sum = 0;
            int cnt = 0;

            while (cnt != m) {
                box.add(score[index]);
                index--;
                cnt++;
            }

            int min = Collections.min(box);

            answer += min * m;
        }

        return answer;
    }
}