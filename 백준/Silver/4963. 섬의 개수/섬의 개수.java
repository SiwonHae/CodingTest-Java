import java.io.*;
import java.util.*;

public class Main {

    static int w, h;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1}; // 상하좌우 + 좌상,우상,좌하,우하
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1}; // 상하좌우 + 좌상,우상,좌하,우하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int result = 0;

            if (w == 0 && h == 0) {
                return;
            }

            board = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        result++;
                    }
                }
            }

            bw.write(result + "\n");
            bw.flush();
        }
    }

    public static void dfs(int y, int x) {
        if (visited[y][x]) {
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
                continue;
            }

            if (!visited[ny][nx] && board[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }
}