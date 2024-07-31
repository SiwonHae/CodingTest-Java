import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int time = 0;
    static int cnt = 0;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    cnt++;
                }
            }
        }

        int currentCnt = 0;
        time = 0;

        while (cnt > 0) {
            currentCnt = cnt;
            time++;
            visited = new boolean[n][m];
            dfs(0, 0);
        }

        bw.write(time + "\n" + currentCnt);
        bw.flush();
    }

    public static void dfs(int y, int x) {

        if (visited[y][x]) {
            return;
        }

        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                if (!visited[ny][nx]) {
                    if (board[ny][nx] == 0) {
                        dfs(ny, nx);
                    } else {
                        board[ny][nx] = 0;
                        cnt--;
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}
