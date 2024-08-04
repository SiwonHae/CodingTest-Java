import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visited;
    static int N;
    static int maxHeight = 0;
    static int cnt = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(board[i][j], maxHeight);
            }
        }

        for (int i = 1; i <= maxHeight; i++) {
            visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (board[j][k] >= i && !visited[j][k]) {
                        dfs(j, k, i);
                        cnt++;
                    }
                }
            }

            result = Math.max(result, cnt);
            cnt = 0;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void dfs(int y, int x, int height) {

        if (visited[y][x]) {
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                if (board[ny][nx] >= height && !visited[ny][nx]) {
                    dfs(ny, nx, height);
                }
            }
        }
    }
}
