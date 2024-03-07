import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        answer = n - lost.length;

        // 여벌 체육복 가져왔지만 자기걸 도둑맞은 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -100;
                    reserve[j] = -200;
                    break;
                }
            }
        }

        // 체육복 빌려주는 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] + 1 == lost[i] || reserve[j] - 1 == lost[i]) {
                    answer++;
                    reserve[j] = -200;
                    break;
                }
            }
        }

        return answer;
    }
}