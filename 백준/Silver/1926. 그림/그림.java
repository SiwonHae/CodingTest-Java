import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int cnt, area, tmp = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                    area = Math.max(area, tmp);
                    tmp = 1;
                }
            }
        }

        bw.write(cnt + "\n" + area);
        bw.flush();
    }

    public static void bfs(int startY, int startX) {
        Deque<Point> queue = new ArrayDeque<>();

        queue.offer(new Point(startY, startX));
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int y = current.y;
            int x = current.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    continue;
                }

                if (!visited[ny][nx] && board[ny][nx] == 1) {
                    queue.offer(new Point(ny, nx));
                    visited[ny][nx] = true;
                    tmp++;
                }
            }

        }
    }

    public static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}