import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int cnt = 0; // 일치하는 번호 수
        int zeroCnt = 0; // 0 번호 수
        int newCnt = 0; // 일치하는 번호 수 + 0 번호수
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (win_nums[i] == lottos[j]) {
                    cnt++;
                }
            }
            if (lottos[i] == 0) {
                zeroCnt++;
            }
        }

        newCnt = cnt + zeroCnt;

        if (cnt == 0) {
            answer[1] = 6;
        } else if (cnt == 1) {
            answer[1] = 6;
        } else if (cnt == 2) {
            answer[1] = 5;
        } else if (cnt == 3) {
            answer[1] = 4;
        } else if (cnt == 4) {
            answer[1] = 3;
        } else if (cnt == 5) {
            answer[1] = 2;
        } else if (cnt == 6) {
            answer[1] = 1;
        }

        if (newCnt == 0) {
            answer[0] = 6;
        } else if (newCnt == 1) {
            answer[0] = 6;
        } else if (newCnt == 2) {
            answer[0] = 5;
        } else if (newCnt == 3) {
            answer[0] = 4;
        } else if (newCnt == 4) {
            answer[0] = 3;
        } else if (newCnt == 5) {
            answer[0] = 2;
        } else if (newCnt == 6) {
            answer[0] = 1;
        }

        return answer;
    }
}