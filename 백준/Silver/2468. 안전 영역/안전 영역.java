import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int height = Integer.parseInt(st.nextToken());
                board[i][j] = height;
                maxHeight = Math.max(height, maxHeight);
            }
        }

        int result = 0;

        for (int height = 1; height <= maxHeight; height++) {
            int cnt = 0;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] >= height && !visited[i][j]) {
                        dfs(i, j, height);
                        cnt++;
                    }
                }
                result = Math.max(cnt, result);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void dfs(int x, int y, int height) {

        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (board[nx][ny] >= height && !visited[nx][ny]) {
                    dfs(nx, ny, height);
                }
            }
        }
    }
}
