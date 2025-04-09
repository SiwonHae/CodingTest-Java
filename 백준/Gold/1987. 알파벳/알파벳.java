import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] board;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        dfs(0, 0, 1 << (board[0][0] - 'A'), 1);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void dfs(int y, int x, int num, int cnt) {
        result = Math.max(result, cnt);

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
                continue;
            }

            int next = 1 << (board[ny][nx] - 'A');

            if ((num & next) == 0) {
                dfs(ny, nx, num | next, cnt + 1);
            }
        }
    }
}