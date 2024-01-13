class Solution {
    public int solution(int[][] dots) {
        int answer = 0;

        int width = 0;
        int height = 0;

        for (int i = 0; i < 4; i++) {
            if (dots[0][1] == dots[i][1]) {
                width = Math.abs(dots[i][0] - dots[0][0]);
            }
            if (dots[0][0] == dots[i][0]) {
                height = Math.abs(dots[i][1] - dots[0][1]);
            }
        }

        answer = width * height;

        return answer;
    }
}