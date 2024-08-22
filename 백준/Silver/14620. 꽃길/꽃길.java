import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void dfs(int depth, int sum) {
        if (depth >= 3) {
            result = Math.min(result, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isValid(i, j)) {
                    dfs(depth + 1, sum + calc(i, j));
                    clearFlower(i, j); // 원복
                }
            }
        }

    }

    public static boolean isValid(int y, int x) {
        if (visited[y][x]) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) {
                return false;
            }
        }

        return true;
    }

    public static int calc(int y, int x) {

        int sum = board[y][x];

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            sum += board[ny][nx];

            visited[ny][nx] = true;
        }

        return sum;
    }

    public static void clearFlower(int y, int x) {
        visited[y][x] = false;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            visited[ny][nx] = false;
        }
    }
}
