import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[][] board;
    static boolean[][] visited;

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

        boolean flag = false;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'W') {
                    flag = dfs(i, j);

                    if (!flag) {
                        bw.write("0");
                        bw.flush();
                        return;
                    }
                }
            }
        }

        bw.write("1\n");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
    }

    public static boolean dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
                continue;
            }

            if (board[ny][nx] == 'S') { // 늑대 바로 옆에 양이 있으면 안된다.
                return false;
            } else if (board[ny][nx] == '.') {
                board[ny][nx] = 'D';
            }
        }

        return true;
    }
}