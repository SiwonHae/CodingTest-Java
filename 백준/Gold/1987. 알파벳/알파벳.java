import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Set<Character> set = new HashSet<>();
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        backtrack(0, 0, 1);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void backtrack(int y, int x, int depth) {
        result = Math.max(result, depth);

        visited[y][x] = true;
        set.add(board[y][x]);

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
                continue;
            }

            if (!visited[ny][nx] && !set.contains(board[ny][nx])) {
                visited[ny][nx] = true;
                backtrack(ny, nx, depth + 1);
                visited[ny][nx] = false;
                set.remove(board[ny][nx]);
            }
        }
    }
}