import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
//    static int result = Integer.MAX_VALUE;
    static int n;
    static int m;

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
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        bw.write(String.valueOf(board[n - 1][m - 1]));
        bw.flush();
    }

    public static void bfs(int startX, int startY) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});

        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (board[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        board[nx][ny] = board[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }


//    public static void dfs(int x, int y, int dist) {
//
//        if (x == n - 1 && y == m - 1) {
//            result = Math.min(result, dist);
//            return;
//        }
//
//        visited[x][y] = true;
//
//        for (int i = 0; i < 4; i++) {
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//
//            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && board[nx][ny] == 1) {
//                dfs(nx, ny, dist + 1);
//            }
//        }
//
//        visited[x][y] = false;
//    }
}
