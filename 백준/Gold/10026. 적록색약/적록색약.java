import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0 ,0};
    static int[] dx = {0, 0, -1, 1};
    static int result1, result2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    result1++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'G') {
                    board[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    result2++;
                }
            }
        }

        bw.write(result1 + " " + result2);
        bw.flush();
    }

    public static void bfs(int startY, int startX) {
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(startY, startX));
        visited[startY][startX] = true;

        char target = board[startY][startX];

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int y = current.y;
            int x = current.x;

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + y;
                int nx = dx[i] + x;

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                    continue;
                }

                if (board[ny][nx] == target && !visited[ny][nx]) {
                    queue.offer(new Point(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}