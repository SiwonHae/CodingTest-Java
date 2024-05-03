class Solution {
    public int[] solution(int n) {
        // 밑변의 길이와 높이가 n인 삼각형
        // n = 6
        // 1
        // 2  15
        // 3  16  14
        // 4  17  21  13
        // 5  18  19  20  12
        // 6   7   8   9  10  11

        int[] answer = new int[(n * (n + 1)) / 2];

        int[][] board = new int[n][n];

        int y = -1;
        int x = 0;
        int value = 1;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                // 아래로
                if (i % 3 == 0) {
                    y++;
                } else if (i % 3 == 1) {
                    // 오른쪽으로
                    x++;
                } else if (i % 3 == 2) {
                    // 왼쪽 위 대각선으로
                    y--;
                    x--;
                }
                board[y][x] = value++;
            }
        }

        int idx = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j <= i; j++) {
                answer[idx++] = board[i][j];
            }
        }

        return answer;
    }
}