import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int result = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, board[i][j]);
            }
        }

        for (int i = 1; i <= maxHeight; i++) {
            int cnt = 0;
            visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (board[j][k] > i && !visited[j][k]) {
                        dfs(j, k, i);
                        cnt++;
                    }
                }
            }

            result = Math.max(result, cnt);
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void dfs(int y, int x, int maxHeight) {

        if (visited[y][x]) {
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                continue;
            }

            if (board[ny][nx] > maxHeight && !visited[ny][nx]) {
                dfs(ny, nx, maxHeight);
            }
        }

    }
}