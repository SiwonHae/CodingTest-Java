import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            int cnt = 0; // 약수의 개수

            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    cnt++;
                } else if (i % j == 0) {
                    cnt += 2;
                }
            }

            if (cnt > limit) {
                list.add(power);
            } else {
                list.add(cnt);
            }
        }

        for (int i : list) {
            answer += i;
        }

        return answer;
    }
}