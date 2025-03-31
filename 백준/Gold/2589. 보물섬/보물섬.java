import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static int[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        bw.write(String.valueOf(result - 1));
        bw.flush();
    }

    public static void bfs(int startY, int startX) {
        visited = new int[N][M];

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startY, startX));
        visited[startY][startX] = 1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int y = current.y;
            int x = current.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    continue;
                }

                if (visited[ny][nx] == 0 && board[ny][nx] == 'L') {
                    visited[ny][nx] = visited[y][x] + 1;
                    queue.offer(new Point(ny, nx));
                    result = Math.max(result, visited[ny][nx]);
                }
            }
        }
    }

    static class Point {
        int y, x;
        Point (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}