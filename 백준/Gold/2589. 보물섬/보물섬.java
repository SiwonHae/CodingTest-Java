import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);
                if (c == 'L') {
                    board[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        bw.write(String.valueOf(result - 1));
        bw.flush();
    }

    public static void bfs(int startY, int startX) {

        visited = new int[N][M];

        Queue<int []> queue = new LinkedList<>();
        visited[startY][startX] = 1;
        queue.add(new int[] {startY, startX});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (visited[ny][nx] == 0 && board[ny][nx] != 0) {
                        visited[ny][nx] = visited[y][x] + 1;
                        queue.add(new int[] {ny, nx});
                        result = Math.max(result, visited[ny][nx]);
                    }
                }
            }
        }
    }
}