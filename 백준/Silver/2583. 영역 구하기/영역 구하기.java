import java.io.*;
import java.util.*;

public class Main {

    static int M, N, K;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int cnt = 0;
    static int area = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        visited = new boolean[M][N];
        List<Integer> areas = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken()) - 1;
            int ry = Integer.parseInt(st.nextToken()) - 1;

            for (int j = ry; j >= ly; j--) {
                for (int k = rx; k >= lx; k--) {
                    board[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 1 && !visited[i][j]) {
                    dfs(i, j);
                    areas.add(area);
                    cnt++;
                    area = 1;
                }
            }
        }

        bw.write(cnt + "\n");

        Collections.sort(areas);
        for (int i = 0; i < areas.size(); i++) {
            bw.write(areas.get(i) + " ");
        }


        bw.flush();
    }

    public static void dfs(int y, int x) {
        if (visited[y][x]) {
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4 ; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= M || nx < 0 || nx >= N) {
                continue;
            }

            if (visited[ny][nx]) {
                continue;
            }

            if (board[ny][nx] != 1) {
                dfs(ny, nx);
                area++;
            }
        }

    }
}