import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static int[][] newBoard;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int result = 0;
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
            }
        }

        makeWall(0);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void makeWall(int wall) { // dfs
        if (wall == 3) {
            makeVirus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    makeWall(wall + 1);
                    board[i][j] = 0; // 원복
                }
            }
        }
    }

    public static void makeVirus() { // bfs
        Queue<int[]> queue = new LinkedList<>();

        newBoard = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newBoard[i][j] == 2) {
                    dfs(i, j);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newBoard[i][j] == 0) {
                    cnt++;
                }
            }
        }

        result = Math.max(result, cnt);
    }

    public static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                if (newBoard[ny][nx] == 0) {
                    newBoard[ny][nx] = 2;
                    dfs(ny, nx);
                }
            }
        }
    }
}
