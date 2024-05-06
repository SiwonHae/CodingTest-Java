class Solution {

    // x축 변화량 (아래, 오른쪽, 왼쪽 위)
    private static final int[] dx = {0, 1, -1};
    // y축 변화량 (아래, 오른쪽, 왼쪽 위)
    private static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        // 밑변의 길이와 높이가 n인 삼각형
        // n = 6
        // 1
        // 2  15
        // 3  16  14
        // 4  17  21  13
        // 5  18  19  20  12
        // 6   7   8   9  10  11

        int[][] board = new int[n][n];

        int x = 0;
        int y = 0;
        int d = 0; // dx, dy를 위한 방향 변수
        int v = 1;

        while (true) {
            board[y][x] = v++;

            int nx = x + dx[d]; // 다음 x 위치
            int ny = y + dy[d]; // 다음 y 위치

            if (nx == n || ny == n || nx == -1 || ny == -1 || board[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];

                if (nx == n || ny == n || nx == -1 || ny == -1 || board[ny][nx] != 0) {
                    break;
                }
            }

            x = nx;
            y = ny;
        }

        int[] answer = new int[v - 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = board[i][j];
            }
        }

        return answer;
    }
}