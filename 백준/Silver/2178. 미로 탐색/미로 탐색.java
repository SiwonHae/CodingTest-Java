import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] board;
    static int[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                board[i][j] = c - '0';
            }
        }

        bfs(0, 0);

        bw.write(String.valueOf(board[N - 1][M - 1]));
        bw.flush();
    }

    public static void bfs(int startY, int startX) {

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(startY, startX));
        visited[startY][startX] = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int y = p.y;
            int x = p.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    continue;
                }

                if (visited[ny][nx] == 1 || board[ny][nx] == 0) {
                    continue;
                }

                board[ny][nx] = board[y][x] + 1;
                visited[ny][nx] = 1;
                queue.add(new Point(ny, nx));

            }
        }

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