import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int cheeseCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    cheeseCnt++;
                }
            }
        }

        int currentCheeseCnt = 0;
        int time = 0;

        while (cheeseCnt > 0) {
            currentCheeseCnt = cheeseCnt;
            time++;
            visited = new boolean[N][M];
            dfs(0, 0);
        }

        bw.write(time + "\n" + currentCheeseCnt);
        bw.flush();
    }

    public static void dfs(int y, int x) {

        if (visited[y][x]) {
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                if (!visited[ny][nx]) {
                    if (board[ny][nx] == 0) {
                        dfs(ny, nx);
                    } else if (board[ny][nx] == 1) {
                        board[ny][nx] = 0;
                        cheeseCnt--;
                        visited[ny][nx] = true;
                    }
                }
            }
        }

    }
}