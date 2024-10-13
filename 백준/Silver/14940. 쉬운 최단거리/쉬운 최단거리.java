import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[][] resultBoard;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        resultBoard = new int[n][m];
        visited = new boolean[n][m];

        Point start = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 2) {
                    start = new Point(i, j);
                } else if (board[i][j] == 0) {
                    resultBoard[i][j] = 0;
                } else {
                    resultBoard[i][j] = -1;
                }

            }
        }

        bfs(start.y, start.x);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(resultBoard[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }

    public static int bfs(int y, int x) {

        Queue<Point> queue = new LinkedList<>();

        visited[y][x] = true;
        queue.add(new Point(y, x));
        resultBoard[y][x] = 0;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int cy = current.y;
            int cx = current.x;

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx]) {
                    continue;
                }

                if (board[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    resultBoard[ny][nx] = resultBoard[cy][cx] + 1;
                    queue.add(new Point(ny, nx));
                }
            }
        }

        return -1;
    }
}

class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}