class Solution {
    public int[] solution(int n, long left, long right) {

        // 1 2 3
        // 2 2 3
        // 3 3 3
        // (0, 0), (0, 1), (0, 2)
        // (1, 0), (1, 1), (1, 2)
        // (2, 0), (2, 1), (2, 2)
        // Math.max(행, 열) + 1 이 2차원 배열의 값이다.

        int[] answer = new int[(int) (right - left) + 1];

        int idx = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            answer[idx] = (int) Math.max(row, col) + 1;
            idx++;
        }

        return answer;
    }
}