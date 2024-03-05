class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int start = section[0]; // 색칠 시작 지점
        answer++; // 색칠 시작

        for (int i = 1; i < section.length; i++) {

            // 방금 한 색칠로 다음 벽이 색칠되어 있지 않다면 색칠 시작
            if (start + m - 1 < section[i]) {
                start = section[i];
                answer++;
            }
        }

        return answer;
    }
}