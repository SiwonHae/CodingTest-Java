class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;

        // 최소 가로와 세로는 3 이상임

        for (int i = 3; i <= sum / 2; i++) {
            for (int j = 3; j <= sum / 2; j++) {
                if (i * j == sum) {
                    // 세로가 i, 가로가 j 임.
                    // 이때 노란색이 다 들어가는지 검증 필요함.

                    int width = (j - 2) * 2; // 가로
                    int height = i * 2; // 세로

                    if (sum - (width + height) == yellow) {
                        answer[1] = i;
                        answer[0] = j;
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}